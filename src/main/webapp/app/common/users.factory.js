(function () {
  'use strict';

  angular
    .module('app.common')
    .factory('UsersFactory', UsersFactory);

  UsersFactory.$inject = ['$http'];

  function UsersFactory($http) {

    return {
    	addUser: addUser,
    	getUsers: getUsers
    };

    function addUser(user) {
    	$http
    	  .post('user/save', user);
    }
    
    
	function getUsers() {
    	
    	return $http
	      .get('user/getAllUsersFullnames');
    	
    }
    
  }

})();