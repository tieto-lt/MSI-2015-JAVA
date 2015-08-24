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
				console.log(response.data);
				angular.extend(categories, response.data);
			});
		}
		
		function getEnabledCategories() {
			var enabledCategories = [];
			categories.forEach(function(category) {
				if (category.enabled) {
					enabledCategories.push(category);
				}
			})
			
			return enabledCategories;
		}
		
		return {
			getEnabledCategories: getEnabledCategories,
			loadCategories: loadCategories
		};
	}
	
})();