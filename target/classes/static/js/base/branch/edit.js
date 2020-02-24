/**
 * 编辑-机构js
 */
var vm = new Vue({
	el:'#app',
	data: {
		branch: {
			id: 0000,
			deptname: null
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sys/branch/info?_' + $.now(),
		    	param: vm.branch.id,
		    	success: function(data) {
		    		vm.branch = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sys/branch/update?_' + $.now(),
		    	param: vm.branch,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})