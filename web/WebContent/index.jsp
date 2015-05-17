<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Archilochus - Sign up</title>
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">

	<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/im_common.js"></script>
	
</head>

<body onload="funcInvoke();">
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><span>Archilochus</span>IM</a>
			</div>
		</div><!-- /.container-fluid -->
	</nav>
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header"></h1>
			</div>
		</div><!--/.row-->
		
		
		<div class="row">
		
			<!-- 错误提示信息  -->
			<div id="alert_errors" class="col-lg-10">
			</div>
			
			<div class="col-md-10">
				<div class="panel panel-default">
					<div class="panel-heading"><span class="glyphicon glyphicon-user"></span> 注册</div>
					<div class="panel-body">
						<form id="regForm" name="regForm" class="form-horizontal" action="register.jsp" method="POST">
							<fieldset>
								
								<!-- Name input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="name">用户名</label>
									<div id="usernameDiv" class="col-md-9"><!--col-md-9 has-success has-feedback  -->
										<input id="username" name="username" type="text" onBlur="checkUsername();" placeholder="Your name" class="form-control">
										<span id="usernameFeedbackSpan" class=""></span>
									</div>
								</div>
							
								<!-- Password input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="password">密码</label>
									<div id="passwordDiv" class="col-md-9">
										<input id="password" name="password" type="password" onBlur="checkPassword();" placeholder="Your password" class="form-control">
										<span id="passwordFeedbackSpan" class=""></span>
									</div>
								</div>
							
								<!-- Confirm Password input-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="confirm password">确认密码</label>
									<div id="confirmPasswordDiv" class="col-md-9">
										<input id="confirmPassword" name="confirmPassword" type="password" onBlur="checkConfirmPassword();" placeholder="Your confirm password" class="form-control">
										<span id="confirmPasswordFeedbackSpan" class=""></span>
									</div>
								</div>
								
								<!-- Gender Radio-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="gender">性别</label>
									<div class="col-md-9">
										<label class="radio-inline">
											<input type="radio" name="gender" id="gender" value="male" checked>男
										</label>
										<label class="radio-inline">
											<input type="radio" name="gender" id="gender" value="female">女
										</label>
									</div>
								</div>
								
								<!-- Birthday Selects-->
								<div class="form-group">
									<label class="col-md-3 control-label">出生日期</label>
									<div class="col-md-9">
										<select id="day" class="form-control" style="margin-left:0px;width:90px;position:absolute;">
											<option selected="selected" disabled="disabled">日</option>
										</select>
										<select class="form-control" style="margin-left:100px;width:100px;position:absolute;">
											<option selected="selected" disabled="disabled">月</option>
											<option value="January">January</option>
											<option value="February">February</option>
											<option value="March">March</option>
											<option value="April">April</option>
											<option value="May">May</option>
											<option value="June">June</option>
											<option value="July">July</option>
											<option value="August">August</option>
											<option value="September">September</option>
											<option value="October">October</option>
											<option value="November">November</option>
											<option value="December">December</option>
										</select>
										<select id="year" class="form-control" style="margin-left:210px;width:100px;position:absolute;">
											<option selected="selected" disabled="disabled">年</option>
										</select>
									</div>
								</div>
								
								<!-- Privacy Policy Radio-->
								<div class="form-group">
									<label class="col-md-3 control-label" for="gender"></label>
									<div class="col-md-9">
										<label>
											<input id="terms" name="terms" type="checkbox" onClick="checkTerms();" value="1111">我已阅读并同意 <a href="#">服务条款</a> 和 <a href="#">隐私政策</a>。
										</label>
									</div>
								</div>
								
								<!-- Form actions -->
								<div class="form-group">
									<div class="col-md-12 widget-right">
										<button onClick="return checkSubmit();" class="btn btn-primary btn-md pull-right">注 册</button>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
				</div>
								
			</div><!--/.col-->
		</div><!--/.row-->
	</div>	<!--/.main-->
	
</body>
</html>
