(function (angular) {
  'use strict';

  angular
    .module('app.registration')
    .controller('RegistrationController', RegistrationController);

  RegistrationController.$inject = ['UsersFactory', 'LoginFactory', '$state'];

  function RegistrationController(UsersFactory, LoginFactory, $state) {
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