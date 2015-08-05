(function (){
	'use strict';

	angular
		.module('app.pointsTransferInfo')
		.controller('PointsTransferInfoController', PointsTransferInfoController);
	
	PointsTransferInfoController.$inject = ['PointsTransferFactory'];
	
	function PointsTransferInfoController(PointsTransferFactory) {
		var vm = this;
		
		vm.transferInfo = {
	      fromUser: 'Firstname Lastname',
	      toUser: 'Firstname Lastname',
	      points: 100 
	    };

	    vm.submit = submit;

	    /**
	     * Function to execute when points transfer form is submitted
	     */
	    function submit() {
	    	PointsTransferFactory.sendPoints(vm.transferInfo)
	    }
	}
	
})();