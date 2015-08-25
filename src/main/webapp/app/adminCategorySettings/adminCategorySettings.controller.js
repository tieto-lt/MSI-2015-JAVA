(function (angular) {
  'use strict';

  angular
    .module('app.adminCategorySettings')
    .controller('AdminCategorySettings', AdminCategorySettings);

  AdminCategorySettings.$inject = ['CategoryFactory'];

  function AdminCategorySettings(CategoryFactory) {
	  var vm = this;
	  
	  vm.categories = CategoryFactory.getCategories();
	  vm.deleteCategory = deleteCategory;
	  vm.refreshCategories = refreshCategories;
	  
	  vm.refreshCategories();
	  
	  function deleteCategory(id) {
		  CategoryFactory.deleteCategory(id).then(function() {
			  vm.refreshCategories();
		  });
	  }
	  
	  function refreshCategories() {
		  CategoryFactory.loadCategories();
	  }
	  
  }
  

})(window.angular);