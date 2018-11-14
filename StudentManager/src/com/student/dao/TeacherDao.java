package com.student.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
//import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import com.student.bean.Teacher;
import com.student.mapper.TeacherMapper;


public class TeacherDao {

	/**
	 * @Fields jdbcTemplate
	 */
	private JdbcTemplate jdbcTemplate;

	/**
	 * spring提供的?
	 *
	 * @param jdbcTemplate
	 *            返回??型： void
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * データベースから全部ユーザ検索して結果をindex,jspに返却
	 *
	 * @return 返回??型： List<Student>
	 */
	public List<Teacher> queryteaAll() {
		String sql = "select id,teachername,course from teacher";
		// 将???果映射到Student?中，添加到list中，并返回
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = (ArrayList<Teacher>) jdbcTemplate.query(sql, new TeacherMapper());
		return teacherList;
	}

	public List<Teacher> queryteaByName(String teachername) {
		String sql = "select id,teachername,course from teacher where teachername like '%" + teachername + "%'";
		List<Teacher> teacherList = new ArrayList<Teacher>();
		teacherList = (ArrayList<Teacher>) jdbcTemplate.query(sql, new TeacherMapper());
		return teacherList;
	}

	public boolean addtea(Teacher teacher) {
		String sql = "insert into teacher(id,teachername,course) values(0,?,?)";


		return jdbcTemplate.update(sql,
				new Object[] { teacher.getTeachername(), teacher.getCourse() },
				new int[] { Types.VARCHAR, Types.VARCHAR }) == 1;
	}

	public boolean deleteTea(Integer id) {

		String sql = "delete from teacher where id = ?";
		return jdbcTemplate.update(sql, id) == 1;
	}

	public boolean updateTeachert(Teacher teacher) {

		String sql = "update teacher set teachername=?,course=?  where id =?";
		Object terObj[] = new Object[] { teacher.getTeachername(),teacher.getCourse(),teacher.getId() };

		return jdbcTemplate.update(sql, terObj) == 1;
	}
	/**
	 * 通?姓名??
	 *
	 * @param name
	 * @return 返回??型： List<Student>
	 */
//	public List<Student> queryByName(String name) {
//		String sql = "select id,name,birthday,age,score,classid from student where name like '%" + name + "%'";
//		List<Student> studentList = new ArrayList<Student>();
//		studentList = (ArrayList<Student>) jdbcTemplate.query(sql, new StudentMapper());
//		return studentList;
//
//
//	}
//
//	/**
//	 * 添加学生
//	 *
//	 * @param student
//	 * @return 返回??型： boolean
//	 */
//	public boolean Addstudent(Student student) {
//		String sql = "insert into student(id,name,birthday,age,score,classid)values(0,?,?,?,?,?)";
//		boolean s;
//		// jdbcTemplate.update(sql,new Object,new int);
//		s = jdbcTemplate.update(sql,
//				new Object[] { student.getName(), student.getBirthday(), student.getAge(), student.getScore(),
//						student.getClassid() },
//				new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.DOUBLE, Types.INTEGER }) == 1;
//		return s;
//	}
//
//	/**
//	 * ?除学生
//	 *
//	 * @param id
//	 * @return 返回??型： boolean
//	 */
//	public boolean deleteStu(Integer id) {
//
//		String sql = "delete from student where id = ?";
//		return jdbcTemplate.update(sql, id) == 1;
//	}
//
//	//
//	/**
//	 * 更新学生信息
//	 *
//	 * @param student
//	 * @return 返回??型： boolean
//	 */
//	public boolean updateStudent(Student student) {
//
//		// + "telephone,postal_code) values(0,?,?,?,?,?,?)";
//		String sql = "update student set name=?,birthday=?,age=?,score =? ,classid =?  where id =?";
//		Object stuObj[] = new Object[] { student.getName(), student.getBirthday(), student.getAge(), student.getScore(),
//				student.getClassid(), student.getId() };
//
//		return jdbcTemplate.update(sql, stuObj) == 1;
//	}
	//
	// /**
	// * 通?姓名??
	// *
	// * @param name
	// * @return 返回??型： List<Student>
	// */
	// public List<Student> queryMaxAge() {
	// String sql = "select max(age) from student";
	//
	// return jdbcTemplate.query(sql, new StudentMaxMapper());
	// }
	//
	// /**
	// *
	// *
	// * @param name
	// * @return 返回??型： List<Student>
	// */
	// public List<Student> queryMinAge() {
	// String sql = "select min(age) from student";
	// return jdbcTemplate.query(sql, new StudentMinMapper());
	// }
}
