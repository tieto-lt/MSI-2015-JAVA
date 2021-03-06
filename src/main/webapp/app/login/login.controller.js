(function () {
  'use strict';
  
  angular
  	.module('app.login')
  	.controller('LoginController', LoginController);
  
  LoginController.$inject = ['LoginFactory', '$state', 
                             'ProfileHeaderFactory',  '$mdDialog', 'ConfirmationDialogFactory'];
  
  
  function LoginController(LoginFactory, $state, 
		  ProfileHeaderFactory, $mdDialog, ConfirmationDialogFactory) {
	  var vm = this;
	  
	  vm.credentials = {
		 email: '',
		 password: ''
	  };
	  
	  vm.submit = submit;
	  vm.moveToRegisterPage = moveToRegisterPage;
	  
	  function submit() {
		  vm.passwordError = '';
		  vm.emailError = '';
		  LoginFactory.login(vm.credentials).then(function(response) {
			  ProfileHeaderFactory.loadUserInfo().then(function() {
				  if(response.data.role == 'ADMIN'){
					  $state.go('adminPage.applicationSettings');
				  } else {
					  $state.go('userPage.home');
					  
				  } 
			  });
		  }, function(response) {
			  vm.error="Incorrect details";
			  vm.loginForm.$setPristine();
			  LoginFactory.emailExists(vm.credentials.email).then(function(response) {
				  vm.emailExists = response.data;
				  if(vm.emailExists) {
					  vm.passwordError = "Incorrect password";
				  } else {
					  vm.emailError = "Incorrect email";
				  }
				  
			  })
			  
		  });
	  }
	  
	  function moveToRegisterPage() {
		  $state.go('registration');
	  }
  }
})(window.angular);