(function (angular) {
  'use strict';

  angular
    .module('MSI-app', [
      'ngMaterial',
      'app.pointsTransferInfo',
      'app.registration',
      'app.leaderboard',
      'app.login',
      
      /*angular ngMessages*/
      'ngMessages',

      /*commons*/
      'app.common'
    ]);

})(window.angular);