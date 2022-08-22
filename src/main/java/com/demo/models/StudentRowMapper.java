package com.demo.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class StudentRowMapper implements RowMapper<Students>
{
	@Override
	public Students mapRow(ResultSet rs, int rowNum) throws SQLException 
	{
		return new Students(
			rs.getInt("id"),
			rs.getString("name"),
			rs.getInt("age"),
			rs.getString("phone")
		);
	}

}
