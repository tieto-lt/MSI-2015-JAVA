(function () {
  'use strict';

  angular
    .module('app.common')
    .factory('UsersFactory', UsersFactory);

  UsersFactory.$inject = ['$http'];

  function UsersFactory($http) {
    var data = [];

    $http
      .get('user/list')
      .then(function(response) {
        angular.extend(data, response.data);
      });

    return {
      getUsers: getUsers,
      addUser: addUser
    };

    function getUsers() {
      return data;
    }

    function addUser(user) {
    	$http
    	  .post('user/save', user)
          .then(function(response) {
        	  data.push(response.data);
          });
    }
  }

})();