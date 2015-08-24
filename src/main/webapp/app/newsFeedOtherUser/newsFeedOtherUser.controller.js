(function (angular) {
  'use strict';

  angular
    .module('app.newsFeedOtherUser')
    .controller('NewsFeedOtherUserController', NewsFeedOtherUserController);
  
  NewsFeedOtherUserController.$inject = ['UserNewsFeedFactory'];

  function NewsFeedOtherUserController(UserNewsFeedFactory) {
    var vm = this;


    vm.newsFeed = UserNewsFeedFactory.newsFeed;
    vm.loadMoreNews = UserNewsFeedFactory.loadMoreNews;
    vm.shownNewsFeed = UserNewsFeedFactory.shownNewsFeed;
 
    /*HARDCODED ID*/ var id = 2;
    UserNewsFeedFactory.updateNewsFeed(id);

  }
  

})(window.angular);