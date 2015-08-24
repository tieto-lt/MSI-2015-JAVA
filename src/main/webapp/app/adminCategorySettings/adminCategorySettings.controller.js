(function (angular) {
  'use strict';

  angular
    .module('app.adminCategorySettings')
    .controller('AdminCategorySettings', AdminCategorySettings);

  AdminCategorySettings.$inject = ['CategoryFactory'];

  function AdminCategorySettings(CategoryFactory) {
	  var vm = this;
	  
	  vm.categories = CategoryFactory.getCategories();
	  
  }
  

})(window.angular);