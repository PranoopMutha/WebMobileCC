function LoginController($scope) {

    $scope.logins = [];
    $scope.login = function (user, pwd) {
        localStorage.setItem("name" , user);
        localStorage.setItem('favoriteflavor','vanilla');
        var taste = localStorage.getItem('favoriteflavor');
        $scope.logins.push( localStorage.getItem("name") + " was logged in.");
    };
}