(function () {
  'use strict';

  angular
    .module('app.common')
    .factory('LoginFactory', LoginFactory);

  LoginFactory.$inject = ['$http'];
  
  function LoginFactory($http) {
	  
	  return {
	    	login: login,
	    	emailExists: emailExists
	  };
	  
	  function login(credentials) {
		  var headers = credentials ? {authorization : "Basic "
		        + btoa(credentials.email + ":" + credentials.password)
		    } : {};
		  
    	  return $http.get('login', {headers : headers}).then();
	  }
	  
	  function emailExists(email) {
		  return $http({
			    url: 'email/check', 
			    method: "GET",
			    params: {email: email}
			 });
	  }
  }
})();
