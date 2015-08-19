(function (angular) {
  'use strict';

  angular
    .module('app.itemDescription')
    .controller('ItemDescriptionController', ItemDescriptionController);

  ItemDescriptionController.$inject = ['ItemDescriptionFactory', 'ProfileHeaderFactory',
                                       'ShopItemFactory', '$stateParams'];

  function ItemDescriptionController(ItemDescriptionFactory, ProfileHeaderFactory, ShopItemFactory,
		  			$stateParams) {
	  
	var vm = this;
	  
	vm.buy = buy;
	
	vm.itemInfo = {
			name : '',
			price : '',
			amount: '',
			description: '',
			image: '',
			imageName: '',
			imageType: ''
		};
	
	if ($stateParams.id) {
		vm.id = $stateParams.id;
		getItem();
	}
	
	vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
	
	function buy() {
		vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
		ItemDescriptionFactory.buy(vm.profileInfo.id, vm.id).then(function() {
			getItem();
			ProfileHeaderFactory.loadUserInfo();
		});
	}
	
	function getItem() {
		ShopItemFactory.getShopItem(vm.id).then(function(response) {
			vm.itemInfo = {
					id: response.data.id,
					name: response.data.name,
					price: response.data.value,
					amount: response.data.quantity,
					description: response.data.description,
					image:  atob(response.data.image),
					imageName: response.data.imageName,
					imageType: response.data.imageType
			};
		});
	}
	
  }
})(window.angular);