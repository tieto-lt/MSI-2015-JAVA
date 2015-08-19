(function(angular) {
	'use strict';

	angular.module('app.adminShopAddItem')
			.directive('checkFileSize', function() {
				  return {
					    link: function(scope, elem, attr, ctrl) {
					      elem[0].addEventListener('change', function() {
					    	  scope.vm.fileSizeError = '';
					    	  scope.$apply();
					    	  if(this.files[0].size > 200000) {
					    		  scope.vm.fileSizeError = "Max 2mb";  
					    		  scope.$apply();
					    	  } else {
					    		  scope.vm.updatePicture();
//					    		  scope.$apply();
					    	  }
					      }, false);
					    }
					  }
					});
					
	angular.module('app.adminShopAddItem')
			.directive('validFile',function() {
				  return {
					    require:'ngModel',
					    link:function(scope,el,attrs,ngModel){
					      el[0].addEventListener('change',function(){
					        scope.$apply(function(){
					          ngModel.$setViewValue(el.val());
					          ngModel.$render();
					         
					        });
					      }, false);
					    }
					  }
					});
})(window.angular);