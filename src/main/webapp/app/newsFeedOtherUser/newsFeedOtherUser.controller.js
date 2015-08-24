(function (angular) {
  'use strict';

  angular
    .module('app.newsFeedOtherUser')
    .controller('NewsFeedOtherUserController', NewsFeedOtherUserController);
  
  NewsFeedOtherUserController.$inject = ['UserNewsFeedFactory', '$stateParams'];

  function NewsFeedOtherUserController(UserNewsFeedFactory, $stateParams) {
    var vm = this;


    vm.newsFeed = UserNewsFeedFactory.newsFeed;
    vm.loadMoreNews = UserNewsFeedFactory.loadMoreNews;
    vm.shownNewsFeed = UserNewsFeedFactory.shownNewsFeed;
    
    if ($stateParams.id) {
		vm.id = $stateParams.id;
	}
    
    UserNewsFeedFactory.updateNewsFeed(vm.id);
    
  }
  

})(window.angular);