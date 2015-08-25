(function (angular) {
  'use strict';

  angular
    .module('app.newsFeedCurrUser')
    .controller('NewsFeedCurrUserController', NewsFeedCurrUserController);
  
  NewsFeedCurrUserController.$inject = ['UserNewsFeedFactory', 'ProfileHeaderFactory'];

  function NewsFeedCurrUserController(UserNewsFeedFactory, ProfileHeaderFactory) {
    var vm = this;
    var currUserData = ProfileHeaderFactory.getProfileInfo();

    vm.newsFeed = UserNewsFeedFactory.newsFeed;
    vm.loadMoreNews = UserNewsFeedFactory.loadMoreNews;
    vm.shownNewsFeed = UserNewsFeedFactory.shownNewsFeed;
 
    UserNewsFeedFactory.updateNewsFeed(currUserData.id);

  }
  

})(window.angular);