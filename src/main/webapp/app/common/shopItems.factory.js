(function () {
	'use strict';
	
	angular
		.module('app.adminShopAddItem')
		.factory('ShopItemFactory', ShopItemFactory);
	
	ShopItemFactory.$inject = ['$http'];
	
	function ShopItemFactory($http) {
		
		var data = [];
		
		return {
			addNewShopItem: addNewShopItem,
			getShopItems:   getShopItems,
			deleteItem:     deleteItem
	    };
	    
	    function addNewShopItem(transferInfo) {
	    	var transferObject = {
					name: transferInfo.name,
					description: transferInfo.description,
					image: btoa(transferInfo.image),
					imageType: transferInfo.imageType,
					imageName: transferInfo.imageName,
					quantity: transferInfo.amount,
					value: transferInfo.price
	    	}
	    	
		    return $http
		    	.post('api/shop/addItem', transferObject);
	    }
	
	    /*
	     * Function returns a promise to get all shop items in db
	     */
	    function getShopItems(){
	    	
	    	return $http.get('api/shop/items');
	    }
	    
	    
	    function deleteItem(id){
	    	
	    	return $http.delete('api/shop/deleteItem/' + id.toString());
	    }
	}
	
})();