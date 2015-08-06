(function (angular) {
  'use strict';

  angular
    .module('app.leaderboard')
    .controller('LeaderboardController', LeaderboardController);

  LeaderboardController.$inject = ['LeaderboardFactory'];

  function LeaderboardController(LeaderboardFactory) {
    var vm = this;

    vm.leaders = LeaderboardFactory.leaders();
    //////////////////////////////////
    
    vm.updateLeaders = function() {
    	vm.leaders = LeaderboardFactory.leaders();
    }
  }
  

})(window.angular);