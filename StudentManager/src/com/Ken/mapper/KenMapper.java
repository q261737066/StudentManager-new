package com.Ken.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.student.bean.Ken;

/**
 * KenMapper数据库映射
 * @ClassName KenMapper
 */

public class KenMapper implements RowMapper<Ken> {

	public Ken mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ken ken = new Ken();

		ken.setId(rs.getInt(1));
		ken.setKenname(rs.getString(2));


		return ken;
	}

	/**
	   * 获取日期
	   * @return 返回日期字符串格式yyyy-MM-dd
	   * @throws ParseException
	   */
	private String getStringDate(String birthday) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateString = new Date();
		String strRtnDate = "";
		try {
			dateString = formatter.parse(birthday);
			strRtnDate = new SimpleDateFormat("yyyy-MM-dd").format(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return strRtnDate;
	}

}