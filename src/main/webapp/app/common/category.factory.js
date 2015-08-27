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
				
				for (var i = 0; i < categories.length; i++) {
					if(categories[i].name.toLowerCase() == "other") {
						for (var j = i; j < categories.length-1; j++) {
							var tempCategory = categories[j];
							categories[j] = categories[j+1];
							categories[j+1] = tempCategory;
						}
						break;
					}
				}
				
			});
		}
		
		function deleteCategory(id) {
			return $http.delete('admin/category/' + id.toString());
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