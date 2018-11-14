package com.student.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.student.bean.Stutea;
import com.student.mapper.StuteaMapper;

public class StuteaDao {
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
	public List<Stutea> queryAll() {
		String sql="select student.name," +
				"		student.birthday," +
				"		student.age," +
				"		student.classid," +
				"		teacher.id as teaid ," +
				"		teacher.course from student" +
				"	left join teacher on student.id=teacher.id";

		ArrayList<Stutea> stuteaList = new ArrayList<Stutea>();
		stuteaList = (ArrayList<Stutea>) jdbcTemplate.query(sql, new StuteaMapper());
		return stuteaList;
	}
	//Dbaccess Data  Out Message to  Bean;
	//web -> (controller->service) ->dao
	//many Bean Data input Into  Model Map; return to web;
}
