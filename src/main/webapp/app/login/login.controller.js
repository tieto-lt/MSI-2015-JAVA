(function () {
  'use strict';
  
  angular
  	.module('app.login')
  	.controller('LoginController', LoginController);
  
  LoginController.$inject = ['LoginFactory'];
  
  
  function LoginController(LoginFactory) {
	  var vm = this;
	  
	  vm.credentials = {
		 email: 'user1@oho.lt',
		 password: 'password1'
	  };
	  
	  vm.submit = submit;
	  
	  function submit() {
		  LoginFactory.login(vm.credentials);
	  }
	  
	  
  }
  
})(window.angular);