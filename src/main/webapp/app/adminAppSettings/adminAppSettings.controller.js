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
	
		function checkInputs() {
			if (vm.transferInfo.monthlyLimit < vm.transferInfo.oneTimePointsLimit) {
				return false;
			}
			else {
				return true;
			}
		}
	}
})(window.angular);