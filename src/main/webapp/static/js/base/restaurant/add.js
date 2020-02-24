/**
 * 新增-商户管理
 */
var vm = new Vue({
	el:'#app',
	data: {
		sysRestaurant: {
			id: 0
		}
	},
	methods : {
		acceptClick: function() {
			if (!$('#form').Validform()) {
		        return false;
		    }
		    $.SaveForm({
		    	url: '../../sys/restaurant/save?_' + $.now(),
		    	param: vm.sysRestaurant,
		    	success: function(data) {
		    		$.currentIframe().vm.load();
		    	}
		    });
		}
	}
})
