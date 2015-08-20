(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('ShopItemFactory', ShopItemFactory);
	
	ShopItemFactory.$inject = ['$http', '$mdDialog'];
	
	function ShopItemFactory($http, $mdDialog) {
		
		var data = [];
		
		return {
			addNewShopItem: addNewShopItem,
			getShopItems:   getShopItems,
			deleteItem:     deleteItem,
			updateItem: 	updateItem,
			getShopItem:	getShopItem,
			showConfirmationDialog: showConfirmationDialog
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
	    
	    function updateItem(transferInfo) {
	    	var transferObject = {
	    			id: transferInfo.id,
					name: transferInfo.name,
					description: transferInfo.description,
					image: btoa(transferInfo.image),
					imageType: transferInfo.imageType,
					imageName: transferInfo.imageName,
					quantity: transferInfo.amount,
					value: transferInfo.price
	    	}
	    	
		    return $http.post('api/shop/updateItem', transferObject);
	    }
	
	    function getShopItem(id) {
	    	return $http.get('api/shop/item/' + id);
	    }
	    
	    function showConfirmationDialog(message, event, okAction, cancelAction) {
	    	/*
	    	 * Reikia pasikurti geriau factory metoda, kuris sukurti visa sita dialog reikala, pvz: 
	    	 */
	    	/*function okClick () {
	    		...
	    	}
	    	mymodal.show({item: item}, template, okClick, cancelClick);*/
	    	var options = {
	    		controller: function BuyItemDialogController($mdDialog) {
	    			var vm = this;
	    			
	    			vm.ok = function () {
	    				okAction().then(function() {
	    					$mdDialog.hide();
	    				});
	    				
	    			}
	    			vm.cancel = function () {
	    				$mdDialog.cancel();
	    			}
	    		},
	    		controllerAs: 'vm',
	    		locals: {
	    			message: message
	    		},
	    		bindToController: true,
	    		parent: angular.element(document.body),
	    		targetEvent: event,
	    		templateUrl: 'app/confirmationDialog/confirmationDialog.tmpl.html'
	    	};
	    	
	    	$mdDialog.show(options);
	    }
	}
	
})();