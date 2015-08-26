(function (angular) {
  'use strict';

  angular
    .module('app.adminPurchaseHistory')
    .controller('AdminPurchaseHistoryController', AdminPurchaseHistoryController);
  
  AdminPurchaseHistoryController.$inject = ['PurchaseHistoryFactory'];

  function AdminPurchaseHistoryController(PurchaseHistoryFactory) {
    var vm = this;
    
    vm.decodeImage = decodeImage;
    vm.togglePurchase = togglePurchase;

    vm.purchases = {};
    
    PurchaseHistoryFactory.getAllPurchasedItems().then(function(response) {
    	vm.purchases = response.data;
    });
    
    function decodeImage(image) {
    	return atob(image);
    }
    
    function togglePurchase(id){
    	PurchaseHistoryFactory.toggleReceived(id);
    }
  }
  

})(window.angular);