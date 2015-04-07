angular.module('app')
    .directive('navigation', function () {
       return {
           restrict: 'E',
           replace: false,
           templateUrl: 'views/navigation/navigation-directive.html',
           controller: function ($scope) {

               $scope.menu = [
                   {label: 'HOME', link: '#home'},
                   {label: 'LESSONS', link: '#lessons'},
                   {label: 'STORE', link: '#store'},
                   {label: 'GALLERY', link: '#gallery'},
                   {label: 'TRIPS', link: '#trips'},
                   {label: 'CONTACT', link: '#contact'}
               ];

               $scope.setActive = function(element){
                   $scope.activeElement = element;
               };

               $scope.getActive = function (element){
                 return element == $scope.activeElement ? 'active': '';
               }
           }
       }
    });