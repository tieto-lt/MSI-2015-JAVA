(function (angular) {
  'use strict';

  angular
    .module('MSI-app', [
      'app.usersList',
      'app.registration',
      'app.leaderboard',

      /*commons*/
      'app.common'
    ]);

})(window.angular);