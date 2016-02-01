angular.module('app').service('galleryService', function( $resource) {
	
	return {
		findAll : $resource('/admin/gallery/all'),
		save : $resource('/admin/gallery')
	};
});


angular.module('app').controller("GalleryController", function($scope, gallery, galleryService){
	$scope.gallery = gallery;
	
	$scope.loadById = function(item){
		return '/admin/gallery/' + item.id;
	};
});

angular.module('app').controller("AdminGalleryController", function($scope, gallery, galleryService){
	$scope.gallery = gallery;
	$scope.selected = {imageId: gallery[0].id};
	
	$scope.loadById = function(itemId){
		return '/admin/gallery/' + itemId;
	};
	
	$scope.updateImage = function(){
		$scope.image= $scope.loadById();
	};
});