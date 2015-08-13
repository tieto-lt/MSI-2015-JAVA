(function (){
	'use strict';

	angular
		.module('app.pointsTransferInfo')
		.controller('PointsTransferInfoController', PointsTransferInfoController);
	
	PointsTransferInfoController.$inject = ['PointsTransferFactory', 'LeaderboardFactory',
	                                        'AdminAppSettingsFactory', 'UsersFactory',
	                                        'ProfileHeaderFactory'];
	
	function PointsTransferInfoController(PointsTransferFactory, LeaderboardFactory,
				AdminAppSettingsFactory, UsersFactory, ProfileHeaderFactory) {

		var vm = this;
		
		vm.transferInfo = {
	      fromUser: '',
	      toUser: '',
	      points: '',
	      comment: ''
	    };
		
		vm.data = [];
		
		vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
		
		vm.oneTimeLimit = 0;
			
		getOneTimeLimit();
	

	    vm.submit = submit;
	    vm.fillteredList = fillteredList;

	    /**
	     * Function to execute when points transfer form is submitted
	     */
	    function submit() {
	    	vm.successMessage = '';
	    	vm.errorMessage = '';
	    	PointsTransferFactory
	    		.sendPoints(vm.transferInfo)
	    		.then(function() {
	    			vm.successMessage = 'Transfer was successful';	    			
	    			/*vm.transferInfo.toUser = '';*/
	    			vm.transferInfo.points = '';
	    			vm.transferInfo.comment = '';
	    			vm.pointsForm.$setPristine();
	    			vm.pointsForm.$setUntouched();
	    			LeaderboardFactory.leaders();
	    			ProfileHeaderFactory.getProfileInfo();
	    		}, function() {
	    			vm.errorMessage = 'Transfer failed';
	    			vm.transferInfo.toUser = '';
	    			vm.transferInfo.points = '';
	    			vm.transferInfo.comment = '';
	    			vm.pointsForm.$setPristine();
	    		})	    		
	    }
	    
	    function getOneTimeLimit() {
	    	AdminAppSettingsFactory.getOneTimeLimit().then(function (response) {
    			vm.oneTimeLimit = response;
	    	});
	    }
	    
	    function fillteredList(searchText) {
	    	searchText = angular.lowercase(searchText);	
	    	return UsersFactory.getUsers().then(function(response) {
	    		vm.data.length = 0;
	    		var user;
	    		for (var i=0; i< response.data.length; i++) {
	    			user = response.data[i];
	    			var fullName = user.firstName + " " + user.lastName;
		    		if ((angular.lowercase(user.firstName).indexOf(searchText) == 0) || 
		    			(angular.lowercase(user.lastName).indexOf(searchText) == 0) ||
		    			(angular.lowercase(fullName).indexOf(searchText) == 0)
		    			){
		    			vm.data.push(user)
		    		}
		    	}
	    		
	    		return vm.data;
	    	})
	    }
	}
})();