(function () {
  'use strict';

  angular
    .module('app.common')
    .factory('UsersFactory', UsersFactory);

  UsersFactory.$inject = ['$http'];

  function UsersFactory($http) {
    var data = [];

    $http
      .get('users.json')
      .then(function(response) {
        angular.extend(data, response.data.users);
      });

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