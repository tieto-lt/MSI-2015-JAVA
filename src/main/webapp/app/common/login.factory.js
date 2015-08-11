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
	    	$http
	    	  .post('login', credentials);
	    }
	    
  
  }
  
  })();