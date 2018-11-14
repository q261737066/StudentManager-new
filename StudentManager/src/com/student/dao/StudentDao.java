package com.student.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
//import org.apache.log4j.Logger;
import org.springframework.jdbc.core.JdbcTemplate;
import com.student.bean.Student;

//import com.student.mapper.StudentMinMapper;
import com.student.mapper.StudentMapper;


public class StudentDao {

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
	public List<Student> queryAll() {
		String sql = "select * from student";
		// 将???果映射到Student?中，添加到list中，并返回
		List<Student> studentList = new ArrayList<Student>();
		studentList = (ArrayList<Student>) jdbcTemplate.query(sql, new StudentMapper());
		System.out.println("学生の小年齢は:"+Min1Age(studentList));
		return studentList;
	}


	/**
	 * 通?姓名??
	 *
	 * @param name
	 * @return 返回??型： List<Student>
	 */
	public List<Student> queryByName(String name) {
		String sql = "select * from student where name like '%" + name + "%'";
		List<Student> studentList = new ArrayList<Student>();
		studentList = (ArrayList<Student>) jdbcTemplate.query(sql, new StudentMapper());
		return studentList;

	}

	/**
	 * 添加学生
	 *
	 * @param student
	 * @return 返回??型： boolean
	 */
	public boolean addStu(Student student) {
		String sql = "insert into student(id,name,birthday,age,score,classid) values(0,?,?,?,?,?)";
		return jdbcTemplate.update(sql,
				new Object[] { student.getName(), student.getBirthday(), student.getAge(), student.getScore(),student.getClassid() },
				new int[] { Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.DOUBLE,Types.VARCHAR }) == 1;
	}

	/**
	 * ?除学生
	 *
	 * @param id
	 * @return 返回??型： boolean
	 */
	public boolean deleteStu(Integer id) {

		String sql = "delete from student where id = ?";
		return jdbcTemplate.update(sql, id) == 1;
	}

	//
	/**
	 * 更新学生信息
	 *
	 * @param student
	 * @return 返回??型： boolean
	 */
	public boolean updateStudent(Student student) {


		String sql = "update student set name=?,birthday=?,age=?,score =? ,classid =?  where id =?";
		Object stuObj[] = new Object[] { student.getName(), student.getBirthday(), student.getAge(), student.getScore(),
				student.getClassid(), student.getId() };

		return jdbcTemplate.update(sql, stuObj) == 1;
	}
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

	private static int Min1Age(List<Student> StudentList) {
		// 最小年齢の初期化
		int minAge = 0;
		int num = 0;
		// Loop 最小値取得
		for (Student student : StudentList) {
			if (num == 0) {
				minAge = student.getAge();
				num++;
			} else {
				if (student.getAge() < minAge) {
					minAge = student.getAge();
				}
			}
		}
		// 算出した年齢を返す
		return minAge;
	}
}
