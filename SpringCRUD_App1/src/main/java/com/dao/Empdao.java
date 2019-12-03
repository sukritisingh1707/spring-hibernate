
package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bean.Emp;

public class Empdao  {
	
	JdbcTemplate template; 
	public void setTemplate(JdbcTemplate template) { 
		this.template=template; 
	} 
	
	public int save(Emp p) { 
		String sql="insert into Emp9(name,gender,dob,salary,designation) values('"+p.getName
				()+"','"+p.getGender()+"','"+p.getDob()+"',"+p.getSalary()+",'"+p.
				getDesignation()+"')";
		return template.update(sql); }
	
	public int Update(Emp p) {
		String sql="update Emp9 set name='"+p.getName()+"',gender='"+p.getGender()+"',dob='"
				+p.getDob()+"',salary="+p.getSalary()+",designation='"+p.getDesignation()
				+"' where id="+p.getId()+"";
		return template.update(sql);

	} 
	
	public int id(int id) {
		String sql="delete from Emp9 where id="+id+"";
		return template.update(sql); 
		}
	
	public Emp getEmpById(int id) {
		String sql="select * from Emp9 where id =?";
		return template.queryForObject(sql, new Object[] {id} , new BeanPropertyRowMapper<Emp>(Emp.class));

	}


	public Emp getEmployee(int id){ String sql="Select * from emp9 where id=?";
	return template.queryForObject(sql, new Object[] {id} ,
			new BeanPropertyRowMapper<Emp>(Emp.class)); }


	public List<Emp>getEmployees(){ return template.query("select*from Emp9",new
			org.springframework.jdbc.core.RowMapper<Emp>() {
		public Emp mapRow(ResultSet rs, int row) 
				throws SQLException{
			Emp e= new Emp(row, null, null, null, row, null);
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2)); 
			e.setGender(rs.getString(3));
			e.setDob(rs.getString(4));
			e.setSalary(rs.getFloat(5));
			e.setDesignation(rs.getString(6));
			return e;
		} }); }
	

}

