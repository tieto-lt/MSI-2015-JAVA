(function () {
  'use strict';
  
  angular
  	.module('app.tourDialog')
  	.controller('TourDialogController', TourDialogController);
  
  TourDialogController.$inject = ['$mdDialog', 'ConfirmationDialogFactory'];
  
  
  function TourDialogController($mdDialog, ConfirmationDialogFactory) {
	  var tdc = this;
	  
	  tdc.showTour = showTour;

		function showTour(event) {
		  //console.log("inside showTour");
		  var closeAction = function () {
			  		$mdDialog.hide();
		  };
	    	
		  ConfirmationDialogFactory.showTourDialog(closeAction, event);
	  }
  }
})(window.angular);