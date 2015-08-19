(function (angular) {
  'use strict';

  angular
    .module('app.shopItem')
    .controller('ShopItemController', ShopItemController);

  ShopItemController.$inject = ['ShopItemFactory'];

  function ShopItemController(ShopItemFactory) {
    var vm = this;
    
    vm.decodeImage = decodeImage;

//    vm.shopItem = ShopItemFactory.getShopItem($routeParams.id);
    vm.shopItems = [];
    ShopItemFactory.getShopItems().then(function (response) {
    	vm.shopItems = response.data;
	}) ;
    
    function decodeImage(image) {
    	return atob(image);
    }    
  }
  

})(window.angular);