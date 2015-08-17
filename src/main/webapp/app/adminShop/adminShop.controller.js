(function(angular) {
	'use strict';

	angular
		.module('app.adminShop')
		.controller('AdminShopController', AdminShopController);

	AdminShopController.$inject = ['$state'];

	function AdminShopController($state) {
		var vm = this;
		
		vm.changePage = changePage;
		vm.currentPage = $state.current.name;
		  
		function changePage(state) {
			vm.currentPage = state;
			$state.go(state);
		}
	}

})(window.angular);