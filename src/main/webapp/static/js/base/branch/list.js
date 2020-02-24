/**
 * 机构js
 */

$(function() {
	initialPage();
	getGrid();
});

function initialPage() {
	$("#treePanel").css('height', $(window).height()-54);
	$(window).resize(function() {
		$("#treePanel").css('height', $(window).height()-54);
		$('#dataGrid').bootstrapTable('resetView', {
			height : $(window).height() - 108
		});
	});
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url : '../../sys/branch/list?_' + $.now(),
		height : $(window).height() - 108,
		queryParams : function(params) {
			params.name = vm.keyword;
			params.dept = vm.dept;
			return params;
		},
		pagination : false,
		columns : [ {
			checkbox : true
		}, {
			field : "id",
			title : "机构编号",
			width : "60px"
		}, {
			field : "name",
			title : "机构名称",
			width : "30%"
		}, {
			field : "level",
			title : "层级",
			width : "60px",
			formatter : function(value, row, index) {
				if (value == 3) {
					return '<span class="label label-primary">地市</span>';
				}
				if (value == 2) {
					return '<span class="label label-success">区县</span>';
				}
				if (value == 1) {
					return '<span class="label label-warning">街道</span>';
				}
			}
		}, {
			field : "addr",
			title : "地址",
			width : "30%"
		}, {
			field : "tel",
			title : "电话",
			width : "10%"
		}, {
            title : "操作",
            formatter : function (value, row, index) {
                var _html = '';
                if (hasPermission('sys:branch:edit')) {
                    _html += '<a href="javascript:;" onclick="vm.edit(\''+row.id+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
                }
                if (hasPermission('sys:branch:remove')) {
                    _html += '<a href="javascript:;" onclick="vm.remove(false,\''+row.id+'\')" title="删除"><i class="fa fa-trash-o"></i></a>';
                }
                if (hasPermission('sys:branch:save')) {
                    _html += '<a href="javascript:;" onclick="vm.saveChild(\''+row.id+'\',\''+row.name+'\',\''+row.deptid+'\')" title="新增下级机构"><i class="fa fa-plus-square"></i></a>';
                }
                return _html;
            }
        }  ]
	})
}

var setting = {
	async : {
		enable: true,
		type: "get",
		url: "../../sys/branch/select",
		autoParam: ["id"]
	},
	data : {
		simpleData : {
			enable : true,
			idKey : "id",
			pIdKey : "dept",
			rootPId : "0"
		},
		key : {
			url : "nourl"
		}
	},
	callback : {
		onClick : function(event, treeId, treeNode) {
			vm.dept = treeNode.id;
			vm.deptname = treeNode.name;
			vm.deptid = treeNode.deptid;
			vm.load();
		}
	}
};
var ztree;

var vm = new Vue({
	el : '#app',
	data : {
		keyword : null,
		dept : '0000',
		deptid : null,
		deptname : null
	},
	methods : {
		load : function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		getBranch : function(dept) {
			$.get('../../sys/branch/select', {id: dept},function(r) {
				ztree = $.fn.zTree.init($("#branchTree"), setting, r);
			})
		},
		save : function() {
			dialogOpen({
				title : '新增机构',
				url : 'base/branch/add.html?_' + $.now(),
				width : '500px',
				height : '456px',
				success : function(iframeId) {
					top.frames[iframeId].vm.branch.dept = vm.dept;
					top.frames[iframeId].vm.branch.deptname = vm.deptname;
					top.frames[iframeId].vm.branch.deptid = vm.deptid;
				},
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
        saveChild : function(id, name ,deptid) {
            dialogOpen({
                title : '新增机构1',
                url : 'base/branch/add.html?_' + $.now(),
                width : '500px',
                height : '456px',
                success : function(iframeId) {
                    top.frames[iframeId].vm.branch.dept = id;
                    top.frames[iframeId].vm.branch.deptname = name;
					top.frames[iframeId].vm.branch.deptid = deptid;
                },
                yes : function(iframeId) {
                    top.frames[iframeId].vm.acceptClick();
                }
            });
        },
        edit : function(id) {
            dialogOpen({
                title : '编辑机构',
                url : 'base/branch/edit.html?_' + $.now(),
                width : '500px',
                height : '456px',
                success : function(iframeId) {
                    top.frames[iframeId].vm.branch.id = id;
                    top.frames[iframeId].vm.setForm();
                },
                yes : function(iframeId) {
                    top.frames[iframeId].vm.acceptClick();
                }
            });
        },
        remove : function(batch, id) {
            var ids = [];
            if (batch) {
                var ck = $('#dataGrid').bootstrapTable('getSelections');
                if (!checkedArray(ck)) {
                    return false;
                }
                $.each(ck, function(idx, item) {
                    ids[idx] = item.id;
                });
            } else {
                ids.push(id);
            }
            $.RemoveForm({
                url: '../../sys/branch/remove?_' + $.now(),
                param: ids,
                success: function(data) {
                    vm.load();
                }
            });
        }
	},
	created : function() {
		this.getBranch(this.dept);
	}
})