(function (){
	'use strict';

	angular
		.module('app.pointsTransferInfo')
		.controller('PointsTransferInfoController', PointsTransferInfoController);
	
	PointsTransferInfoController.$inject = ['PointsTransferFactory'];
	
	function PointsTransferInfoController(PointsTransferFactory) {
		var vm = this;
		
		vm.transferInfo = {
	      from: 'Firstname Lastname',
	      to: 'Firstname Lastname',
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