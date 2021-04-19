<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>QIQOO电子商城后台管理系统</title>
<link rel="stylesheet" href="css/iqoo.css">
<script type="text/javascript" src="js/iqoo.js"></script>
<script type="text/javascript" src="js/angularjs/angular.min.js"></script>

<!-- 分页插件 -->
<link rel="stylesheet" href="js/angularjs/pagination.css">
<script type="text/javascript" src="js/angularjs/pagination.js"></script>

<style>
td {
	white-space: nowrap;
	overflow: hidden;
	text-overflow: ellipsis;
}
</style>
</head>
<body>
	<jsp:include page="qihead.jsp"></jsp:include>

	<!-- <div class="page-container"> -->
	<div class="row row-offcanvas row-offcanvas-left">
		<div class="col-xs-6 col-sm-3 sidebar-offcanvas" role="navigation">
			<jsp:include page="qimenu.jsp"></jsp:include>
		</div>
		<div class="col-xs-12 col-sm-9 content">
			<div class="container-fluid">
				<div class="row-fluid">
					<div class="span12">
						<h3 class="page-title">
							控制面板 <small style="color: #45484b">系统信息</small>
						</h3>
						<ul class="breadcrumb">
							<li><i class="icon-home"></i> <a href="javascript:void(0);"
								class="toggle-sidebar"><span class="fa fa-angle-double-left"
									data-toggle="offcanvas" title="Maximize Panel"></span></a><a
								href="#">首页</a> <i class="icon-angle-right"></i></li>
							<li><a href="#">查看信息</a></li>
						</ul>
					</div>
				</div>
			</div>
			
			<div class="col-xl-3 col-sm-6 mb-3">
            <div class="card text-white bg-primary o-hidden h-100">
              <div class="card-body">
                <div class="card-body-icon">
                  <i class="fas fa-fw fa-comments"></i>
                </div>
                <div class="mr-5">26 New Messages!</div>
              </div>
              <a class="card-footer text-white clearfix small z-1" href="#">
                <span class="float-left">View Details</span>
                <span class="float-right">
                  <i class="fas fa-angle-right"></i>
                </span>
              </a>
            </div>
          </div>
			
			<div class="jumbotron">
				<div class="alert alert-block alert-success"
					style="background-color: #E6E9ED">
					<button type="button" class="close" data-dismiss="alert">
						<i class="icon-remove"></i>
					</button>
					<div style="margin-bottom: 20px;color:#FC6E51" >
						<i class="glyphicon glyphicon-calendar"></i>系统当前时间: <span
							id="spanTime"> </span>
					</div>
					<div style="margin-bottom: 20px; color:#48CFAD">
						<i class="glyphicon glyphicon-heart"></i> 欢迎使用 <strong
							class="GRASS"> Qiqoo电子商城管理系统 <small>(v1.5)</small>
						</strong>
					</div>
					<div style="margin-bottom: 20px; color:#AC92EC">
						<i class="glyphicon glyphicon-th-large"></i> 系统架构 <strong
							class="blue"> 基于SSM框架、<small>SOA分布式架构</small>
						</strong>
					</div>
					<div style="margin-bottom: 20px; color:#AC92EC">
						<i class="glyphicon glyphicon-th-large"></i> 操作系统 <strong
							class="blue"> Windows10 家庭版 <small> 版本号:1809</small>
						</strong>
					</div>
					<div style="margin-bottom: 20px; color:#4FC1E9">
						<i class="glyphicon glyphicon-hdd"></i> 应用服务器 <strong
							class="blue"> Apache Tomcat <small>7</small>
						</strong>
					</div>
					<div style="margin-bottom: 20px; color:#4FC1E9">
						<i class="glyphicon glyphicon-hdd"></i> 应用虚拟机 <strong
							class="blue"> VMware® Workstation 12 Pro <small>(v12.5.9)</small>
						</strong>
					</div>
					<div style="margin-bottom: 20px; color:#4FC1E9">
						<i class="glyphicon glyphicon-hdd"></i> 应用虚拟机系统 <strong
							class="blue"> CentOS <small>(v6.4)</small>
						</strong>
					</div>
					<div style="margin-bottom: 20px; color:#4FC1E9">
						<i class="glyphicon glyphicon-hdd"></i> 虚拟机操作系统 <strong
							class="blue"> Linux <small>(v2.6)</small>
						</strong>
					</div>
					<div style="margin-bottom: 20px; color:#4FC1E9">
						<i class="glyphicon glyphicon-hdd"></i> 数据库 <strong class="green">
							Oracle MySql <small>(v5.5)</small>
						</strong>
					</div>
					<div style="margin-bottom: 20px; color:#4FC1E9">
						<i class="glyphicon glyphicon-th-large"></i> 开发语言 <strong
							class="green"> Oracle Java <small>(JDK v1.8)</small>
						</strong>
					</div>
					<div style="margin-bottom: 20px;">
						<iframe id="fancybox-frame" name="fancybox-frame1536885772649"
							frameborder="0" scrolling="no" hspace="0"
							src="http://i.tianqi.com/index.php?c=code&amp;a=getcode&amp;id=34&amp;h=25&amp;w=280&amp;py=jilin"></iframe>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="qifooter.jsp"></jsp:include>
</body>

<script type="text/javascript">
	function fun() {
		var date = new Date();
		document.getElementById("spanTime").innerHTML = (1900 + date.getYear())
				+ "年" + (date.getMonth() + 1) + "月" + date.getDay() + "日"
				+ date.getHours() + "时" + date.getMinutes() + "分"
				+ date.getSeconds() + "秒"
	}
	setInterval(fun, 1000)
</script>
</html>