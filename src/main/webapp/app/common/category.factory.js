(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('CategoryFactory', CategoryFactory);
	
	CategoryFactory.$inject = ['$http'];
	
	function CategoryFactory($http) {
		
		var categories = [];
		loadCategories();
		
		function loadCategories() {
			
			return $http.get('api/categories').then(function(response) {
				categories.length = 0;
				angular.extend(categories, response.data);
			});
		}
		
		function deleteCategory(id) {
			return $http.delete('api/category/' + id.toString());
		}
		
		function getCategories() {
			return categories;
		}
		
		return {
			getCategories: getCategories,
			loadCategories: loadCategories,
			deleteCategory: deleteCategory
		};
	}
	
})();