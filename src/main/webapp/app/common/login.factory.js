(function () {
  'use strict';

  angular
    .module('app.common')
    .factory('LoginFactory', LoginFactory);

  LoginFactory.$inject = ['$http'];
  
  function LoginFactory($http) {
	  
	  return {
	    	login: login
	  };
	  
	  function login(credentials) {
		  var headers = credentials ? {authorization : "Basic "
		        + btoa(credentials.email + ":" + credentials.password)
		    } : {};
		  
    	  return $http.get('login', {headers : headers});

	    }
  
  }
  
  })();