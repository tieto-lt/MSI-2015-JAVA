(function () {
  'use strict';

  angular
    .module('app.common')
    .factory('UsersFactory', UsersFactory);

  function UsersFactory() {
    var data = [{
      name: 'Marius',
      email: 'm@m.lt'
    }, {
      name: 'Rimvis',
      email: 'r@r.lt'
    }, {
      name: 'Saulukas',
      email: 's@s.lt'
    }];

    return {
      getUsers: getUsers,
      addUser: addUser
    };

    function getUsers() {
      return data;
    }

    function addUser(user) {
      data.push(user);
    }
  }

})();