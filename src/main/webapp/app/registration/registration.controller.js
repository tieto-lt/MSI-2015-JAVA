(function (angular) {
  'use strict';

  angular
    .module('app.registration')
    .controller('RegistrationController', RegistrationController);

  RegistrationController.$inject = ['UsersFactory', 'LoginFactory', '$state', 'ProfileHeaderFactory'];

  function RegistrationController(UsersFactory, LoginFactory, $state, ProfileHeaderFactory) {
    var vm = this;
    
    vm.user = {
    	email: '',
    	firstName: '',
     	lastName: '',
     	password: '',
     	passwordConfirm: ''
    };

    vm.register = register;

    //////////////////////////////////

    function register() {
    	vm.error = '';
    	vm.registrationForm.$setPristine();
    	if(vm.registerClicked) {
    		return;
    	}
    	vm.registerClicked = true;
    	
	    UsersFactory
	      	.addUser(vm.user)
	      	.then(function success() {
	      		loginUser();
	      		vm.registerClicked = false;
			}, function error() {
	      		vm.error = "Email is already taken";
	      		vm.registerClicked = false;
			});
    }
    
    function loginUser() {
  		LoginFactory
  			.login({email: vm.user.email, password: vm.user.password})
  			.then(function(response) {
				ProfileHeaderFactory.loadUserInfo().then(function() {
				  if(response.data.role == 'ADMIN'){
					  $state.go('adminPage.applicationSettings');
				  } else {
					  $state.go('userPage.home'); 
				  }
				});
			});
    }
  }

})(window.angular);