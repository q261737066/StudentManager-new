<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>

<title>Teacher管理</title>
<script type="text/javascript" >
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>学员管理</title>
<link rel="stylesheet" type="text/css" href="./css/all.css" />
<style type="text/css">
</style>
 <link rel="stylesheet" type="text/css" href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css">
  <!-- jQuery -->
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.2.min.js"></script>
  <!-- DataTables -->
  <script type="text/javascript" charset="utf8" src="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min.js"></script>
  <script>
$(document).ready(function(){
  $('#table_id').dataTable();
});
</script>
<script type="text/javascript">
	function addCheckForm() {
		var form = document.getElementById('addForm');
		var input_teachername = document.getElementById('addteachername').value;
		var input_course = document.getElementById('addcourse').value;

		if (input_teachername == "" || input_teachername == null) {
			alert("请输入先生姓名！！！");
			return false;
		}

		if (input_course == "" || input_course == null) {
			alert("请输入先生科目！！！");
			return false;
		}
		form.submit();
		return true;
	}

	function delCheckForm() {
		var form = document.getElementById('delForm');
		var flag = 0;
		var input_id = document.getElementById("delid").value;
		if (input_id == "" || input_id == null) {
			alert("请输入削除先生id！！！");
			return false;
		}

		if (input_id.match(/[^0-9]+/)) {
			flag = 1;
		}

		if (flag) {
			window.alert('数字以外が入力できません');
			return false; // 送信を中止
		}

		form.submit();
		return true;
	}

	function editCheckForm() {
		var form = document.getElementById('editForm');

		var input_id = document.getElementById('editid');
		var input_teachername = document.getElementById('editteachername');
		var input_course = do
</script>
</head>
<body>

	<img alt="" src="./images/header.jpg">
	</div>
	<h1 align="center">Teacher情報管理</h1>
	<form align="center" action="all" method="post">
			<input type="submit" value="進入學生管理主页"  />
	<div id="all_comm" class="teaall">
		<h2 align="center">TEACHER信息一覧</h2>
		<table id="table_id" align="center" border="1" >
			<thead>
				<tr>					<td>Id</td>
					<td>姓名</td>
					<td>課程</td>
				</tr>
			</thead>
			<c:forEach items="${teachers}" var="teacher">
				<tr>
					<td id="${teacher.id }">${teacher.id}</td>
					<td id="${teacher.id }">${teacher.teachername}</td>
					<td id="${teacher.id}">${teacher.course}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
		<div id="add_comm" class="teaall" align="center">
		<h2>先生の検索</h2>
		<form action="queryteaByName" method="post">
			<input type="text" placeholder="氏名" name="teachername"> <input
				type="submit" value="先生の検索">
		</form>
	</div>
	<div id="add_comm" class="addtea" align="center">
		<h2 id="edit_title">先生の追加</h2>
		<form id="addForm" action="addtea" method="post" class="checkform">
			<input id="addname" type="text" placeholder="氏名" name="teachername" />
			<input id="addcourse" type="text" placeholder="course" name="course" />
			<input type="submit" value="添の加" onclick="addCheckForm()"/>
		</form>
	</div>
	<div id="edit_comm" class="deleteteaById" align="center">
		<h2>刪除の先生</h2>
		<form id="delForm" action="deleteteaById" method="post">
			<input id="delid" type="text" placeholder="要刪除的id" name="id" /> <input
				type="submit" value="刪除の先生" onclick="delCheckForm()" />
		</form>
	</div>
	<div id="edit_comm" class="teaupdate" align="center">
		<h2 id="edit_title">先生の編集</h2>
		<form id="editForm" action="teaupdate" method="post">
			<input id="editid" type="text" placeholder="要修改的id" id="edit_id"
				name="id" /><br>
				 <input id="editname"	type="text" placeholder="氏名" name="teachername" />
				 <input id="editbirthday" type="text" placeholder="course" name="course" />
			     <input	type="submit" value="修正の確認"  />
		</form>
	</div>
</body>
</html>