angular.module('places-app', [])

    .controller('AppCtrl', function($scope) {


        $scope.selectPlace = selectPlace;

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

        function selectPlace(place) {
            $scope.selectedPlace = place;
        }

    });