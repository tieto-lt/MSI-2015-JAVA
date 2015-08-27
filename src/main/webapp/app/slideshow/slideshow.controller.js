(function () {
  'use strict';
  
  angular
  	.module('app.slideshow')
  	.controller('SlideshowController', SlideshowController);
  
  SlideshowController.$inject = [];
  
  
  function SlideshowController() {
	  var vm = this;
	  vm.slide = 1;
  }
})(window.angular);