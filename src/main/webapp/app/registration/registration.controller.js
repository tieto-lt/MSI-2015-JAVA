(function (angular) {
  'use strict';

  angular
    .module('app.registration')
    .controller('RegistrationController', RegistrationController);

  RegistrationController.$inject = ['UsersFactory'];

  function RegistrationController(UsersFactory) {
    var vm = this;

    vm.user = {
      name: 'Marius',
      email: ''
    };

    vm.submit = submit;

    //////////////////////////////////

    function submit() {
      UsersFactory.addUser(vm.user);
    }
  }

})(window.angular);