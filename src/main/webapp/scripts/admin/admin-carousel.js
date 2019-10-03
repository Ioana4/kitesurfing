angular.module('app').service('adminCarouselService', function($resource) {
	return {
		load : $resource('/admin/carousel'),
		save : function(item) {
			$resource('/admin/carousel', item);
		},
		remove: function(idToDelete){
			$resource('admin/carousel/:id', {id:'@id'}).remove({id : idToDelete});
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
			
			$scope.carouselImage = function(item){
				return '/home/carousel/content/' + item.id;
			};
			
			$scope.deleteImage = adminCarouselService.remove;
		});