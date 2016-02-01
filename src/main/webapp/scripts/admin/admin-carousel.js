angular.module('app').service('adminCarouselService', function($resource) {
	return {
		load : $resource(''),
		save : function(item) {
			$resource('/admin/carousel', item);
		}
	};
});

angular.module('app').controller("AdminCarouselController",
		function($scope, adminCarouselService) {
			$scope.carousel = adminCarouselService.load.query();

			$scope.save = function() {
				var request = {
					caption : $scope.caption,
					targetUrl : $scope.targetUrl,
					file : $scope.file
				};
				adminCarouselService.save(request);
			};
		});