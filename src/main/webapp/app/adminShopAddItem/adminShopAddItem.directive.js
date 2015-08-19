(function(angular) {
	'use strict';

	angular.module('app.adminShopAddItem')
			.directive('checkFileSize', function() {
				  return {
					    link: function(scope, elem, attr, ctrl) {
					      elem[0].addEventListener('change', function() {
					    	  scope.vm.fileSizeError = '';
					    	  scope.$apply();
					    	  var type = this.files[0].type;
					    	  if(this.files[0].size > 200000) {
					    		  scope.vm.fileSizeError = "Max 2mb";
					    		  scope.$apply();
					    	  } else if(type != "image/jpeg" && type != "image/png" &&
					    			  	type != "image/jpg" && type != "image/gif") {
					    		  scope.vm.fileSizeError = "Only .jpg, .png, .gif supported";
					    		  scope.$apply();
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