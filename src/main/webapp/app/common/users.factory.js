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
    	
		var data = [];
			
    	$http
	      .get('user/getAllUsersFullnames')
	      .then(function(response) {
	        angular.extend(data, response.data);
	    });
		   
    	return data;
    }
    
  }

})();