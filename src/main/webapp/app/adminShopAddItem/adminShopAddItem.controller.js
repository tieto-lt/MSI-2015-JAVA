(function(angular) {
	'use strict';

	angular.module('app.adminShopAddItem').controller(
			'AdminShopAddItemController', AdminShopAddItemController);

	AdminShopAddItemController.$inject = [ 'ShopItemFactory' ];

	function AdminShopAddItemController(AdminShopAddItemFactory) {
		var vm = this;

		vm.transferInfo = {
			name : 'Umbrella',
			price : 400,
			amount: 20,
			description: 'Whooohooo',
			photo: ''
		};

//		function
//		vm.save = save;

		/*
		 * Send new monthly, one time limits to server
		 */
//		function save() {
//			vm.successMessage = '';
//			vm.errorMessage = '';
//
//			AdminAppSettingsFactory.saveSettings(vm.transferInfo).then(
//					function() {
//						vm.successMessage = 'Transfer was successful';
//						vm.transferInfo.monthlyLimit = '';
//						vm.transferInfo.oneTimePointsLimit = '';
//						vm.settingsForm.$setPristine();
//						vm.settingsForm.$setUntouched();
//						getKarmaLimits();
//					}, function() {
//						vm.errorMessage = 'Transfer failed';
//						vm.transferInfo.monthlyLimit = '';
//						vm.transferInfo.oneTimePointsLimit = '';
//						vm.settingsForm.$setPristine();
//						getKarmaLimits();
//					})
//		}
	}
})(window.angular);