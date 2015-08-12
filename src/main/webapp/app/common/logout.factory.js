(function () {
  'use strict';

  angular
    .module('app.common')
    .factory('LogoutFactory', LogoutFactory);

  LogoutFactory.$inject = ['$http'];
  
  function LogoutFactory($http) {
	  
	  return {
	    	logout: logout
	  };
	  
	  function logout() {
		  $http.post('api/logout', {});
	  }
  
  }
  
  })();