/**
 * 编辑-商户管理
 */
var vm = new Vue({
	el:'#app',
	data: {
		sysRestaurant: {
			id: 0
		}
	},
	methods : {
		setForm: function() {
			$.SetForm({
				url: '../../sys/restaurant/info?_' + $.now(),
		    	param: vm.sysRestaurant.id,
		    	success: function(data) {
		    		vm.sysRestaurant = data;
		    	}
			});
		},
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.ConfirmForm({
		    	url: '../../sys/restaurant/update?_' + $.now(),
		    	param: vm.sysRestaurant,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})