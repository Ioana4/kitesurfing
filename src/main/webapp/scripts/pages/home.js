angular.module('app').service('homeService', function($resource) {
	return {
		carousel : $resource('/home/carousel'),
		save : $resource('')
	};
});


angular.module('app').controller("HomeController", function($scope, homeService){
	//load carousel photos
	$scope.carousel = homeService.carousel.query();
	
	//display carousel image
	$scope.carouselImage = function(item){
		return '/home/carousel/content/' + item.id;
	};
});