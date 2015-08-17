(function () {
	'use strict';
	
	angular
		.module('app.adminShopAddItem')
		.factory('ShopItemFactory', ShopItemFactory);
	
	ShopItemFactory.$inject = ['$http'];
	
	function ShopItemFactory($http) {
		
		var data = [];
		
		return {
			addNewShopItem: addNewShopItem
	    };
	    
	    function addNewShopItem(transferInfo) {
	    	var transferObject = {
					name: transferInfo.name,
					description: transferInfo.description,
					image: transferInfo.image,
					quantity: transferInfo.amount,
					value: transferInfo.price
	    	}
	    	
		    return $http
		    	.post('api/shop/addItem', transferObject);
	    }
	    
	}
	
})();