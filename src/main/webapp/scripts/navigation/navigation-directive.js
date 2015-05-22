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
                   {label: 'LESSONS', link: '#lessons'
                	   , submenu: [
                	       
                	       {label: 'Free taste', link: '#freeTaste'} ,
                	       {label: 'INTRODUCTION', link: '#lessons'},
                	       {label: 'MODULE1', link: '#module1'}, 
                	       {label: 'MODULE2', link: '#module2'}, 
                	       {label: 'MODULE3', link: '#module3'},
                	       {label: 'NEXT LEVEL', link: '#nextLevel'}, 
                	       {label: 'FAQ', link: '#module4'}
                	   ]
                   },
                   {label: 'GALLERY', link: '#gallery'},
                   {label: 'VIDEO', link: '#video'},
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
