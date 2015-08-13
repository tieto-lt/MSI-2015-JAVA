(function (angular) {
  'use strict';

  angular
    .module('MSI-app')
    .run(function($rootScope, $state) {
    	$rootScope.$on('$stateChangeError', function(e, toState, toParams, fromState, fromParams, error){

    	    if(error === "Not Authorized"){
    	        $state.go("login");
    	    }
    	});
    });
})(window.angular);