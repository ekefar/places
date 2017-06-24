angular.module('places-app', [])

    .controller('AppCtrl', function($scope) {

        init();
        function init() {


            var app = firebase.app();
            firebase.auth();
            var places = firebase.database().ref('/places').once('value').then(function (response) {
                $scope.places = response.val();
                $scope.$apply();
                console.log($scope.places)
            });
        }
    });