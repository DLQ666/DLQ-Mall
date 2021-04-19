/**
 * name: tm.pagination
 * Version: 0.0.2
 */
angular.module('pagination', []).directive('tmPagination',[function(){
    return {
        restrict: 'EA',
        template: '<div class="page-list" ng-class="{disabled: conf.currentPage1 == conf.numberOfPages}" ng-click="nextPage()">' +
            '</div>',
        replace: true,
        scope: {
            conf: '='
        },
        link: function(scope, element, attrs){
            // pageList数组
            function getPagination(newValue, oldValue) {
                // conf.totalItems1
                scope.conf.totalItems1 = parseInt(scope.conf.totalItems1) ? parseInt(scope.conf.totalItems1) : 0;
                // 如果itemsPerPage1在不在perPageOptions1数组中，就把itemsPerPage1加入这个数组中
                var perPageOptions1Length = scope.conf.perPageOptions1.length;
                // 定义状态
                var perPageOptions1Status;
                for(var i = 0; i < perPageOptions1Length; i++){
                    if(scope.conf.perPageOptions1[i] == scope.conf.itemsPerPage1){
                        perPageOptions1Status = true;
                    }
                }
                if(scope.conf.onChange){
                    // 防止初始化两次请求问题
                    if(!(oldValue != newValue && oldValue[0] == 0)) {
                        scope.conf.onChange();
                    }
                }
                scope.$parent.conf = scope.conf;
            }
            scope.$watch(function() {
                if(!scope.conf.totalItems1) {
                    scope.conf.totalItems1 = 0;
                }
                var newValue = scope.conf.totalItems1 + ' ' +  scope.conf.currentPage1 + ' ' + scope.conf.itemsPerPage1;
                return newValue;
            }, getPagination);
        }
    };
}]);
