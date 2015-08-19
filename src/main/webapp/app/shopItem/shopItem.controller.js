(function (angular) {
  'use strict';

  angular
    .module('app.shopItem')
    .controller('ShopItemController', ShopItemController);

  ShopItemController.$inject = ['ShopItemFactory', '$mdDialog', 'ProfileHeaderFactory'];

  function ShopItemController(ShopItemFactory, $mdDialog, ProfileHeaderFactory) {
    var vm = this;
    
    vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
    
    vm.decodeImage = decodeImage;
    vm.showBuyConfirmation = showBuyConfirmation;

//    vm.shopItem = ShopItemFactory.getShopItem($routeParams.id);
    vm.shopItems = [];
    ShopItemFactory.getShopItems().then(function (response) {
    	vm.shopItems = response.data;
	}) ;
    
    function decodeImage(image) {
    	return atob(image);
    }
    
    function showBuyConfirmation(item, event) {
    	var options = {
    		controller: function BuyItemDialogController($mdDialog, item, ItemDescriptionFactory, ProfileHeaderFactory) {
    			var vm = this;
    			
    			vm.ok = function () {
    				var userId = ProfileHeaderFactory.getProfileInfo().id;
    				ItemDescriptionFactory.buy(userId, vm.item.id).then(function() {
    					$mdDialog.hide();
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
    		templateUrl: 'app/buyItemDialog/buyItemDialog.tmpl.html'
    	};
    	
    	$mdDialog.show(options);
    	
        /*var confirm = $mdDialog.confirm()
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
        });*/
    }
  }
  

})(window.angular);