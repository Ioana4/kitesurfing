angular
    .module('app')
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/', {
                  templateUrl: 'views/home/home.html'
            })
            .when('/lessons', {
                  templateUrl: 'views/lessons/lessons.html'
            })
            .when('/store', {
                  templateUrl: 'views/store/store.html'
            })
            .when('/gallery', {
                  templateUrl: 'views/gallery/gallery.html'
            })
            .when('/trips', {
                  templateUrl: 'views/trips/trips.html'
            })
            .when('/contact', {
                  templateUrl: 'views/contact/contact.html'
            });           
    }]);