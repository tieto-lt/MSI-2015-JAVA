(function (angular) {
  'use strict';

  angular
    .module('MSI-app', [
      'app.pointsTransferInfo',
      'app.registration',
      'app.leaderboard',

      /*commons*/
      'app.common'
    ]);

})(window.angular);