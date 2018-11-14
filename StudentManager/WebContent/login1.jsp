<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
<script src="../js/jquery-1.11.3.js"></script>
<title>ユーザ登録画面</title>
<script type="text/javascript">
	var msg = '就問?看著迷糊不・・・・・・・・・・・・・・・'; // メッセージ内容
	var speed = 300; // スクロールのスピード（1に近いほど速く）
	var move = 2; // スクロールのなめらかさ（1に近いほどなめらかに）
	function disp() {

		msg = msg.substring(move, msg.length) + msg.substring(0, move);

		// テキストフィールドにデータを渡す処理
		document.form1.field1.value = msg;

		setTimeout("disp()", speed);

	}

	function dengluForm() {
		var form = document.getElementById('xxx');
		var input_ad = document.getElementById("inputid").value;
		var input_ps = document.getElementById("inputpsd").value;
		if (input_ad != "admin" || input_ps != "admin") {
			alert("?号或密???");
			return false;
		}
		form.submit();
		return true;
	}


</script>
</head>
<body onLoad="disp()">
	<form action="#" name="form1" align="center">
		<input type="text" name="field1" size="50">
	</form>

	<img alt="" src="./images/header.jpg">
	<table id="table_id" align="center">
		<thead>
			<form id=xxx action="all" align="center">
				<tr>
				<td>ユーザ名 :</td>
				<td><input id="inputid" type="text" name="username" size="20">
				</tr><br><br>
				</thead>
				<tr>
				<td>パスワード:</td>
				<td> <input id="inputpsd" type="password" name="password" size="20"></td>
				</tr><br><br>
				<td> <input type="button" value="ログイン" onclick="dengluForm()"></td><br><br>


			</form>

	</table>
</body>
</html>
