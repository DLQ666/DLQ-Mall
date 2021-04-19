var app = angular.module("qihome", [ 'pagination' ]);
app.controller("qiobrandController", function($scope, $http, $location, $window) {
	$scope.findList = function() {
		$http.get("../obrand/seekBrandAll.action").success(
				function(answer) {
					$scope.blist = answer;
				});
	}

	$scope.qiPaginationCofig = {
		//当前页
		currentPage : 1,
		//总记录数
		totalItems : 10,
		//每页记录数
		itemsPerPage : 5,
		//下拉分页选项
		perPageOptions : [ 10, 20, 30, 40, 50 ],
		//页码变更自动触发onChange
		onChange : function() {
			$scope.renovateList();
		}
	}
	//刷新
	$scope.renovateList = function() {
		$scope.findPages($scope.qiPaginationCofig.currentPage,	$scope.qiPaginationCofig.itemsPerPage);
	}

	$scope.findPages = function(pageNum, pageRows) {
		$http.get("../qioPage/findPages2.action?pageNum=" + pageNum + "&pageRows=" + pageRows).success(
				function(answer) {
					$scope.blist = answer.rows;
					$scope.qiPaginationCofig.totalItems = answer.total;
				});
	}

});