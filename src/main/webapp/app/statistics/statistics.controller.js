(function (angular) {
  'use strict';

  angular
    .module('app.statistics')
    .controller('StatisticsController', StatisticsController);

  /*StatisticsController.$inject = [];*/

  function StatisticsController() {
    var vm = this;
    
    vm.statistics = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
	  
  }

})(window.angular);