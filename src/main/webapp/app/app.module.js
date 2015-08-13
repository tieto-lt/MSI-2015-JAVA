(function (angular) {
  'use strict';

  angular
    .module('MSI-app', [
      'ngMaterial',
      'app.pointsTransferInfo',
      'app.registration',
      'app.leaderboard',
      'app.login',
      'app.adminAppSettings',
      'app.logout',
      'app.profileHeader',
      'app.adminNavigation',
      
      /*angular ngMessages*/
      'ngMessages',

      /*commons*/
      'app.common',
      
      /*ui-router*/
      'ui.router'
    ]);

})(window.angular);