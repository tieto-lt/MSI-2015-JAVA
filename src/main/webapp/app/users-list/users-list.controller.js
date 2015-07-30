(function () {
  'use strict';

  angular
    .module('app.usersList')
    .controller('UsersListController', UsersListController);

  UsersListController.$inject = ['UsersFactory'];

  function UsersListController(UsersFactory) {
    var vm = this;

    vm.users = UsersFactory.getUsers();

  }

})();