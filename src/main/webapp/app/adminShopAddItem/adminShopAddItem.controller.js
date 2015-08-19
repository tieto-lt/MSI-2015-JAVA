(function(angular) {
	'use strict';

	angular.module('app.adminShopAddItem').controller(
			'AdminShopAddItemController', AdminShopAddItemController);

	AdminShopAddItemController.$inject = [ 'ShopItemFactory', '$stateParams', '$state', '$scope',  '$mdDialog' ];

	function AdminShopAddItemController(ShopItemFactory, $stateParams, $state, $scope, $mdDialog) {
		var vm = this;

		vm.transferInfo = {
			name : '',
			price : '',
			amount: '',
			description: '',
			image: '',
			imageName: '',
			imageType: ''
		};

		if ($stateParams.id) {
			vm.id = $stateParams.id;
			getEditItem();
		}
		
		vm.submit = submit;
		vm.getEditItem = getEditItem;
		vm.updateItem = updateItem;
		vm.deleteItem = deleteItem;
		vm.updatePicture = updatePicture;
		vm.showDeleteConfirmation = showDeleteConfirmation;

		function updatePicture() {
			var f = document.getElementById('add-item-photo').files[0];
			var r = new FileReader();
			
			vm.transferInfo.imageName = f.name;
			vm.transferInfo.imageType = f.type;
			
			r.onload = function(e) {
				vm.transferInfo.image = e.target.result;
				$scope.$apply();
			}
			
			r.readAsDataURL(f);
		}
		
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
					$state.go('adminPage.shop');
				})
				
				
			}
			r.readAsDataURL(f);
		}
		
		function updateItem() {
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
						$state.go('adminPage.shop');
					})
				}
				
				r.readAsDataURL(f);
			} else {
				ShopItemFactory.updateItem(vm.transferInfo).then(function() {
					$state.go('adminPage.shop');
				});
			}	
		}
		
		function getEditItem() {
			ShopItemFactory.getShopItem(vm.id).then(function(response) {
				vm.transferInfo = {
						id: response.data.id,
						name: response.data.name,
						price: response.data.value,
						amount: response.data.quantity,
						description: response.data.description,
						image:  atob(response.data.image),
						imageName: response.data.imageName,
						imageType: response.data.imageType,
						dateAdded: response.data.dateAdded
				};
			});
		}

		function deleteItem() {
			ShopItemFactory.deleteItem(vm.id);
		}
		
		function showDeleteConfirmation(event, redirectAction, item) {
	    	var options = {
	    		controller: function DeleteItemDialogController($mdDialog, ShopItemFactory) {
	    			var vm = this;
	    			
	    			vm.ok = function () {
	    				ShopItemFactory.deleteItem(vm.item.id).then(function() {
	    					$mdDialog.hide();
	    					redirectAction('adminPage.shop');
	    				});
	    			}
	    			vm.cancel = function () {
	    				$mdDialog.cancel();
	    			}
	    		},
	    		controllerAs: 'vm',
	    		locals: {
	    			item: item
	    		},
	    		bindToController: true,
	    		parent: angular.element(document.body),
	    		targetEvent: event,
	    		templateUrl: 'app/deleteItemDialog/deleteItemDialog.tmpl.html'
	    	};
	    	
	    	$mdDialog.show(options);
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