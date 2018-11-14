
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
*{margin: 0px;padding: 0px}
input,select,textarea {margin-top: 20px;}
form{width:48%;}
#right{position: absolute;top:0px;left:50%;width:50%;}
#right span{margin-top: 18px;display: block;}
</style>

</head>
<body>
<form name="user" action="#" id="user" method="post" alt="getinfo.html">
用户名   <input name="txtUser" id="txtUser" type="text"  onblur="return checkForm()"/><br>
密码       <input name="txtPwd" id="txtPwd" type="password"  onblur="return checkForm()"/><br>
确认密码<input name="txtRpt" id="txtRpt" type="password"  onblur="return checkForm()"/><br>
用户类型
<select name="selUser" id="selUser"  onblur="return checkForm()">
<option>请选择</option>
<option>教师</option>
<option>学生</option>
<option>管理员</option>
</select>
<br>
性  别
<input type="radio" name="gender" value="男" onclick="return checkGender()">男
<input type="radio" name="gender" value="女" onclick="return checkGender()">女<br>
出生日期
<input type="text" id="txtDate" placeholder="- 年   - 月   - 日"  onblur="return checkForm()"/>
<br>
兴趣爱好
<input type="checkbox" name="hobby" value="read"  onclick="return changeHobby()">阅读
<input type="checkbox" name="hobby" value="music" onclick="return changeHobby()">音乐
<input type="checkbox" name="hobby" value="sport" onclick="return changeHobby()">运动
<br>
电子邮件
<input name="txtemail" id="txtemail" type="text" onblur="return checkForm()"/><br>
自我介绍
<textarea id="txtIntro" name="txtIntro" cols="80" rows="5" style="resize:none;" onblur="return checkForm()"></textarea>
<input type="submit" value="提交" style="margin-left: 40%;margin-right: 10%;"><input type="reset" value="重置">
</form>
<div id="right">
<span id="tips_username">*用户名由6-18位字符组成</span>
<span id="tips_password">*密码由6-18位字符组成，且必须包含字母，数字和标点符号</span>
<span id="tips_repeat">*请再次输入你的密码</span>
<span id="tips_usertype">*请选择用户类型</span>
<span id="tips_gender">*请选择你的性别</span>
<span id="tips_birthday">*请选择你的出生日期</span>
<span id="tips_hobby">*请选择兴趣爱好</span>
<span id="tips_email">*请填写常用的email,将用于密码找回</span>
<br>
<span id="tips_introduction">*限100字以内</span>
</div>
<script type="text/javascript">
function checkGender()
{
	var gendernum=document.getElementsByName("gender");
	var gender="";
	for(var i=0;i<gendernum.length;i++)
	{
		if(gendernum[i].checked)
		{
			gender=gendernum[i].value;
		}
	}
	if(gender=="")
	{
		document.getElementById("tips_gender").innerHTML="<em style='color:red'>至少选择其中一项</em>";
		return false;
	}else
		{
		document.getElementById("tips_gender").innerHTML="<em style='color:green'>OK!</em>";
		}
}
function checkForm() {
	if(document.getElementById("txtUser").value.length<6||document.getElementById("txtUser").value.length>18)
		{
		document.getElementById("tips_username").innerHTML="<em style='color:red'>用户名由6-18位字符组成</em>";
		document.getElementById("txtUser").focus();
		return false;
		}
	else
		{
		document.getElementById("tips_username").innerHTML="<em style='color:green'>OK!</em>";
		}



	var reg=/[^A-Za-z0-9_]+/;
	var regs=/^[\u4E00-\u9FA5A-Za-z0-9_]+$/;
	if(document.getElementById("txtPwd").value.length<6||document.getElementById("txtPwd").value.length>18||regs.test(document.getElementById("txtPwd").value))
		{
		document.getElementById("tips_password").innerHTML="<em style='color:red'>密码由6-18位字符组成，且必须包含字母，数字和标点符号</em>";
		document.getElementById("txtPwd").focus();
		return false;
		}
	else
		{
		document.getElementById("tips_password").innerHTML="<em style='color:green'>OK!</em>";
		}


	if(document.getElementById("txtPwd").value!=document.getElementById("txtRpt").value)
		{
		document.getElementById("tips_repeat").innerHTML="<em style='color:red'>两次输入的密码不一致</em>";
		document.getElementById("txtRpt").focus();
		return false;
		}else
			{
			document.getElementById("tips_repeat").innerHTML="<em style='color:green'>OK!</em>";
			}

	if(document.getElementById("selUser").selectedIndex==0)
	{
	document.getElementById("tips_usertype").innerHTML="<em style='color:red'>没有选择用户类型</em>";
	document.getElementById("selUser").focus();
	return false;
	}else
		{
		document.getElementById("tips_usertype").innerHTML="<em style='color:green'>OK!</em>";
		}


	if(document.getElementById("txtDate").value=="")
	{
	document.getElementById("tips_birthday").innerHTML="<em style='color:red'>没有填写出生日期</em>";
	document.getElementById("txtDate").focus();
	return false;
	}else
		{
		document.getElementById("tips_birthday").innerHTML="<em style='color:green'>OK!</em>";
		}

	var email=document.getElementById("txtemail").value;
	var pattern=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
	if(email.length==0)
		{
		document.getElementById("tips_email").innerHTML="<em style='color:red'>电子邮件不能为空</em>";
		document.getElementById("txtemail").focus();
		return false;
		}
	else if(!pattern.test(email))
		{
		document.getElementById("tips_email").innerHTML="<em style='color:red'>电子邮件不合法</em>";
		document.getElementById("txtemail").focus();
		return false;
		}
	else
		{
		document.getElementById("tips_email").innerHTML="<em style='color:green'>OK!</em>";
		}

	if(document.getElementById("txtIntro").value.length>100)
	{
	document.getElementById("tips_introduction").innerHTML="<em style='color:red'>长度不能超过100个字符</em>";
	document.getElementById("txtIntro").focus();
	return false;
	}else
		{
		document.getElementById("tips_introduction").innerHTML="<em style='color:green'>OK!</em>";
		}

}
function changeHobby() {
	var hobby=0;
	var objnum=document.getElementsByName("hobby");
	for(var i=0;i<objnum.length;i++)
		{
		if(objnum[i].checked==true)
			{
			hobby++;
			}
		}
	if(hobby>=1)
	{
	document.getElementById("tips_hobby").innerHTML="<em style='color:green'>OK!</em>";
	}else
		{
		document.getElementById("tips_hobby").innerHTML="<em style='color:red'>至少选择其中一项</em>";
		return false;
		}
}
</script>
</body>
</html>
---------------------
作者：安东尼_桑
来源：CSDN
原文：https://blog.csdn.net/qq_28147861/article/details/79516437
版权声明：本文为博主原创文章，转载请附上博文链接！