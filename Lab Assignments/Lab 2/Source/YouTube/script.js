
angular.module('myApp', ['ngSanitize'])

    .controller('youtubeSearchController', function ($scope,$sce, $http) {
        $scope.erase = function(){
            $scope.clearInput = "";
        };
        $scope.getVideos = function () {
            var placeEntered = document.getElementById("txt_placeName").value;
            console.log(placeEntered)
            if (placeEntered != null && placeEntered != "") {

                //Youtube API
                var handler = $http.get('https://www.googleapis.com/youtube/v3/search?key=AIzaSyAnZdZV-QQjmUhR5Nw4JOnQpYKEE6SHaSA'+
                    '&part=snippet' +
                    '&q='+ placeEntered
                );

                handler.success(function (data) {
                    console.log(data)
                    //console.log(data.items[0].id.videoId)
                    //$scope.videoID = data.items[0].id.videoId
                    $scope.youtubeSearch = new Array();
                    //$scope.youtubeSearch.push($sce.trustAsHtml('<embed src="'+'https://www.youtube.com/embed/'+ $scope.videoID + '"/>'));

                    //fill youtube search array
                    for(i=0;i<data.items.length; i++) {
                        $scope.videoID = data.items[i].id.videoId
                        console.log($scope.videoID)
                        if ($scope.videoID != undefined){
                            $scope.youtubeSearch.push($sce.trustAsHtml('<embed  src="' + 'https://www.youtube.com/embed/' + $scope.videoID + '"/>'));
                            console.log($scope.youtubeSearch[i]);
                        }
                    }
                    //$('#videos').append($scope.youtubeSearch);
                })
                handler.error(function (data) {
                    alert("There was some error processing your request. Please try after some time.");
                });
            }
        }
    });

