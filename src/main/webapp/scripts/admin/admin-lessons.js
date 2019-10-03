angular.module('app').service('lessonsService', function($resource) {
	return {
		module :  $resource('/lessons/module:id', {}, {
		      query: {method:'GET', params:{id:''}, isArray:true},
		      post: {method:'POST'},
		      remove: {method:'DELETE'}
		})
	};
});

angular.module('app').controller("LessonsController", function($scope, lessonsService) {
	
	$scope.chapters =[];
	$scope.save = function() {
		lessonsService.module.post($scope.module);
	};
	
	$scope.addChapter = function(){
		var chapterToSave = {
				"title" : "testChapter"
		};
		$scope.chapters.push(chapterToSave);
	};
	
	$scope.deleteChapter = function(title){
		
	};
});

