(function (angular) {
  'use strict';

  angular
    .module('app.newsFeed')
    .controller('NewsFeedController', NewsFeedController);
  
  NewsFeedController.$inject = ['NewsFeedFactory'];

  function NewsFeedController(NewsFeedFactory) {
    var vm = this;
    
    //vm.newsFeed = {};
    vm.shownNewsFeed = NewsFeedFactory.shownNewsFeed;
    vm.loadMoreNews = NewsFeedFactory.loadMoreNews;
    
//    NewsFeedFactory.updateNewsFeed().then(function() {
//    	vm.newsFeed = NewsFeedFactory.newsFeed;
////    	loadMoreNews();
//    });
    
//    function loadMoreNews() {
//    	var loaded = vm.newsFeed.slice(vm.shownNewsFeed.length, vm.shownNewsFeed.length + 10);
//    	vm.shownNewsFeed.push.apply(vm.shownNewsFeed, loaded);
//    }

  }
  

})(window.angular);