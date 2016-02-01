angular.module('app').service('homeService', function($resource) {
	return {
		carousel : $resource('/home/carousel'),
		save : $resource('')
	};
});


angular.module('app').controller("HomeController", function($scope, homeService){
	$scope.carousel = homeService.carousel.query();
	
	
	$scope.carouselImage = function(item){
		return '/home/carousel/content/' + item.id;
	};
});