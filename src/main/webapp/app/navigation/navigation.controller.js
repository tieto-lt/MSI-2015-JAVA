(function (angular) {
  'use strict';

  angular
    .module('app.navigation')
    .controller('NavigationController', NavigationController);

  NavigationController.$inject = ['$state'];

  function NavigationController($state) {
    var vm = this;

    vm.changePage = changePage;
           vm.currentPage = $state.current.name;
        
        function changePage(state) {
                  vm.currentPage = state;
                  $state.go(state);
        }

    
}
  

})(window.angular);