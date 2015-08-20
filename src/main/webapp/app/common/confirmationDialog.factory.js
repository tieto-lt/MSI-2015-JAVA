(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('ConfirmationDialogFactory', ConfirmationDialogFactory);
	
	ConfirmationDialogFactory.$inject = ['$mdDialog'];
	
	function ConfirmationDialogFactory($mdDialog) {
		
		return {
			showConfirmationDialog: showConfirmationDialog
		};
		
		function showConfirmationDialog(message, event, okAction, cancelAction) {
	    	var options = {
	    		controller: function BuyItemDialogController($mdDialog) {
	    			var vm = this;
	    			
	    			vm.ok = okAction;
	    			vm.cancel = cancelAction;
	    		},
	    		controllerAs: 'vm',
	    		locals: {
	    			message: message
	    		},
	    		bindToController: true,
	    		parent: angular.element(document.body),
	    		targetEvent: event,
	    		templateUrl: 'app/confirmationDialog/confirmationDialog.tmpl.html'
	    	};
	    	
	    	$mdDialog.show(options);
	    }
	}
	
})();