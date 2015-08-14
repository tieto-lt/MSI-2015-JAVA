//(function () {
//  'use strict';
//  
//  angular
//  	.module('app.userShop')
//  	.directive('userShopItem', userShopItem);
//  
//  function userShopItem() {
//	  var directive = {
//        restrict: 'EA',
//        scope: true,
//        bindToController: {
//            name: '@',
//        },
//        controller: ExampleController,
//        controllerAs: 'ctrl',
//        templateUrl: 'app/userShop/userShopItem.tmpl.html'
//    };
//	  
//	return directive;
//	
//  }
//
//  function ExampleController() {
//      // Injecting $scope just for comparison
////      console.log(ctrl.name);
//      console.log(name);
//      console.log(this.name);
//      this.name = 'Pascal';
//      console.log(this.name);
//  }
//  
//})(window.angular);