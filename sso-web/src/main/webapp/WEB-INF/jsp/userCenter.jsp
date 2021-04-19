<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
    <meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
    <title>我的信息</title>
     <link rel="icon" href="assets/images/img/favicon.ico">

    <link rel="stylesheet" type="text/css" href="../../css/homecss/webbase.css" />
    <link rel="stylesheet" type="text/css" href="../../css/homecss/pages-seckillOrder.css" />
</head>

<body>

	<!-- 头部栏位 -->
	<!--页面顶部，由js动态加载-->
	<script type="text/javascript" src="../../js/plugins/jquery/jquery.min.js"></script>
	<div id="nav-bottom"></div>
    <script type="text/javascript">$("#nav-bottom").load("top.html");</script>

<script type="text/javascript" src="../../js/homejs/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#service").hover(function(){
		$(".service").show();
	},function(){
		$(".service").hide();
	});
	$("#shopcar").hover(function(){
		$("#shopcarlist").show();
	},function(){
		$("#shopcarlist").hide();
	});

})
</script>
<script type="text/javascript" src="../../js/homejs/plugins/jquery.easing/jquery.easing.min.js"></script>
<script type="text/javascript" src="../../js/homejs/plugins/sui/sui.min.js"></script>
<script type="text/javascript" src="../../js/homejs/plugins/jquery-placeholder/jquery.placeholder.min.js"></script>
<script type="text/javascript" src="../../js/homejs/widget/nav.js"></script>
</body>
    <!--header-->
    <div id="account">
        <div class="py-container">
            <div class="yui3-g ../../">
                <!--左侧列表-->
                <div class="yui3-u-1-6 list">

                    <div class="person-info">
                        <div class="person-photo"><img src="../../images/img/_/photo.png" alt=""></div>
                        <div class="person-account">
                            <span class="name">${userCenterInfo.getCustname()}</span>
                            <span class="safe"><a href="http://localhost:8088/user/loginout">退出登录 </a></span>
                        </div>
                        <div class="clearfix"></div>
                    </div>
                    <div class="list-items">
                        <dl>
							<dt><i>·</i> 订单中心</dt>
							<dd ><a href="http://localhost:8088/user/center/"  class="list-active" >我的订单</a></dd>
						</dl>
						<dl>
							<dt><i>·</i> 设置</dt>
							<dd><a href="../../-setting-address.html"  >地址管理</a></dd>
							<dd><a href="http://localhost:8088/user/centerSafe" >安全管理</a></dd>
						</dl>
                    </div>
                </div>
                <!--右侧主内容-->
                <div class="yui3-u-5-6 order-pay">
                    <div class="body">
                        <div class="table-title">
                            <table class="sui-table  order-table">
                                <tr>
                                    <thead>
                                        <th width="35%">宝贝</th>
                                        <th width="5%">单价</th>
                                        <th width="5%">数量</th>
                                        <th width="10%">实付款</th>
                                        <th width="10%">交易操作</th>
                                    </thead>
                                </tr>
                            </table>
                        </div>
                        <div class="order-detail">
                        
                        
                        <c:forEach items="${orderItemList}" var="orderitem">
                            <div class="orders">
								<!--order1-->
                                <div class="choose-title">
                                           <span>订单编号：${orderitem.getOrderId()} </span>
                                           <a href="http://localhost:8088/user/delOrder?orderId=${orderitem.getOrderId()}" style="float: right;" class="sui-btn btn-info SHARE-btn">刪除订单</a>
                                </div>
                                <table class="sui-table table-bordered order-datatable">
                                    <tbody>
                                    
                                    <c:forEach items="${orderitem.getItems()}" var="item">
                                        <tr>
                                            <td width="35%">
                                                <div class="typographic"><img style="height: 82px; width: 82px;" src="${item.getPicPath() }" />
                                                    <a href="#" class="block-text">${ item.getTitle()}</a>
                                                </div>
                                            </td>
                                            <td width="5%" class="center">
                                                <ul class="unstyled">
                                                    <li>¥${item.getPrice() }</li>
                                                </ul>
                                            </td>
                                            <td width="5%" class="center">${item.getNum() }</td>
                                            <td width="10%" class="center" >
                                                <ul class="unstyled">
                                                    <li>¥${item.getPrice() }.00</li>
                                                </ul>
                                            </td>
                                            <td width="10%" class="center">
                                                <ul class="unstyled">
													<li><a  class="sui-btn btn-info">货到付款</a></li>
                                                </ul>
                                            </td>
                                        </tr>
                                        </c:forEach>
                                        
                                    </tbody>
                                </table>
                            </div>
                            </c:forEach>
                            
                            
                            

                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

	<!-- 底部栏位 -->
	<!--页面底部，由js动态加载-->
	<div class="clearfix footer"></div>
	<script type="text/javascript">$(".footer").load("foot.html");</script>
	<!--页面底部END-->

</html>