(function () {
	'use strict';
	
	angular
		.module('app.common')
		.factory('CategoryFactory', CategoryFactory);
	
	CategoryFactory.$inject = ['$http', '$filter'];
	
	function CategoryFactory($http, $filter) {
		
		var categories = [];
		loadCategories();
		
		function loadCategories() {
			
			return $http.get('api/categories').then(function(response) {
				categories.length = 0;
				
				angular.extend(categories, $filter('orderBy')(response.data, 'name'));
				
			});
		}
		
		function deleteCategory(id) {
			return $http.delete('api/category/' + id.toString());
		}
		
		function getCategories() {
			return categories;
		}
		
		function saveCategory(name) {
			var transfer = {
					name: name
			}
			return $http.post('api/categories', transfer);
		}
		
		return {
			getCategories: getCategories,
			loadCategories: loadCategories,
			deleteCategory: deleteCategory,
			saveCategory: saveCategory
		};
	}
	
})();