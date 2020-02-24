/**
 * 新增-机构js
 */
var vm = new Vue({
	el:'#app',
	data: {
		branch: {
			dept: 0000,
			deptid: null,
			deptname: null
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/branch/save?_' + $.now(),
		    	param: vm.branch,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
