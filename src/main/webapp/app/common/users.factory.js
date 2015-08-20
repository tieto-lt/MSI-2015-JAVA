(function () {
  'use strict';

  angular
    .module('app.common')
    .factory('UsersFactory', UsersFactory);

  UsersFactory.$inject = ['$http'];

  function UsersFactory($http) {
	   
    return {
    	addUser:  addUser,
    	getUsers: getUsers,
    	getUser:  getUser
    };

    function addUser(user) {
    	return $http
    	  .post('user/save', user);
    }
    
    
	function getUsers() {
    	
    	return $http
	      .get('api/user/getAllUsersFullnames');
    }    
    	
    function getUser(id){
    	var data = {};
    	 	
    	$http.get('user/' + id).then(function(response) {
        	angular.extend(data, response.data);     	
	    });
    	
    	return data;
    }
  }

})();