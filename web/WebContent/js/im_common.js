//下拉列表添加年份
function addYearOption(){
	//根据id查找对象，
	var obj = document.getElementById('year');
	//添加一个选项
	//obj.add(new Option("文本","值"));    //这个只能在IE中有效
	for(var i=2014;i>1940;i--){
		obj.options.add(new Option(i,i)); //这个兼容IE与firefox
	}
}

//下拉列表添加日期
function addDayOption(){
	var obj = document.getElementById('day');
	for(var i=1; i<32; i++){
		obj.options.add(new Option(i, i));
	}
}

//添加错误消息提示
function addAlertError(divId, divClass, spanClass, info){
	/* 警告提示信息格式
	<div class="alert bg-primary" role="alert">
		<span class="glyphicon glyphicon-info-sign"></span> 
		<span>Welcome to the admin dashboard panel bootstrap template </span>
		<a href="#" class="pull-right"><span class="glyphicon glyphicon-remove"></span></a>
	</div> */
	
	//div
	var error = document.createElement("div");
	/*class样式:
	 * alert bg-primary 正常
	 * alert bg-success 成功
	 * alert bg-warning 警告
	 * alert bg-danger  错误*/
	error.setAttribute("id", divId);
	error.setAttribute("class", divClass);
	error.setAttribute("role", "alert");
	
	//div/span 1
	var divSpanSign = document.createElement("span");
	/*class 样式：
	 * glyphicon glyphicon-info-sign
	 * glyphicon glyphicon-check
	 * glyphicon glyphicon-warning-sign*/
	divSpanSign.setAttribute("class", spanClass);
	
	//div/span 2
	var divSpanText = document.createElement("span");
	//divSpanText.innerText = " haha";
	setInnerText(divSpanText, info);
	
	//div/a
	var divA = document.createElement("a");
	divA.setAttribute("href", "#");
	divA.setAttribute("onClick", "delAlertError('" +divId+ "')");
	divA.setAttribute("class", "pull-right");
	
	//div/a/span
	var aSpan = document.createElement("span");
	aSpan.setAttribute("class", "glyphicon glyphicon-remove");
	divA.appendChild(aSpan);

	error.appendChild(divSpanSign);
	error.appendChild(divSpanText);
	error.appendChild(divA);
	document.getElementById("alert_errors").appendChild(error);
}

//删除错误消息
function delAlertError(id){
	 document.getElementById("alert_errors").removeChild(document.getElementById(id));
}

//innerText兼容firefox
function setInnerText(element, text) {
    if (typeof element.textContent == "string") {
        element.textContent = text;
    } else {
        element.innerText = text;
    }
}

//用户名表单校验
function checkUsername(){
	var username = document.getElementById("username").value.trim();
	var reg = /^[a-zA-Z][a-zA-Z0-9_]{5,14}$/;
	if (!reg.test(username)){
		//输出提示信息
		var err_username_msg = document.getElementById("error_username");
		if(err_username_msg == null){
			addAlertError("error_username", "alert bg-danger", "glyphicon glyphicon-warning-sign", 
					"  用户名必须为6-15个以字母开头，可带数字、“_”的字符串 ");
		}
		//更改输入框样式
		changeInputStyle("usernameDiv", "col-md-9 has-error has-feedback", 
				"usernameFeedbackSpan", "glyphicon glyphicon-remove form-control-feedback");
		return false;
	}else {
		//去掉提示信息
		var err_username_msg = document.getElementById("error_username");
		if(err_username_msg != null){
			document.getElementById("alert_errors").removeChild(document.getElementById("error_username"));
		}
		//更改输入框样式
		changeInputStyle("usernameDiv", "col-md-9 has-success has-feedback", 
				"usernameFeedbackSpan", "glyphicon glyphicon-ok form-control-feedback");
		return true;
	}
}

//密码校验
function checkPassword(){
	var password = document.getElementById("password").value.trim();
	var reg = /^[a-zA-Z][a-zA-Z0-9_]{5,19}$/;
	if (!reg.test(password)){
		var err_password_msg = document.getElementById("error_password");
		if(err_password_msg == null) {
			addAlertError("error_password", "alert bg-danger", "glyphicon glyphicon-warning-sign", 
				"  密码必须为6-20个以字母开头，可带数字、“_”的字符串 ");
		}
		//更改输入框样式
		changeInputStyle("passwordDiv", "col-md-9 has-error has-feedback", 
				"passwordFeedbackSpan", "glyphicon glyphicon-remove form-control-feedback");
		return false;
	}else {
		//去掉提示信息
		var err_password_msg = document.getElementById("error_password");
		if(err_password_msg != null){
			document.getElementById("alert_errors").removeChild(document.getElementById("error_password"));
		}
		//更改输入框样式
		changeInputStyle("passwordDiv", "col-md-9 has-success has-feedback", 
				"passwordFeedbackSpan", "glyphicon glyphicon-ok form-control-feedback");
		return true;
	}
}

//密码一致性校验
function checkConfirmPassword(){
	var password = document.getElementById("password").value.trim();
	var confirmPassword = document.getElementById("confirmPassword").value.trim();
	if ((password != confirmPassword) | ((password == null) && (confirmPassword == null))) {
		var err_confirmPsw_msg = document.getElementById("error_confirmPsw");
		if(err_confirmPsw_msg == null) {
			addAlertError("error_confirmPsw", "alert bg-danger", "glyphicon glyphicon-warning-sign", 
				"  两次输入密码不一致 ");
		}
		//更改输入框样式
		changeInputStyle("confirmPasswordDiv", "col-md-9 has-error has-feedback", 
				"confirmPasswordFeedbackSpan", "glyphicon glyphicon-remove form-control-feedback");
		return false;
	}else {
		//去掉提示信息
		var err_confirmPsw_msg = document.getElementById("error_confirmPsw");
		if(err_confirmPsw_msg != null){
			document.getElementById("alert_errors").removeChild(document.getElementById("error_confirmPsw"));
		}
		//更改输入框样式
		changeInputStyle("confirmPasswordDiv", "col-md-9 has-success has-feedback", 
				"confirmPasswordFeedbackSpan", "glyphicon glyphicon-ok form-control-feedback");
		return true;
	}
}

//服务条款隐私策略校验
function checkTerms(){
	var terms = document.getElementById("terms");
	if(!terms.checked) {
		var err_terms_msg = document.getElementById("error_terms");
		if(err_terms_msg == null) {
			addAlertError("error_terms", "alert bg-danger", "glyphicon glyphicon-warning-sign", 
				"  必须同意服务条款和隐私策略 ");
		}
		return false;
	}else {
		var err_terms_msg = document.getElementById("error_terms");
		if(err_terms_msg != null) {
			document.getElementById("alert_errors").removeChild(document.getElementById("error_terms"));
		}
		return true;
	}
}

//更改输入框样式
function changeInputStyle(divId, divClass, spanId, spanClass){
	var usernameDiv = document.getElementById(divId);
	usernameDiv.setAttribute("class", divClass);
	var usernameFeedbackSpan = document.getElementById(spanId);
	usernameFeedbackSpan.setAttribute("class", spanClass);
}

//提交校验
function checkSubmit(){
	var isUsernameChecked = checkUsername();
	var isPasswordChecked = checkPassword();
	var isConfirmPswChecked = checkConfirmPassword();
	var isTermsChecked = checkTerms();
	if (isUsernameChecked && isPasswordChecked && isConfirmPswChecked && isTermsChecked){
		return true;
	}else {
		return false;
	}
}

//实现 JS trim() 方法
String.prototype.trim = function() {  
    return this.replace(/(^\s*)|(\s*$)/g, "");  
} 

//onLoad
function funcInvoke(){
	addDayOption();
	addYearOption();
}