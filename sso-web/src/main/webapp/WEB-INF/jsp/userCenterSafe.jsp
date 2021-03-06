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
    <title>设置-个人信息</title>
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
<script>
        $(function(){
            //jquery.validate
            $("#jsForm").validate({
            submitHandler: function() {
                //验证通过后 的js代码写在这里
            }
        })		
        })
    
        //下面是一些常用的验证规则扩展

        /*-------------验证插件配置 懒人建站http://www.51xuediannao.com/-------------*/

        //配置错误提示的节点，默认为label，这里配置成 span （errorElement:'span'）
        $.validator.setDefaults({
        errorElement:'span'
        });

        //配置通用的默认提示语
        $.extend($.validator.messages, {
        required: '必填',
        equalTo: "请再次输入相同的值"
        });

        /*-------------扩展验证规则使用-------------*/
        //邮箱 
        jQuery.validator.addMethod("mail", function (value, element) {
        var mail = /^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$/;
        return this.optional(element) || (mail.test(value));
        }, "邮箱格式不对");

        //电话验证规则
        jQuery.validator.addMethod("phone", function (value, element) {
        var phone = /^0\d{2,3}-\d{7,8}$/;
        return this.optional(element) || (phone.test(value));
        }, "电话格式如：0371-68787027");

        //区号验证规则  
        jQuery.validator.addMethod("ac", function (value, element) {
        var ac = /^0\d{2,3}$/;
        return this.optional(element) || (ac.test(value));
        }, "区号如：010或0371");

        //无区号电话验证规则  
        jQuery.validator.addMethod("noactel", function (value, element) {
        var noactel = /^\d{7,8}$/;
        return this.optional(element) || (noactel.test(value));
        }, "电话格式如：68787027");

        //手机验证规则  
        jQuery.validator.addMethod("mobile", function (value, element) {
        var mobile = /^1[3|4|5|7|8]\d{9}$/;
        return this.optional(element) || (mobile.test(value));
        }, "手机格式不对");

        //邮箱或手机验证规则  
        jQuery.validator.addMethod("mm", function (value, element) {
        var mm = /^[a-z0-9._%-]+@([a-z0-9-]+\.)+[a-z]{2,4}$|^1[3|4|5|7|8]\d{9}$/;
        return this.optional(element) || (mm.test(value));
        }, "格式不对");

        //电话或手机验证规则  
        jQuery.validator.addMethod("tm", function (value, element) {
        var tm=/(^1[3|4|5|7|8]\d{9}$)|(^\d{3,4}-\d{7,8}$)|(^\d{7,8}$)|(^\d{3,4}-\d{7,8}-\d{1,4}$)|(^\d{7,8}-\d{1,4}$)/;
        return this.optional(element) || (tm.test(value));
        }, "格式不对");

        //年龄
        jQuery.validator.addMethod("age", function(value, element) {   
        var age = /^(?:[1-9][0-9]?|1[01][0-9]|120)$/;
        return this.optional(element) || (age.test(value));
        }, "不能超过120岁"); 
        ///// 20-60   /^([2-5]\d)|60$/

        //传真
        jQuery.validator.addMethod("fax",function(value,element){
        var fax = /^(\d{3,4})?[-]?\d{7,8}$/;
        return this.optional(element) || (fax.test(value));
        },"传真格式如：0371-68787027");

        //验证当前值和目标val的值相等 相等返回为 false
        jQuery.validator.addMethod("equalTo2",function(value, element){
        var returnVal = true;
        var id = $(element).attr("data-rule-equalto2");
        var targetVal = $(id).val();
        if(value === targetVal){
            returnVal = false;
        }
        return returnVal;
        },"不能和原始密码相同");

        //大于指定数
        jQuery.validator.addMethod("gt",function(value, element){
        var returnVal = false;
        var gt = $(element).data("gt");
        if(value > gt && value != ""){
            returnVal = true;
        }
        return returnVal;
        },"不能小于0 或空");

        //汉字
        jQuery.validator.addMethod("chinese", function (value, element) {
        var chinese = /^[\u4E00-\u9FFF]+$/;
        return this.optional(element) || (chinese.test(value));
        }, "格式不对");

        //指定数字的整数倍
        jQuery.validator.addMethod("times", function (value, element) {
        var returnVal = true;
        var base=$(element).attr('data-rule-times');
        if(value%base!=0){
            returnVal=false;
        }
        return returnVal;
        }, "必须是发布赏金的整数倍");

        //身份证
        jQuery.validator.addMethod("idCard", function (value, element) {
        var isIDCard1=/^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$/;//(15位)
        var isIDCard2=/^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}([0-9]|X)$/;//(18位)

        return this.optional(element) || (isIDCard1.test(value)) || (isIDCard2.test(value));
        }, "格式不对");
    </script>
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
							<dd ><a href="http://localhost:8088/user/center/" >我的订单</a></dd>
						</dl>
						<dl>
							<dt><i>·</i> 设置</dt>
							<dd><a href="../../-setting-address.html"  >地址管理</a></dd>
							<dd><a href="http://localhost:8088/user/centerSafe"  class="list-active" >安全管理</a></dd>
						</dl>
                    </div>
                </div>
                
                <!--右侧主内容-->
                <div class="yui3-u-5-6">
                    <div class="body userSafe">
                        <ul class="sui-nav nav-tabs nav-large nav-primary ">
                            <li class="active"><a href="#one" data-toggle="tab">密码设置</a></li>
                        </ul>
                        <div class="tab-content ">
                            <div id="one" class="tab-pane active">
                                <form class="sui-form form-horizontal sui-validate" action="/user/pwd" id="jsForm">
                                    <div class="control-group">
                                        <label for="inputPassword" class="control-label">新密码：</label>
                                        <div class="controls">
                                            <input class="fn-tinput" type="password" name="password" value="" placeholder="新密码" required id="password" data-rule-remote="php.php">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label for="inputRepassword" class="control-label">确认新密码：</label>
                                        <div class="controls">
                                            <input class="fn-tinput" type="password" name="confirm_password" value="" placeholder="确认新密码" required equalTo="#password">
                                        </div>
                                    </div>

                                    <div class="control-group">
                                        <label class="control-label"></label>
                                        <div class="controls">
                                            <button type="submit" class="sui-btn btn-primary">提交按钮</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            
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