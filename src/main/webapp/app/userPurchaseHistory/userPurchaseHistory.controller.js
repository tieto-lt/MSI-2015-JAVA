(function (angular) {
  'use strict';

  angular
    .module('app.userPurchaseHistory')
    .controller('UserPurchaseHistoryController', UserPurchaseHistoryController);
  
  UserPurchaseHistoryController.$inject = ['PurchaseHistoryFactory', '$state'];

  function UserPurchaseHistoryController(PurchaseHistoryFactory, $state) {
    var vm = this;
    vm.profileId = $state.params.id;
 
    vm.decodeImage = decodeImage;
    
    vm.currUserPurchases = {};
    
    PurchaseHistoryFactory.getCurrUserPurchasedItems(vm.profileId).then(function(response) {
    	vm.currUserPurchases = response.data;
    });
    
    function decodeImage(image) {
    	return atob(image);
    }
  }
  

})(window.angular);