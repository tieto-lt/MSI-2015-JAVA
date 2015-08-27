(function (angular) {
  'use strict';

  angular
    .module('app.adminPurchaseHistory')
    .controller('AdminPurchaseHistoryController', AdminPurchaseHistoryController);
  
  AdminPurchaseHistoryController.$inject = ['PurchaseHistoryFactory', '$timeout'];

  function AdminPurchaseHistoryController(PurchaseHistoryFactory, $timeout) {
    var vm = this;
    
    vm.decodeImage = decodeImage;
    vm.togglePurchase = togglePurchase;
    
    vm.isMoving = null;

    vm.purchases = {};
    
    PurchaseHistoryFactory.getAllPurchasedItems().then(function(response) {
    	vm.purchases = response.data;
    });
    
    function decodeImage(image) {
    	return atob(image);
    }
    
    function togglePurchase(id, event){
    	
    	vm.isMoving = id;
    	$timeout(function() {
    		PurchaseHistoryFactory.toggleReceived(id);
    		vm.isMoving = null;
    	}, 1000);
    }
  }
  

})(window.angular);