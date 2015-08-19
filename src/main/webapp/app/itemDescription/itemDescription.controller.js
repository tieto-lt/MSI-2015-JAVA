(function (angular) {
  'use strict';

  angular
    .module('app.itemDescription')
    .controller('ItemDescriptionController', ItemDescriptionController);

  ItemDescriptionController.$inject = ['ItemDescriptionFactory', 'ProfileHeaderFactory'];

  function ItemDescriptionController(ItemDescriptionFactory, ProfileHeaderFactory) {
	var vm = this;
	  
	vm.buy = buy;
	
	function buy() {
		vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
		ItemDescriptionFactory.buy(vm.profileInfo.id, "1");	/*TURI BUTI SHOP ITEM ID*/
	}
	
  }
})(window.angular);