(function (angular) {
  'use strict';

  angular
    .module('MSI-app', [
      /* ui-router */
      'ui.router',
      
      /* modules */
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
      'app.userProfileInfo',
      'app.newsFeed',
      'app.newsFeedCurrUser',
      'app.adminCategorySettings',
      'app.userPurchaseHistory',
      'app.adminPurchaseHistory',

      
      /* angular ngMessages */
      'ngMessages',

      /* commons */
      'app.common'
    ]);

})(window.angular);