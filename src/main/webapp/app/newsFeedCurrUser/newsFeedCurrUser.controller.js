(function (angular) {
  'use strict';

  angular
    .module('app.newsFeedCurrUser')
    .controller('NewsFeedCurrUserController', NewsFeedCurrUserController);
  
  NewsFeedCurrUserController.$inject = ['UserNewsFeedFactory', 'ProfileHeaderFactory', '$state'];

  function NewsFeedCurrUserController(UserNewsFeedFactory, ProfileHeaderFactory, $state) {
    var vm = this;
    var currUserData = ProfileHeaderFactory.getProfileInfo();
    vm.profileId = $state.params.id;

    vm.newsFeed = UserNewsFeedFactory.newsFeed;
    vm.loadMoreNews = UserNewsFeedFactory.loadMoreNews;
    vm.shownNewsFeed = UserNewsFeedFactory.shownNewsFeed;
 
    UserNewsFeedFactory.updateNewsFeed(vm.profileId);

  }
  

})(window.angular);