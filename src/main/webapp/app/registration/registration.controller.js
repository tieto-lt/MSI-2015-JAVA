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

    vm.submit = submit;

    //////////////////////////////////

    function submit() {
      UsersFactory
      	.addUser(vm.user)
      	//.then(LoginFactory.login({email: vm.user.email, password: vm.user.password}))
      	.then(function() {
      		LoginFactory.login({email: vm.user.email, password: vm.user.password})
      			.then(function(response) {
      				console.log(response.data.role);
  				  if(response.data.role == 'ADMIN'){
  					  $state.go('adminPage');
  				  } else {
  					  $state.go('userPage'); 
  				  } 
  			});
      });
    }
  }

})(window.angular);