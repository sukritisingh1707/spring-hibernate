package com.dao;

import java.util.List;

import com.bean.Emp;

public interface EmpDao {
	public int save(Emp p);
	public int Update(Emp p);
	public int delete(Emp p);
	public Emp getEmpById(int id);
	public List<Emp> getEmployees();
}
