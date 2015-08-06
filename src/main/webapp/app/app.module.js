(function (angular) {
  'use strict';

  angular
    .module('MSI-app', [
      'app.pointsTransferInfo',
      'app.registration',
      'app.leaderboard',
      
      /*angular ngMessages*/
      'ngMessages',

      /*commons*/
      'app.common'
    ]);

})(window.angular);