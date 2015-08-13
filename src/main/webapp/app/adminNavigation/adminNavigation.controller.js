(function () {
  'use strict';
  
  angular
  	.module('app.adminNavigation')
  	.controller('AdminNavigationController', AdminNavigationController);
  
  AdminNavigationController.$inject = ['$state'];
  
  
  function AdminNavigationController($state) {
	  var vm = this;
	  
	  vm.changePage = changePage;
	  vm.currentPage = $state.current.name;
	  
	  function changePage(state) {
		  vm.currentPage = state;
		  $state.go(state);
	  }	  
  }
  
})(window.angular);