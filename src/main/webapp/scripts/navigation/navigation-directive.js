angular.module('app').service('menuService', function($resource) {
	return {
		menu : $resource('/navigation/menu'),
		brand : $resource('/navigation/brand')

	};
});

angular.module('app').directive('navigation', function() {
	return {
		restrict : 'E',
		replace : false,
		templateUrl : 'views/navigation/navigation-directive.html',
		controller : function($scope, menuService) {
			// get menus
			$scope.menu = menuService.menu.query();
			// get brand image
			$scope.brand = menuService.brand.get().$promise.then(function (response){
				$scope.brandStyle = "background: url('" + response.url + "') no-repeat; background-size: 130px 60px; width:100px; height:60px"; //
				$scope.brandImage = response;
			});
			
			$scope.activeElement = $scope.menu[0];

			$scope.setActive = function(element) {
				$scope.activeElement = element;
			};

			$scope.getActive = function(element) {
				return element == $scope.activeElement ? 'active' : '';
			};	
		}
	};
});
