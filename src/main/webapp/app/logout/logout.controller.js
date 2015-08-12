(function () {
  'use strict';
  
  angular
  	.module('app.logout')
  	.controller('LogoutController', LogoutController);
  
  LogoutController.$inject = ['LogoutFactory'];
  
  
  function LogoutController(LogoutFactory) {
	  var vm = this;
	  
	  vm.logout = logout;
	  
	  function logout() {
		  LogoutFactory.logout();
	  }
	  
	  
  }
  
})(window.angular);