(function () {
  'use strict';

  angular
    .module('app.common')
    .factory('UsersFactory', UsersFactory);

  UsersFactory.$inject = ['$http'];

  function UsersFactory($http) {
	   
	var givingPointsBlock = {shown : false};
	var responseMessages = {success: '',
							error: ''};
	var userProfile = [];
	  
    return {
    	addUser:  addUser,
    	getUsers: getUsers,
    	getUser:  getUser,
    	getUserProfile: getUserProfile,
    	updateUserProfile: updateUserProfile,
    	givingPointsBlock: givingPointsBlock,
    	unsetGivingPointsBlock: unsetGivingPointsBlock,
    	responseMessages: responseMessages,
    	setSuccessMessage: setSuccessMessage,
    	setErrorMessage: setErrorMessage,
    	unsetErrorMessages: unsetErrorMessages,
    	refreshUserProfile: refreshUserProfile,
    	userProfile: userProfile
    };
    
    function unsetGivingPointsBlock() {
    	givingPointsBlock.shown = false;
    }
    
    function setSuccessMessage() {
    	responseMessages.success = 'Points sent';
    }
    
    function setErrorMessage() {
    	responseMessages.error = 'Sending failed';
    }
    
    function unsetErrorMessages() {
    	responseMessages.success = '';
    	responseMessages.error = '';
    }
    
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
    
    function getUserProfile(id) {
    	return $http({
    		url: 'api/user/profile', 
			    method: "GET",
			    params: { id: id}
			 });
	  }
    
    function updateUserProfile(user) {
    	var transferObject = {
    		id: user.id,
    		firstName: user.firstName,
    		lastName: user.lastName,
    		email: user.email,
    		userPoints: user.userPoints,
    		rank: user.rank,
    		aboutMe: user.aboutMe,
    		image: btoa(user.image),
    		imageName: user.imageName,
    		imageType: user.imageType,
    		oldPassword: user.oldPassword,
    		newPassword: user.newPassword
    	};
    	
    	return $http
  	  		.post('api/user/profile', transferObject);
    }
    
    function refreshUserProfile(id) {
    	getUserProfile(id).then(function(response) {
    		angular.extend(userProfile, response.data);
			if(response.data.image) {
				userProfile.image = atob(response.data.image);
			} else {
				userProfile.image = 'assets/images/no-profile-pic.png';
				userProfile.imageType = 'image/png';
				userProfile.imageName = 'no-profile-pic.png';
			}
		});
    }
    
  }

})();