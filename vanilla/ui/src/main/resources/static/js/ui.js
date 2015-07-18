angular.module('hello', ['ngRoute'])
    .config(function($routeProvider, $httpProvider){
        $routeProvider.when('/',{
            templateUrl: 'home.html',
            controller: 'home'
        }).when('/login', {
            templateUrl: 'login.html',
            controller: 'navigation'
        }).otherwise('/');

        $httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
}).controller('home', function($scope, $http){
        $http.get('token').success(function(token){
            // TODO A more elegant solution might be to grab the token as needed,
            //  and use an Angular interceptor to add the header to every request
            //  to the resource server. The interceptor definition could then be
            //  abstracted instead of doing it all in one place and cluttering up
            //  the business logic.
            $http({
                url: 'http://localhost:9000',
                method: 'GET',
                headers: {
                    'X-Auth-Token' : token.token
                }
            }).success(function(data){
                $scope.greeting = data;
            });
        })
    })
    .controller('navigation', function($rootScope, $scope, $http, $location){
        var authenticate = function(credentials, callback){
            var headers = credentials ? {authorization : "Basic "
                + btoa(credentials.username + ":" + credentials.password)
            } : {};

            $http.get('user', {headers: headers}).success(function(data){
                if(data.name){
                    $rootScope.authenticated = true;
                } else {
                    $rootScope.authenticated = false;
                }
                callback && callback();
            }).error(function(){
                $rootScope.authenticated = false;
                callback && callback();
            });
        }

        authenticate();
        $scope.credentials = {};
        $scope.login = function(){
            authenticate($scope.credentials, function(){
                if($rootScope.authenticated){
                    $location.path("/");
                    $scope.error = false;
                } else {
                    $location.path("/login");
                    $scope.error = true;
                }
            });
        }
        $scope.logout = function(){
            $http.post('logout',{}).success(function(){
                $rootScope.authenticated = false;
                $location.path("/");
            }).error(function(data){
                $rootScope.authenticated = false;
            });
        }

    });
