<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" >
var msg = '欢迎使用本系统・・・・・・・・・・・・・・・・'; // メッセージ内容
var speed = 300; // スクロールのスピード（1に近いほど速く）
var move = 2; // スクロールのなめらかさ（1に近いほどなめらかに）

// 設定終了


function disp(){

	msg = msg.substring(move, msg.length) + msg.substring(0, move);

	// テキストフィールドにデータを渡す処理
	document.form1.field1.value = msg;

	setTimeout("disp()", speed);

}

   function teaallCheckForm() {
	var form = document.all('allForm');
    var id= document.all("inputid").value;

    if (id == "" || id == null) {
    	alert("不能爲空");
    	return false;
    }
    if (id == 1) {
    	alert("不能爲1");
    	return false;
    }
    form.submit();
	return true;
}

   function check(){
		if(window.confirm('送信してよろしいですか？')){ // 確認ダイアログを表示

			return true; // 「OK」時は送信を実行
		}
		else{ // 「キャンセル」時の処理
			window.alert('キャンセルされました'); // 警告ダイアログを表示
			return false; // 送信を中止
		}
	}

</script>
</head>
<body onLoad="disp()">
<form action="#" name="form1" align="center">
<input type="text" name="field1" size="50">
</form>

<center><img src="./images/header.jpg"/></center>
<h1 align="center"><a href="all" rel="external nofollow" rel="external nofollow" >进入学員管理主页</a></h1>
<h1 align="center"><a href="teaall" rel="external nofollow" rel="external nofollow" >进入先生管理主页</a></h1>

		<form method="POST" action="teaall" onSubmit="return check()">
		<p>お名前：<input type="text" name="field1" size="25"></p>
		<p><input type="submit" value="送信"></p>
			</form>



 		  <form align="center" action="all" method="post">
			<input type="text" placeholder="......"  />
			<input type="submit" value="进入学員管理主页"  />
		</form>
		<form id="allForm" align="center" action="teaall" method="post" name="id" onclick="teaallCheckForm()">
			<input  id="inputid" type="text" placeholder="......"  />
			<input type="submit" value="进入先生管理主页"   />
		</form>

</body>
</html>