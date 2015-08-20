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

	vm.itemInfo = {
			name : '',
			value : '',
			quantity: '',
			description: '',
			image: '',
			imageName: '',
			imageType: ''
		};
	
	vm.getImage = getImage;

	function getImage() {
    	return atob(vm.itemInfo.image);
    }
	
	if ($stateParams.id) {
		vm.id = $stateParams.id;
		vm.itemInfo = ShopItemFactory.getItem(vm.id);
	}
	
	vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
  }
})(window.angular);