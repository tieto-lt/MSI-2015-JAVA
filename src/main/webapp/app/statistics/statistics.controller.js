(function (angular) {
  'use strict';

  angular
    .module('app.statistics')
    .controller('StatisticsController', StatisticsController);

  StatisticsController.$inject = ['StatisticsFactory'];

  function StatisticsController(StatisticsFactory) {
    var vm = this;
    
    StatisticsFactory.getStatistics().then(function(response) {
    	vm.statistics = response.data;
    	console.log(vm.statistics);
    })
    
	  
  }

})(window.angular);