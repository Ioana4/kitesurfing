angular.module('app').config([ '$routeProvider', function($routeProvider) {
	$routeProvider
	.when('/home', {
		templateUrl : 'views/home/home.html'
	}).when('/about', {
		templateUrl : 'views/about/about.html'
	}).when('/lessons', {
		templateUrl : 'views/lessons/lessons.html'
	}).when('/store', {
		templateUrl : 'views/store/store.html'
	}).when('/gallery', {
		templateUrl : 'views/gallery/gallery.html',
		controller :  'GalleryController',
		resolve : {
			gallery : function(galleryService) {
				return galleryService.findAll.query().$promise;
			}
		}
	}).when('/video', {
		templateUrl : 'views/gallery/video.html'
	}).when('/travel', {
		templateUrl : 'views/travel/travel.html'
	}).when('/contact', {
		templateUrl : 'views/contact/contact.html'
	}).when('/module1', {
		templateUrl : 'views/lessons/module1.html'
	}).when('/module2', {
		templateUrl : 'views/lessons/module2.html'
	}).when('/module3', {
		templateUrl : 'views/lessons/module3.html'
	}).when('/module4', {
		templateUrl : 'views/lessons/module4.html'
	}).when('/admin/home', {
		templateUrl : 'admin/views/home/home.html'
	}).when('/admin/gallery', {
		templateUrl : 'admin/views/gallery/gallery.html',
		controller :  'AdminGalleryController',
		resolve : {
			gallery : function(galleryService) {
				return galleryService.findAll.query().$promise;
			}
		}
	});
} ]);