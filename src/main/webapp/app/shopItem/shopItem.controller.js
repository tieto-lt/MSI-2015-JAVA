(function (angular) {
  'use strict';

  angular
    .module('app.shopItem')
    .controller('ShopItemController', ShopItemController);

  ShopItemController.$inject = ['ShopItemFactory', '$mdDialog', 'ProfileHeaderFactory', 'ItemDescriptionFactory', 'ConfirmationDialogFactory'];

  function ShopItemController(ShopItemFactory, $mdDialog, ProfileHeaderFactory, ItemDescriptionFactory, ConfirmationDialogFactory) {
    var vm = this;
    
    vm.decodeImage = decodeImage;
    vm.showBuyConfirmation = showBuyConfirmation;
    
    vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
    
    vm.shopItems = [];
    refreshItems();
    
    function refreshItems() {
    	ShopItemFactory.getShopItems().then(function (response) {
        	vm.shopItems = response.data;
    	});
    }
    
    function decodeImage(image) {
    	return atob(image);
    }
    
    function showBuyConfirmation(item, event) {
    	var okAction = function () {
			ItemDescriptionFactory.buy(vm.profileInfo.id, item.id).then(function() {
				ProfileHeaderFactory.loadUserInfo();
				ShopItemFactory.getItem(item.id);
				refreshItems();
				$mdDialog.hide();
				ConfirmationDialogFactory.showSimpleDialog(
					{
						message: "We will contact you soon about delivery.",
						title: "Congratulations!"
					}, event, function() {
		    				$mdDialog.hide();
					}
				);
			});
		}
    	var cancelAction = function () {
			$mdDialog.cancel();
		}
    	ConfirmationDialogFactory.showConfirmationDialog(
    			"Are you sure you want to spend " + item.value + " karma points on " + item.name + "?", event,
    			okAction, cancelAction);
    }
  }
  

})(window.angular);