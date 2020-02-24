/**
 * 编辑商户
 */
var vm = new Vue({
	el:'#app',
	data: {
		business: {
			f_id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sys/business/info?_' + $.now(),
		    	param: vm.business.f_id,
		    	success: function(data) {
		    		vm.business = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sys/business/update?_' + $.now(),
		    	param: vm.business,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})