/**
 * 商户管理
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
		url: '../../sys/restaurant/list?_' + $.now(),
		height: $(window).height()-56,
		queryParams: function(params){
			params.name = vm.keyword;
			return params;
		},
		columns: [
			{checkbox: true},
            {field : "id", title : "编号", width : "80px"},
            {field : "name", title : "名称", width : "180px"},
            {field : "dept", title : "所属辖区", width : "100px"},
            {field : "addr", title : "地址", width : "180px"},
            {field : "tel", title : "电话", width : "100px"},
            {field : "mobile", title : "手机", width : "100px"},
            {field : "state", title : "是否安装监控", width : "100px"},
            {field : "instdate", title : "安装时间", width : "100px"},
            {title : "操作", formatter : function(value, row, index) {
                    var _html = '';
                    if (hasPermission('sys:restaurant:edit')) {
                        _html += '<a href="javascript:;" onclick="vm.edit(\''+row.id+'\')" title="编辑"><i class="fa fa-pencil"></i></a>';
                    }
                    if (hasPermission('sys:restaurant:remove')) {
                        _html += '<a href="javascript:;" onclick="vm.remove(false,\''+row.id+'\')" title="删除"><i class="fa fa-trash-o"></i></a>';
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
				title: '新增商户',
				url: 'base/restaurant/add.html?_' + $.now(),
				width: '420px',
				height: '350px',
				yes : function(iframeId) {
					top.frames[iframeId].vm.acceptClick();
				},
			});
		},
		edit: function(id) {
            dialogOpen({
                title: '编辑商户',
                url: 'base/restaurant/edit.html?_' + $.now(),
                width: '420px',
                height: '350px',
                success: function(iframeId){
                    top.frames[iframeId].vm.sysRestaurant.id = id;
                    top.frames[iframeId].vm.setForm();
                },
                yes: function(iframeId){
                    top.frames[iframeId].vm.acceptClick();
                }
            });
        },
        remove: function(batch, id) {
            var ids = [];
            if (batch) {
                var ck = $('#dataGrid').bootstrapTable('getSelections');
                if (!checkedArray(ck)) {
                    return false;
                }
                $.each(ck, function(idx, item){
                    ids[idx] = item.id;
                });
            } else {
                ids.push(id);
            }
            $.RemoveForm({
                url: '../../sys/restaurant/remove?_' + $.now(),
                param: ids,
                success: function(data) {
                    vm.load();
                }
            });
        }
	}
})