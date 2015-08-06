(function (){
	'use strict';

	angular
		.module('app.pointsTransferInfo')
		.controller('PointsTransferInfoController', PointsTransferInfoController);
	
	PointsTransferInfoController.$inject = ['PointsTransferFactory'];
	
	function PointsTransferInfoController(PointsTransferFactory) {
		var vm = this;
		
		vm.transferInfo = {
	      fromUser: '',
	      toUser: '',
	      points: '',
	      comment: ''
	    };

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
	    			

	    		}, function() {
	    			vm.errorMessage = 'Transfer failed';
	    		})
	    		
	    }
	}
	
})();