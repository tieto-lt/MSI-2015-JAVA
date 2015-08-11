(function (){
	'use strict';

	angular
		.module('app.pointsTransferInfo')
		.controller('PointsTransferInfoController', PointsTransferInfoController);
	
	PointsTransferInfoController.$inject = ['PointsTransferFactory', 'LeaderboardFactory', 'ApplicationSettingsFactory'];
	
	function PointsTransferInfoController(PointsTransferFactory, LeaderboardFactory, ApplicationSettingsFactory) {
		var vm = this;
		
		vm.transferInfo = {
	      fromUser: '',
	      toUser: '',
	      points: '',
	      comment: ''
	    };
		
		vm.oneTimeLimit = 0;
			
		getOneTimeLimit();
	

	    vm.submit = submit;

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
	    
	    function getOneTimeLimit() {
	    	ApplicationSettingsFactory.getOneTimeLimit().then(function (response) {
    			vm.oneTimeLimit = response;
	    	});
	    }

	}
	
})();