(function (angular) {
  'use strict';

  angular
    .module('app.registration')
    .controller('RegistrationController', RegistrationController);

  function RegistrationController() {
    var vm = this;

    vm.user = {
      name: 'Marius',
      email: ''
    };

    vm.submit = submit;

    //////////////////////////////////

    function submit() {
      alert(JSON.stringify(vm.user));
    }
  }

})(window.angular);