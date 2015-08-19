(function () {
  'use strict';

  angular
    .module('app.shopItem')
    .directive('shopItem', shopItem)
    
    		
	function shopItem() {
      
	  return {
		scope: {},
		bindToController: {
			item: '=',
			type: '='
		},
		controller: function() {},
		controllerAs: 'vm',
	    templateUrl: 'app/shopItem/shopItem.tmpl.html'
	  };
    }
})();