/**
 * 商户
 */

$(function () {
	initialPage();
	getGrid();
});

function initialPage() {
	$(window).resize(function() {
		$('#dataGrid').bootstrapTable('resetView', {height: $(window).height()-56});
	});
}

function getGrid() {
	$('#dataGrid').bootstrapTableEx({
		url: '../../sys/business/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
            {field : "fid", title : "编号", width : "100px"},
            {field : "fName", title : "名称", width : "100px"},
            {field : "fDept", title : "所属辖区代码", width : "100px"},
            {field : "fAddr", title : "地址", width : "100px"},
            {field : "fTel", title : "电话", width : "100px"},
            {field : "fMobile", title : "手机", width : "100px"},
            {field : "fState", title : "是否安装监控", width : "100px"},
            {field : "fInstdate", title : "安装时间", width : "100px"},
            {title : "操作", formatter : function(value, row, index) {
                    var _html = '';
                    if (hasPermission('sys:business:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.f_id+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
                    }
                    if (hasPermission('sys:business:remove')) {
                        _html += '<a href="javascript:;" onclick="vm.remove(false,\''+row.f_id+'\')" title="删除"><i class="fa fa-trash-o"></i></a>';
                    }
                    return _html;
                }
            }
		]
	})
}

var vm = new Vue({
	el:'#app',
	data: {
		keyword: null
	},
	methods : {
		load: function() {
			$('#dataGrid').bootstrapTable('refresh');
		},
		save: function() {
			dialogOpen({
				title: '新增',
				url: 'base/business/add.html?_' + $.now(),
				width: '420px',
				height: '350px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function(f_id) {
            dialogOpen({
                title: '编辑',
                url: 'base/business/edit.html?_' + $.now(),
                width: '420px',
                height: '350px',
                success: function(iframeId){
                    top.frames[iframeId].vm.business.f_id = f_id;
                    top.frames[iframeId].vm.setForm();
                },
                yes: function(iframeId){
                    top.frames[iframeId].vm.acceptClick();
                }
            });
        },
        remove: function(batch, f_id) {
            var ids = [];
            if (batch) {
                var ck = $('#dataGrid').bootstrapTable('getSelections');
                if (!checkedArray(ck)) {
                    return false;
                }
                $.each(ck, function(idx, item){
                    ids[idx] = item.f_id;
                });
            } else {
                ids.push(f_id);
            }
            $.RemoveForm({
                url: '../../sys/business/remove?_' + $.now(),
                param: ids,
                success: function(data) {
                    vm.load();
                }
            });
        }
	}
})