
package com.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Emp;

@Repository
@Transactional
public class EmpDaoImpl implements EmpDao {

	@Autowired
	SessionFactory sessionFactory;

	public int save(Emp p) {
		try {
			sessionFactory.getCurrentSession().save(p);
			return 1;
		} catch (Exception exp) {
			return 0;
		}
	}

	public int Update(Emp p) {
		try {
			sessionFactory.getCurrentSession().update(p);
			return 1;
		} catch (Exception exp) {
			return 0;
		}
	}

	public int delete(Emp p) {
		try {
			sessionFactory.getCurrentSession().delete(p);
			return 1;
		} catch (Exception exp) {
			return 0;
		}
	}

	public Emp getEmpById(int id) {
		try {
			Session session = sessionFactory.openSession();
			Emp emp = session.get(Emp.class, id);

			return emp;
		} catch (Exception exp) {
			return null;
		}
	}

	public List<Emp> getEmployees() {
		try {

			Session session = sessionFactory.openSession();
			List<Emp> userList = new ArrayList<Emp>();
			Query query = session.createQuery("FROM Employee");
			userList = query.list();
			return userList;
		} catch (Exception e) {

			return null;

		}
	}

}
