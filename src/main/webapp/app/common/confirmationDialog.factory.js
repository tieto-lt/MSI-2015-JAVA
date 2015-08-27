(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('ConfirmationDialogFactory', ConfirmationDialogFactory);
	
	ConfirmationDialogFactory.$inject = ['$mdDialog'];
	
	function ConfirmationDialogFactory($mdDialog) {
		
		return {
			showConfirmationDialog: showConfirmationDialog,
			showSimpleDialog: showSimpleDialog,
			showTourDialog: showTourDialog
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
		
		function showSimpleDialog(params, event, okAction) {
	    	var options = {
	    		controller: function BuyItemDialogController($mdDialog) {
	    			var vm = this;
	    			
	    			vm.ok = okAction;
	    		},
	    		controllerAs: 'vm',
	    		locals: {
	    			params: params
	    		},
	    		bindToController: true,
	    		parent: angular.element(document.body),
	    		targetEvent: event,
	    		templateUrl: 'app/confirmationDialog/simpleDialog.tmpl.html'
	    	};
	    	
	    	$mdDialog.show(options);
	    }
		
		function showTourDialog(closeAction, event) {
	    	var options = {
	    		controller: function ShowTourController($mdDialog) {
	    			var vm = this;
	    			vm.closeAction = closeAction;
	    		},
	    		controllerAs: 'vm',
//	    		locals: {
//	    			params: params
//	    		},
	    		bindToController: true,
	    		parent: angular.element(document.body),
	    		targetEvent: event,
	    		templateUrl: 'app/tourDialog/tourDialog.tmpl.html'
	    	};
	    	
	    	$mdDialog.show(options);
	    }
	}
	
})();