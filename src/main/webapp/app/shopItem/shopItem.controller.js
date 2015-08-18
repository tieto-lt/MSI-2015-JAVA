(function (angular) {
  'use strict';

  angular
    .module('app.shopItem')
    .controller('ShopItemController', ShopItemController);

  ShopItemController.$inject = ['ShopItemFactory', '$routeParams'];

  function ShopItemController(ShopItemFactory, $routeParams) {
    var vm = this;

    vm.shopItem = ShopItemFactory.getShopItem($routeParams.id);
  }
  

})(window.angular);