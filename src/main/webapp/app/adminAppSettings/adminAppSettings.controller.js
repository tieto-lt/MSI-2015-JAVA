(function(angular) {
	'use strict';

	angular
		.module('app.adminAppSettings')
		.controller('AdminAppSettingsController', AdminAppSettingsController);

	AdminAppSettingsController.$inject = [ 'AdminAppSettingsFactory' ];
	

	function AdminAppSettingsController(AdminAppSettingsFactory) {
		var vm = this;
		
		vm.transferInfo = {
			      monthlyLimit: '',
			      oneTimePointsLimit: ''
			    };
		
		vm.save = save;
		
		function save() {
			if (vm.monthlyLimit < vm.oneTimePointsLimit) {
				
			}
		}
	}

})(window.angular);