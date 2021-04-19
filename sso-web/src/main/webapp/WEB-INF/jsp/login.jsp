<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=9; IE=8; IE=7; IE=EDGE">
	<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE7" />
	<title>欢迎登录登录奇酷商城首页！</title>
	<link rel="Shortcut Icon" href="../images/icon.png"  type="image/x-icon" />
	<link rel="Bookmark" href="../images/icon.png" type="image/x-icon" />
	<link rel="shortcut icon" href="../images/favicon.ico"  />
    <link rel="stylesheet" type="text/css" href="../css/webbase.css" />
    <link rel="stylesheet" type="text/css" href="../css/qi-login.css" />
    <script type="text/javascript" src="/js/jquery-1.6.4.js"></script>
</head>
<body>
	<div class="login-box">
		<!--head-->
		<div class="h_panel">
        <div class="h_logo">
        </div>
    </div>
		<!--loginArea-->
		<div  class="loginArea">
			<div class="login ">
				<div class="py-container">
					<div class="loginform">
						<ul class="sui-nav nav-tabs tab-wraped">
							<li><a href="#profile" data-toggle="tab">
									<h3>用户登录</h3>
							</a></li>

						</ul>
						<div class="tab-content tab-wraped">
							<div id="profile" class="tab-pane  active">
								<form class="sui-form"  method="post" id="formlogin" >
									<div class="input-prepend">
										<input id="loginname" name="custname" type="text"
											placeholder="请输入用户名" class="span2 input-xfat">
									</div>
									<script type="text/javascript">
										setTimeout(function() {
											if (!$("#loginname").val()) {
												$("#loginname").get(0).focus();
											}
										}, 0);
									</script>
									<div class="input-prepend">
										 <input id="nloginpwd" name="custpassword" type="password"
											placeholder="请输入密码" class="span2 input-xfat">
									</div>
									
									<div class="logined">
										<!-- <a class="sui-btn btn-block btn-xlarge btn-danger"	onclick="document:qilogin.submit()"	target="_blank">登&nbsp;&nbsp;录</a> -->
										<input type="button" class="sui-btn btn-block btn-xlarge btn-danger" id="loginsubmit" value="登&nbsp;&nbsp;录" tabindex="8" clstag="passport|keycount|login|06"/>
									</div>
								</form>
								<div class="otherlogin">
									<div class="types">
										 <ul>
											<li><img src="/images/dlqq.png" width="35px" height="35px" /></li>
											<li><img src="/images/dlwb.png" /></li>
											<li><img src="/images/dlzfb.png" /></li>
											<li><img src="/images/dlwx.png" /></li>
										</ul> 
									</div>
           								<span><a href="/page/register" clstag="passport|keycount|login|08">免费注册&gt;&gt;</a></span>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--foot-->
		<div class="py-container copyright">
			<ul>
				<li>关于我们</li>
				<li>联系我们</li>
				<li>联系客服</li>
				<li>营销中心</li>
				<li>常见问题</li>
				<li>隐私政策</li>
			</ul>
			</div>
		</div>
	
</body>
<script type="text/javascript">
	var redirectUrl = "${redirect}";
	var LOGIN = {
			checkInput:function() {
				if ($("#loginname").val() == "") {
					alert("用户名不能为空");
					$("#loginname").focus();
					return false;
				}
				if ($("#nloginpwd").val() == "") {
					alert("密码不能为空");
					$("#nloginpwd").focus();
					return false;
				}
				return true;
			},
			doLogin:function() {
				$.post("/user/login", $("#formlogin").serialize(),function(data){
					if (data.status == 200) {
						alert("登录成功！");
						if (redirectUrl == "") {
							location.href = "http://localhost:8082";
						} else {
							location.href = redirectUrl;
						}
					} else {
						alert("登录失败，原因是：" + data.msg);
						$("#loginname").select();
					}
				});
			},
			login:function() {
				if (this.checkInput()) {
					this.doLogin();
				}
			}
		
	};
	$(function(){
		$("#loginsubmit").click(function(){
			LOGIN.login();
		});
	}); 
</script>
</html>