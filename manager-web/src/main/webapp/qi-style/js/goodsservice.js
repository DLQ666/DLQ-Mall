app.service('goodsService',function($http){
	this.add=function(show){
		return  $http.post("../oitem/addProduct.action",show);
	}
	
});