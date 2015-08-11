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
		
		/*
		 * Send new monthly, one time limits to server
		 */
		function save() {
			vm.actionMessage = '';
	    	vm.errorMessage = '';
	    	
	    	AdminAppSettingsFactory
	    		.saveSettings(vm.transferInfo)
	    		.then(function() {
	    			vm.successMessage = 'Transfer was successful';	    			
	    			vm.transferInfo.monthlyLimit = '';
	    			vm.transferInfo.oneTimePointsLimit = '';
	    			vm.settingsForm.$setPristine();
	    			vm.settingsForm.$setUntouched();
	    		}, function() {
	    			vm.errorMessage = 'Transfer failed';
	    			vm.transferInfo.monthlyLimit = '';
	    			vm.transferInfo.oneTimePointsLimit = '';
	    			vm.pointsForm.$setPristine();
	    		})
		}
	}
})(window.angular);