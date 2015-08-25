(function () {
  'use strict';

  angular
    .module('app.common')
    .factory('PurchaseHistoryFactory', PurchaseHistoryFactory);

  PurchaseHistoryFactory.$inject = ['$http', '$filter'];
  
  function PurchaseHistoryFactory($http, $filter) {
	 
	  return {
		  getCurrUserPurchasedItems: getCurrUserPurchasedItems,
	  }
 
	  function getCurrUserPurchasedItems(userId){
			var data = {};
			
			data = $http({
						url: 'api/shop/userPurchasedItems/' + userId.toString(),
						method: "GET"	
			});
			
			return data;
	  }
  }
  
})();