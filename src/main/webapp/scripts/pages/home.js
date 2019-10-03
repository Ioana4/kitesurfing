angular.module('app').service('homeService', function($resource) {
	return {
		carouselResource : $resource('/home/carousel'),
		save : $resource('')
	};
});


angular.module('app').controller("HomeController", function($scope, carousel){
	//load carousel photos
	$scope.carousel = carousel;
	
	//display carousel image
	$scope.carouselImage = function(item){
		return '/home/carousel/content/' + item.id;
	};
});


