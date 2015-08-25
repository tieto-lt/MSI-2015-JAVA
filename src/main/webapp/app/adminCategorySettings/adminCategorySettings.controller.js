(function (angular) {
  'use strict';

  angular
    .module('app.adminCategorySettings')
    .controller('AdminCategorySettings', AdminCategorySettings);

  AdminCategorySettings.$inject = ['CategoryFactory'];

  function AdminCategorySettings(CategoryFactory) {
	  var vm = this;
	  
	  vm.newCategoryName = '';
	  vm.categories = CategoryFactory.getCategories();
	  vm.deleteCategory = deleteCategory;
	  vm.refreshCategories = refreshCategories;
	  vm.saveCategory = saveCategory;
	  
	  vm.refreshCategories();
	  
	  function deleteCategory(id) {
		  CategoryFactory.deleteCategory(id).then(function() {
			  vm.refreshCategories();
		  });
	  }
	  
	  function saveCategory() {
		  CategoryFactory.saveCategory(vm.newCategoryName).then(function() {
			  vm.refreshCategories();
			  vm.newCategoryName = '';
			  vm.addCategory.$setPristine();
  			  vm.addCategory.$setUntouched();
		  });
	  }
	  
	  function refreshCategories() {
		  CategoryFactory.loadCategories();
	  }
	  
  }
  

})(window.angular);