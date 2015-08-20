(function (angular) {
  'use strict';

  angular
    .module('app.newsFeed')
    .controller('NewsFeedController', NewsFeedController);
  
  NewsFeedController.$inject = ['PointsTransferFactory','UsersFactory'];

  function NewsFeedController(PointsTransferFactory,UsersFactory) {
    var vm = this;
    
    vm.newsFeed = getNewsFeed();
    
    function getNewsFeed() {
    	return PointsTransferFactory.getNewsFeed()
    }

  }
  

})(window.angular);