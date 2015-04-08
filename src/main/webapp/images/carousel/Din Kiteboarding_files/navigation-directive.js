angular.module('app')
    .directive('navigation', function () {
       return {
           restrict: 'E',
           replace: false,
           templateUrl: 'views/navigation/navigation-directive.html',
           controller: function ($scope) {

               $scope.menu = [
                   {label: 'HOME', link: '#home'},
                   {label: 'ABOUT', link: '#about'},
                   {label: 'LESSONS', link: '#lessons'},
                   {label: 'GALLERY', link: '#gallery'},
                   {label: 'STORE', link: '#store'},
                   {label: 'TRAVEL', link: '#travel'},
                   {label: 'CONTACT', link: '#contact'}
               ];

               $scope.activeElement = $scope.menu[0];

               $scope.setActive = function(element){
                   $scope.activeElement = element;
               };

               $scope.getActive = function (element){
                 return element == $scope.activeElement ? 'active': '';
               }
           }
       }
    });