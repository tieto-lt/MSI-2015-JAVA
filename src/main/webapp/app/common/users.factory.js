(function () {
  'use strict';

  angular
    .module('app.common')
    .factory('UsersFactory', UsersFactory);

  UsersFactory.$inject = ['$http'];

  function UsersFactory($http) {
	   
	var givingPointsBlock = {shown : false};
	  
    return {
    	addUser:  addUser,
    	getUsers: getUsers,
    	getUser:  getUser,
    	getUserProfile: getUserProfile,
    	updateUserProfile: updateUserProfile,
    	givingPointsBlock: givingPointsBlock,
    	unsetGivingPointsBlock: unsetGivingPointsBlock
    };
    
    function unsetGivingPointsBlock() {
    	givingPointsBlock.shown = false;
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
  }

})();