angular.module('app')
    .directive('navigation', function () {
       return {
           restrict: 'E',
           replace: false,
           templateUrl: 'views/navigation/navigation-directive.html',
           controller: function () {

           }
       }
    });