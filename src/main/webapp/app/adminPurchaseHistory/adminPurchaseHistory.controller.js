(function (angular) {
  'use strict';

  angular
    .module('app.adminPurchaseHistory')
    .controller('AdminPurchaseHistoryController', AdminPurchaseHistoryController);
  
  AdminPurchaseHistoryController.$inject = ['PurchaseHistoryFactory'];

  function AdminPurchaseHistoryController(PurchaseHistoryFactory) {
    var vm = this;
    
    vm.received = false;
//    vm.profileId = $state.params.id;
// 
//    vm.decodeImage = decodeImage;
//    
//    vm.currUserPurchases = {};
//    
//    PurchaseHistoryFactory.getCurrUserPurchasedItems(vm.profileId).then(function(response) {
//    	vm.currUserPurchases = response.data;
//    });
//    
//    function decodeImage(image) {
//    	return atob(image);
//    }
  }
  

})(window.angular);