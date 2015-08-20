(function (angular) {
  'use strict';

  angular
    .module('app.newsFeed')
    .controller('NewsFeedController', NewsFeedController);
  
  NewsFeedController.$inject = ['NewsFeedFactory'];

  function NewsFeedController(NewsFeedFactory) {
    var vm = this;
    
    vm.newsFeed = NewsFeedFactory.newsFeed;


  }
  

})(window.angular);