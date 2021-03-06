(function (angular) {
  'use strict';

  angular
    .module('MSI-app', [
      /* ui-router */
      'ui.router',
      
      /* modules */
      'ngMaterial',
      'twygmbh.auto-height',
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
      'app.statistics',
      'app.tourDialog',
      'app.slideshow',
      'app.achievements',

     
      /* angular ngMessages */
      'ngMessages',

      /* commons */
      'app.common'
    ]);

})(window.angular);