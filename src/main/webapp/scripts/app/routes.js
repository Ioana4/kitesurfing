angular
    .module('app')
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider
            .when('/', {
                  templateUrl: 'views/home/home.html'
            })
             .when('/home', {
                  templateUrl: 'views/home/home.html'
            })
            .when('/about', {
                  templateUrl: 'views/about/about.html'
            })
            .when('/lessons', {
                  templateUrl: 'views/lessons/lessons.html'
            })
            .when('/store', {
                  templateUrl: 'views/store/store.html'
            })
            .when('/gallery', {
                  templateUrl: 'views/gallery/video.html'
            })
            .when('/travel', {
                  templateUrl: 'views/travel/travel.html'
            })
            .when('/contact', {
                  templateUrl: 'views/contact/contact.html'
            });           
    }]);