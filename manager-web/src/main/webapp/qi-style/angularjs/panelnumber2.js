/**
 * name: tm.pagination
 * Version: 0.0.2
 */
angular.module('pagination', []).directive('tmPagination',[function(){
    return {
        restrict: 'EA',
        template: '<div class="page-list" ng-class="{disabled: conf.currentPage == conf.numberOfPages}" ng-click="nextPage()">' +
            '</div>',
        replace: true,
        scope: {
            conf: '='
        },
        link: function(scope, element, attrs){
            // pageList数组
            function getPagination(newValue, oldValue) {
                // conf.totalItems2
                scope.conf.totalItems2 = parseInt(scope.conf.totalItems2) ? parseInt(scope.conf.totalItems2) : 0;
                // 如果itemsPerPage在不在perPageOptions数组中，就把itemsPerPage加入这个数组中
                var perPageOptionsLength = scope.conf.perPageOptions.length;
                // 定义状态
                var perPageOptionsStatus;
                for(var i = 0; i < perPageOptionsLength; i++){
                    if(scope.conf.perPageOptions[i] == scope.conf.itemsPerPage){
                        perPageOptionsStatus = true;
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
                if(!scope.conf.totalItems2) {
                    scope.conf.totalItems2 = 0;
                }
                var newValue = scope.conf.totalItems2 + ' ' +  scope.conf.currentPage + ' ' + scope.conf.itemsPerPage;
                return newValue;
            }, getPagination);
        }
    };
}]);
