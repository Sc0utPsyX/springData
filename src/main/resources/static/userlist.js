angular.module ('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/app/api/v1/users';
    $scope.start = 0;
    $scope.end = 10;
    $scope.usersList = [];
    $scope.length = 0;

    $scope.loadUsers = function () {
        $http.get(contextPath)
            .then(function (response) {
                console.log(response.data);
                $scope.usersList = response.data;
                $scope.length = $scope.usersList.length;
            });
    };


    $scope.getSlicedUserList = function (start, end) {
        return $scope.usersList.slice(start, end);
    }

    $scope.changePage = function (direction){
        if (direction == true) {
            if($scope.end < $scope.length){
                $scope.start += 10;
                $scope.end += 10;
            }
        }
        if (direction == false) {
            if ($scope.start == 0) {
                return;
            }
            $scope.start -= 10;
            $scope.end -= 10;
        }
    }

    $scope.loadUsers();

});