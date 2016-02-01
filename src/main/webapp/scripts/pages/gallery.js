angular.module('app').service('galleryService', function( $resource) {
	
	return {
		findAll : $resource('/admin/gallery/all'),
		findAllSlider : function(){
			var allGallery = findAll.query();
//			allGallery.$promise.then(function (result) {
//			   return result;
//			});
			return 	allGallery.$promise;
		},
		save : $resource('/admin/gallery')
	};
});


//angular.module('app').controller("GalleryController", function($scope, gallery, galleryService){
//	$scope.gallery = gallery;
//	
//	$scope.findAll = function(){
//		    alert("Find all");
//			$scope.gallery = galleryService.findAll().query();
//	};
//	
//	$scope.loadById = function(item){
//		return '/admin/gallery/' + item.id;
//	};
//	
//	 angular.element(document).ready(function () {
//	 //	alert("Ready angular");
//	 //	$scope.gallery = galleryService.findAll.query();
//	// 	alert("Gallery loaded");
//	 });
//});

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