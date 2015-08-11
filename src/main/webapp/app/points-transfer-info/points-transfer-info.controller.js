(function (){
	'use strict';

	angular
		.module('app.pointsTransferInfo')
		.controller('PointsTransferInfoController', PointsTransferInfoController);
	
	PointsTransferInfoController.$inject = ['PointsTransferFactory', 'LeaderboardFactory','UsersFactory'];
	
	function PointsTransferInfoController(PointsTransferFactory, LeaderboardFactory, UsersFactory) {
		var vm = this;
		
		vm.transferInfo = {
	      fromUser: '',
	      toUser: '',
	      points: '',
	      comment: ''
	    };

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
	    			vm.transferInfo.toUser = '';
	    			vm.transferInfo.points = '';
	    			vm.transferInfo.comment = '';
	    			vm.pointsForm.$setPristine();
	    			vm.pointsForm.$setUntouched();
	    			LeaderboardFactory.leaders();
	    		}, function() {
	    			vm.errorMessage = 'Transfer failed';
	    			vm.transferInfo.toUser = '';
	    			vm.transferInfo.points = '';
	    			vm.transferInfo.comment = '';
	    			vm.pointsForm.$setPristine();
	    		})
	    		
	    }
	    
	    
	    function fillteredList(searchText) {
	    	searchText = angular.lowercase(searchText);	
	    	
	    	return UsersFactory.getUsers().then(function(response) {
	    		var data = [];
	    		var user;
	    		for (var i=0; i< response.data.length; i++) {
	    			user = response.data[i];
	    			var fullName = user.firstName + " " + user.lastName;
		    		if ((angular.lowercase(user.firstName).indexOf(searchText) == 0) || 
		    			(angular.lowercase(user.lastName).indexOf(searchText) == 0) ||
		    			(angular.lowercase(fullName).indexOf(searchText) == 0)
		    			){
		    			data.push(user)
		    		}
		    	}
	    		return data;
	    	})
	    }
	}
	
})();