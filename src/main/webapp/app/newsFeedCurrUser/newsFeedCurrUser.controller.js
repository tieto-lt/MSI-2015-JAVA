(function (angular) {
  'use strict';

  angular
    .module('app.newsFeedCurrUser')
    .controller('NewsFeedCurrUserController', NewsFeedCurrUserController);
  
  NewsFeedCurrUserController.$inject = ['NewsFeedFactory', 'ProfileHeaderFactory'];

  function NewsFeedCurrUserController(NewsFeedFactory, ProfileHeaderFactory) {
    var vm = this;
    var currUserData = ProfileHeaderFactory.getProfileInfo();

    vm.newsFeed = [];
 
    NewsFeedFactory.getNewsFeedCurrUser(currUserData.id).then(function(response) {
    	vm.newsFeed = response.data;
    });

  }
  

})(window.angular);