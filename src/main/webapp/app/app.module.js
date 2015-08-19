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
      'app.navigation',
      'app.adminShopAddItem',
      'app.shopItem',
      'app.itemDescription',
      
      /*angular ngMessages*/
      'ngMessages',

      /*commons*/
      'app.common',
      
      /*ui-router*/
      'ui.router'
    ]);

})(window.angular);