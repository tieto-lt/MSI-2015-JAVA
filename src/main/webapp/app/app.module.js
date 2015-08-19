(function (angular) {
  'use strict';

  angular
    .module('MSI-app', [
      'ui.router',
                        
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
      
      /*angular ngMessages*/
      'ngMessages',

      /*commons*/
      'app.common'
      
      /*ui-router*/
      
    ]);

})(window.angular);