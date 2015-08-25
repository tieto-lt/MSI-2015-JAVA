(function (){
	'use strict';

	angular
		.module('app.pointsTransferInfo')
		.controller('PointsTransferInfoController', PointsTransferInfoController);
	
	PointsTransferInfoController.$inject = ['PointsTransferFactory', 'LeaderboardFactory',
	                                        'AdminAppSettingsFactory', 'UsersFactory',
	                                        'ProfileHeaderFactory','NewsFeedFactory', 'CategoryFactory',
	                                        '$state', 'UserNewsFeedFactory'];
	
	function PointsTransferInfoController(PointsTransferFactory, LeaderboardFactory,
				AdminAppSettingsFactory, UsersFactory, ProfileHeaderFactory,NewsFeedFactory,
				CategoryFactory, $state, UserNewsFeedFactory) {

		var vm = this;
		
		vm.state = $state.current.name;
		vm.profileId = $state.params.id;
		
		vm.transferInfo = {
	      toUser: '',
	      points: '',
	      comment: '',
	      categoryId: ''
	    };
		
		vm.data = [];
		
		ProfileHeaderFactory.loadUserInfo();
		
		vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
		
		vm.oneTimeLimit = 0;
			
		getOneTimeLimit();
		
	    vm.submit = submit;
	    vm.fillteredList = fillteredList;
	    vm.categories = getCategories();
	    
	    /**
	     * Function to execute when points transfer form is submitted
	     */
	    function submit() {
	    	vm.successMessage = '';
	    	vm.errorMessage = '';
	    	
	    	if(vm.submitClicked) {
	    		return;
	    	}
	    	vm.submitClicked = true;
	    	
	    	if(vm.state != "userPage.home") {
	    		UsersFactory.getUserProfile(vm.profileId).then(function(response) {
	    			vm.transferInfo.toUser = response.data;
	    			sendPoints();
	    		})
	    	} else {
	    		sendPoints();
	    	}
	    }
	    
	    function sendPoints() {
	    	PointsTransferFactory
    		.sendPoints(vm.transferInfo)
    		.then(function() {
    			vm.successMessage = 'Transfer was successful';	    			
    			/*vm.transferInfo.toUser = '';*/
    			vm.searchText = '';
    			vm.transferInfo.points = '';
    			vm.transferInfo.comment = '';
    			vm.transferInfo.categoryId = null;
    			vm.pointsForm.$setPristine();
    			vm.pointsForm.$setUntouched();
    			LeaderboardFactory.leaders();
    			NewsFeedFactory.updateNewsFeed();
    			if(vm.state != "userPage.home") {
    				UserNewsFeedFactory.updateNewsFeed(vm.profileId);
    				UsersFactory.unsetGivingPointsBlock();
    				UsersFactory.setSuccessMessage();
    				UsersFactory.refreshUserProfile(vm.profileId);
    			}
    			ProfileHeaderFactory.loadUserInfo();
    			vm.submitClicked = false;
    		}, function() {
    			vm.errorMessage = 'Transfer failed';
    			vm.transferInfo.toUser = '';
    			vm.transferInfo.points = '';
    			vm.transferInfo.comment = '';
    			vm.pointsForm.$setPristine();
    			if(vm.state != "userPage.home") {
    				UserNewsFeedFactory.updateNewsFeed(vm.profileId);
    				UsersFactory.unsetGivingPointsBlock();
    				UsersFactory.setErrorMessage();
    			}
    			vm.submitClicked = false;
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
	    
	    function getCategories() {
	    	CategoryFactory.loadCategories();
	    	return CategoryFactory.getCategories();
	    }
	}
})();