(function(angular) {
	'use strict';

	angular.module('app.adminShopAddItem').controller(
			'AdminShopAddItemController', AdminShopAddItemController);

	AdminShopAddItemController.$inject = [ 'ShopItemFactory' ];

	function AdminShopAddItemController(ShopItemFactory) {
		var vm = this;

		vm.transferInfo = {
			name : 'Umbrella',
			price : 400,
			amount: 20,
			description: 'Whooohooo',
			image: '',
			imageName: '',
			imageType: ''
		};

		vm.submit = submit;
		vm.getEditItem = getEditItem;
		vm.update = update;

		function submit() {
			var f = document.getElementById('add-item-photo').files[0];
			var r = new FileReader();
			
			vm.transferInfo.imageName = f.name;
			vm.transferInfo.imageType = f.type;
			
			r.onload = function(e) {
				vm.transferInfo.image = e.target.result;
				// send you binary data via $http or $resource or do anything
				// else with it
				ShopItemFactory.addNewShopItem(vm.transferInfo).then(function() {
					
				})
				
				
			}
			r.readAsDataURL(f);
		}
		
		function update() {
			var f = document.getElementById('add-item-photo').files[0];
			
			if (f) {
				var r = new FileReader();
				
				vm.transferInfo.imageName = f.name;
				vm.transferInfo.imageType = f.type;
			
				r.onload = function(e) {
						vm.transferInfo.image = e.target.result;
					// send you binary data via $http or $resource or do anything
					// else with it
					ShopItemFactory.updateItem(vm.transferInfo).then(function() {
						
					})
				}
				
				r.readAsDataURL(f);
			} else {
				ShopItemFactory.updateItem(vm.transferInfo).then(function() {
					
				});
			}	
		}
		
		function getEditItem(id) {
			ShopItemFactory.getShopItem(id).then(function(response) {
				vm.transferInfo = {
						id: response.data.id,
						name: response.data.name,
						price: response.data.value,
						amount: response.data.quantity,
						description: response.data.description,
						image:  atob(response.data.image),
						imageName: response.data.imageName,
						imageType: response.data.imageType
				};
			});
		}

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