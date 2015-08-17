(function (angular) {
  'use strict';

  angular
    .module('app.profileHeader')
    .controller('ProfileHeaderController', ProfileHeaderController);

  ProfileHeaderController.$inject = ['ProfileHeaderFactory'];

  function ProfileHeaderController(ProfileHeaderFactory) {
    var vm = this;

    vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
    
    vm.getProfileInfo = function() {
    	vm.profileInfo = ProfileHeaderFactory.getProfileInfo();
    }
  }
  

})(window.angular);