/**
 * 新增商户
 */
var vm = new Vue({
	el:'#app',
	data: {
		business: {
			f_id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/business/save?_' + $.now(),
		    	param: vm.business,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
