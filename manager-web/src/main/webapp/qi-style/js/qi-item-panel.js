    var app = angular.module("qihome", [ 'pagination' ]);
	app.controller("qioController", function($scope, $http) {
		$scope.findList = function() {
			$http.get("../oitem/seekAll.action").success(function(answer) {
				$scope.list = answer;
			});
		}
		$scope.qiPaginationCofig1 = {
			//当前页
			currentPage : 1,
			//总记录数
			totalItems1 : 10,
			//每页记录数
			itemsPerPage : 5,
			//下拉分页选项
			perPageOptions : [ 10, 20, 30, 40, 50 ],
			//页码变更自动触发onChange
			onChange : function() {
				$scope.findPages($scope.qiPaginationCofig1.currentPage,
						$scope.qiPaginationCofig1.itemsPerPage);
			}
		}
		$scope.findPages = function(pageNum, pageRows) {
			$http.get(
					"../qioPage/findPages.action?pageNum=" + pageNum
							+ "&pageRows=" + pageRows).success(
					function(answer) {
						$scope.list = answer.rows;
						$scope.qiPaginationCofig1.totalItems1 = answer.total;
					});
		}

	});