package com.Ken.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.Ken.mapper.KenMapper;
import com.student.bean.Ken;

public class KenDao {

	/**
	 * @Fields jdbcTemplate
	 */
	private JdbcTemplate jdbcTemplate;

	/**
	 * spring提供的类
	 *
	 * @param jdbcTemplate
	 *            返回值类型： void
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 查询所有学生
	 *
	 * @return 返回值类型： List<Ken>
	 */
	public List<Ken> queryAll() {
		String sql = "select id,kenname from ken";

		// 将查询结果映射到Ken类中，添加到list中，并返回
		ArrayList<Ken> KenList = (ArrayList) jdbcTemplate.query(sql, new KenMapper());

		// 将查询结果映射到Ken类中，添加到list中，并返回
		return jdbcTemplate.query(sql, new KenMapper());
	}

}
