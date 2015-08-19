(function (angular) {
  'use strict';

  angular
    .module('app.shopItem')
    .controller('ShopItemController', ShopItemController);

  ShopItemController.$inject = ['ShopItemFactory', '$mdDialog'];

  function ShopItemController(ShopItemFactory, $mdDialog) {
    var vm = this;
    
    vm.decodeImage = decodeImage;
    vm.showBuyConfirmation = showBuyConfirmation;
    vm.a = 'a';

//    vm.shopItem = ShopItemFactory.getShopItem($routeParams.id);
    vm.shopItems = [];
    ShopItemFactory.getShopItems().then(function (response) {
    	vm.shopItems = response.data;
	}) ;
    
    function decodeImage(image) {
    	return atob(image);
    }
    
    function showBuyConfirmation(item, event) {
        var confirm = $mdDialog.confirm()
              .title('Confirm your purchase')
              .content('Are you sure you want to spend ' + item.value + ' karma points on ' + item.name + '?')
              .ok('No')
              .cancel('Yes')
              .ariaLabel('qweqweqweqwe')
              .targetEvent(event);
        $mdDialog.show(confirm).then(function() {
          //NO
        }, function() {
          //YEs
        });
    }
  }
  

})(window.angular);