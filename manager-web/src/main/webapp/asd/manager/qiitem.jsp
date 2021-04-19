<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<script type="text/javascript">
	var app = angular.module("qioitem", ['pagination']);
	app.controller("qioController", function($scope, $http) {
		$scope.findList = function() {
			$http.get("../oitem/seekAll.action").success(function(answer) {
				$scope.list = answer;
			}
			);
		}
		
		$scope.qiPaginationCofig = {
				//当前页
				currentPage:1,
				//总记录数
				totalItems:10,
				//每页记录数
				itemsPerPage:5,
				//下拉分页选项
				perPageOptions:[10,20,30,40,50],
				//页码变更自动触发onChange
				onChange: function(){
					$scope.findPages($scope.qiPaginationCofig.currentPage , $scope.qiPaginationCofig.itemsPerPage);
				}
		}
		$scope.findPages=function(pageNum,pageRows){
			$http.get("../oitem/findPages.action?pageNum="+pageNum +"&pageRows="+pageRows).success(
				function(answer){
					$scope.list = answer.rows;
					$scope.qiPaginationCofig.totalItems=answer.total;
				}		
			);
		}

	});
</script>

	<div class="col-xs-12 col-sm-9 content">
		<div class="bs-example" style="margin-left:15px" ng-app="qioitem" ng-controller="qioController" >
			<h4 class="content-row-title">商品列表</h4>

			<div class="pull-left" >
				<div class="form-group form-inline">
					<div class="btn-group">
						<input type="button" class="btn btn-primary" value="增加">
						<input type="button" class="btn btn-success" value="删除">
						<input type="button" class="btn btn-warning" value="刷新" onclick="window.location.reload();">
					</div>
				</div>
			</div>


			<table class="table table-bordered" style="table-layout: fixed">

				<thead>
					<tr>
						<td><input type="checkbox"></td>
						<th>商品ID</th>
						<th>标题</th>
						<th>商品卖点</th>
						<th>商品价格</th>
						<th>库存数量</th>
						<th>商品图片</th>
						<th>所属类目</th>
						<th>商品状态</th>
						<th>创建时间</th>
						<th>更新时间</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr ng-repeat="show in list">
						<td><input type="checkbox"></td>
						<td>{{show.id}}</td>
						<td>{{show.title}}</td>
						<td>{{show.sellPoint}}</td>
						<td>{{show.price}}</td>
						<td>{{show.stockNum}}</td>
						<td>{{show.img}}</td>
						<td>{{show.cid}}</td>
						<td>{{show.status}}</td>
						<td>{{show.crttime}}</td>
						<td>{{show.updated}}</td>
						<td class="text-center">
							<input style="float: left" type="button" class="btn btn-danger btn-xs" value="修改">
						</td>
					</tr>
				</tbody>
			</table>
			<tm-pagination conf="qiPaginationCofig"></tm-pagination>
			</div>
	
</div>	

