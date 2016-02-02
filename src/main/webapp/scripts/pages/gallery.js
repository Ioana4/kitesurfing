angular.module('app').controller("GalleryController", function($scope, gallery, galleryService){
	$scope.gallery = gallery;
	
	$scope.loadById = function(item){
		return '/admin/gallery/' + item.id;
	};
});