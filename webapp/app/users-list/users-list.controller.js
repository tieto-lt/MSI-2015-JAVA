(function () {
  'use strict';

  angular
    .module('app.usersList')
    .controller('UsersListController', UsersListController);

  function UsersListController() {
    var vm = this;

    vm.users = [{
      name: 'Marius',
      email: 'm@m.lt'
    }, {
      name: 'Rimvis',
      email: 'r@r.lt'
    }, {
      name: 'Saulukas',
      email: 's@s.lt'
    }];
  }

})();