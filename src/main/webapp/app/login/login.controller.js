(function () {
  'use strict';
  
  angular
  	.module('app.login')
  	.controller('LoginController', LoginController);
  
  LoginController.$inject = ['LoginFactory', '$state'];
  
  
  function LoginController(LoginFactory, $state) {
	  var vm = this;
	  
	  vm.credentials = {
		 email: 'user2@oho.lt',
		 password: 'password2'
	  };
	  
	  vm.submit = submit;
	  
	  function submit() {
		  LoginFactory.login(vm.credentials).then(function(response) {
			  console.log(response.data.role);
			  if(response.data.role == 'ADMIN'){
				  $state.go('adminPage');
			  } else {
				  $state.go('userPage'); 
			  } 
		  });
	  }
	  
	  
  }
  
})(window.angular);