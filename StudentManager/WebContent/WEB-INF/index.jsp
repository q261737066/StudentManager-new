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

<title>STUDENT管理</title>
<script type="text/javascript" >
	function addCheckForm() {
		var form = document.getElementById('addForm');
	    var input_name= document.getElementById('addname').value;
	    var input_birthday= document.getElementById('addbirthday').value;
	    var input_age= document.getElementById('addage').value;
	    var input_score= document.getElementById('addscore').value;
	    var input_classid= document.getElementById('addclassid').value;

	    if (input_name == "" || input_name == null) {
	    	alert("please input your names！！！");
	    	return false;
	    }

	    if (input_birthday == "" || input_birthday == null) {
	    	alert("olease input your birthday！！！");
	    	return false;
	    }

	    if (input_age == "" || input_age == null) {
	    	alert("请输入学員年龄！！！");
	    	return false;
	    }

	    if (input_score == "" || input_score == null) {
	    	alert("请输入学員成绩！！！");
	    	return false;
	    }

	    if (input_classid == "" || input_classid == null) {
	    	alert("classidを入力してください！！！");
	    	return false;
	    }

		form.submit();
		return true;
	}

	function delCheckForm() {
		var form = document.getElementById('delForm');

	    var input_id= document.getElementById("delid").value;
	    if (input_id == "" || input_id == null) {
	    	alert("??入削除学員id！！！");
	    	return false;
	    }

		form.submit();
		return true;
	}

	function editCheckForm() {
		var form = document.getElementById('editForm');

	    var input_id= document.getElementById('editid');
	    var input_name= document.getElementById('editname');
	    var input_birthday= document.getElementById('editbirthday');
	    var input_age= document.getElementById('editage');
	    var input_score= document.getElementById('editscore');

	    if (input_id == "" || input_id == null) {
	    	alert("??入学員id！！！");
	    	return false;
	    }

	    if (input_name == "" || input_name == null) {
	    	alert("??入学員姓名！！！");
	    	return false;
	    }

	    if (input_birthday == "" || input_birthday == null) {
	    	alert("??入学員出生年月！！！");
	    	return false;
	    }

	    if (input_age == "" || input_age == null) {
	    	alert("??入学員年?！！！");
	    	return false;
	    }

	    if (input_score == "" || input_score == null) {
	    	alert("??入学員成?！！！");
	    	return false;
	    }

		form.submit();
		return true;
	}

	$(function() {
		   var page = 0;
		   function draw() {
		     $('#page').html(page + 1);
		     $('tr').hide();
		     $('tr:first,tr:gt(' + page * 10 + '):lt(10)').show();
		   }
		   $('#prev').click(function() {
		     if (page > 0) {
		       page--;
		       draw();
		     }
		   });
		   $('#next').click(function() {
		     if (page < ($('tr').size() - 1) / 10 - 1) {
		       page++;
		       draw();
		     }
		   });
		   draw();
		 });
</script>
<style>
 td, th {
   border: 1px solid black;
   padding: 2px;
 }
 #prev, #next {
   color: red;
   cursor: pointer;
 }
 </style>
</head>
<body>

	<img alt="" src="./images/header.jpg">
	<form align="center" action="teaall" method="post">
			<input type="submit" value="進入先生管理主页"  />
		</form>
	<h1 align="center">学生情報管理</h1>
	<div id="all_comm" class="all">
		<h2 align="center">STUENT信息一覧</h2>
		<p align="center"><span id="prev" align="center">＜</span>　<span id="page"></span>　<span id="next"> ＞</span></p>
		<table  border="1" id="table_id" align="center">
			<thead>
				<tr align="center">
					<td>ID</td>
					<td>姓名</td>
					<td>出生年月</td>
					<td>年?</td>
					<td>成績</td>
					<td>授業ID</td>
				</tr>
			</thead>
			<c:forEach items="${students}" var="student">
				<tr align="center">
					<td id="id${student.id }">${student.id}</td>
					<td id="name${student.id }">${student.name}</td>
					<td id="birthday${student.id}">${student.birthday}</td>
					<td id="age${student.id }">${student.age}</td>
					<td id="score${student.id}">${student.score}</td>
					<td id="classid${student.id}">${student.classid}</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>




	<div id="add_comm" class="all" align="center">
		<h2>学生の検索</h2>
		<form action="queryByName" method="post">
			<input type="text" placeholder="氏名" name="name"> <input
				type="submit" value="学生の検索">
		</form>
	</div>


	<div id="add_comm" class="all" align="center">
		<h2 id="edit_title">学生の追加</h2>
		<form id="addForm" action="add" method="post" class="checkform">
			<input id="addname" type="text" placeholder="氏名" name="name" />
		    <input id="addbirthday" type="text" placeholder="生年月日" name="birthday" />
			<input onblur="checkFormat(this.value) id="addage" type="text" placeholder="年齢" name="age" class="number" /><span
				class="alertarea"></span>
			</p>
			<input id="addscore" type="text" placeholder="成績" name="score" />
			<input id="addclassid" type="text" placeholder="コースコード" name="classid" />
			<!-- <input type="button" value="添加" onClick="addCheckForm(this.form.txt)" /> -->
			<input type="submit" value="添の加" />
		</form>
	</div>


	<div id="edit_comm" class="all" align="center">
		<h2>刪除學員</h2>
		<form id="delForm" action="deleteById" method="post">
			<input id="delid" type="text" placeholder="刪除學員的id" name="id" /> <input
				type="submit" value="刪除學員" onclick="delCheckForm()" />
		</form>
	</div>


	<div id="edit_comm" class="all" align="center">
		<h2 id="edit_title">学生編集</h2>
		<form id="editForm" action="update" method="post">
			<input id="editid" type="text" placeholder="要修改的id" id="edit_id"
				name="id" /><br>
				 <input id="editname"	type="text" placeholder="氏名" name="name" />
				 <input id="editbirthday" type="text" placeholder="生年月日" name="birthday" />
			     <input id="editage" type="text" placeholder="年齢" name="age" />
			     <input id="editscore" type="text" placeholder="成績" name="score" />
			     <input id="editscore" type="text" placeholder="コースid" name="classid" />
			     <input	type="submit" value="修正の確認"  />
		</form>
	</div>

</body>
</html>