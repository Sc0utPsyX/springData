angular.module ('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8190/app/api/v1/products';
    $scope.start = 0;
    $scope.end = 10;
    $scope.productsList = [];
    $scope.length = 0;

    $scope.loadProducts = function () {
        $http.get(contextPath)
            .then(function (response) {
                console.log(response.data);
                $scope.productsList = response.data;
                $scope.length = $scope.productsList.length;
            });
    };
    $scope.deleteProductById = function (productId){
        $http({
        url: contextPath + ("/") + productId,
        method: "DELETE"
        }).then(function (response){
            $scope.loadProducts();
        });
    };

    $scope.createProduct = function (productTitle, productCost){
        $http({
            url: contextPath + '?title=' + productTitle + '&cost=' + productCost,
            method: "POST"
        }).then(function (response){
            $scope.loadProducts();
        });
    };

    $scope.getSlicedProductList = function (start, end) {
        return $scope.productsList.slice(start, end);
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

    $scope.loadProducts();

});