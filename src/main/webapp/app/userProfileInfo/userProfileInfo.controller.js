(function (){
	'use strict';

	angular
		.module('app.userProfileInfo')
		.controller('UserProfileInfoController', UserProfileInfoController);
	
	UserProfileInfoController.$inject = ['UsersFactory'];
	
	function UserProfileInfoController(UsersFactory) {

		var vm = this;
		
		vm.user = {
	      photo: 'assets/images/mantas.jpg'
	    };

	}
})();