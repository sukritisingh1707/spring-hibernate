package com.dao;
import java.sql.PreparedStatement;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.csv.Employee;
import com.csv.UploadFile;


@Repository
public class FileUploadDaoImpl implements FileUploadDao {
@Autowired
private SessionFactory sessionFactory;

public FileUploadDaoImpl() {
}

public FileUploadDaoImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
	} /*
		 * @Override
		 * 
		 * @Transactional public void save(UploadFile uploadFile) { Session session =
		 * sessionFactory.getCurrentSession(); session.beginTransaction();
		 * session.save(uploadFile); session.getTransaction().commit(); }
		 */

@Override
public void savee(Employee Employee) {
	// TODO Auto-generated method stub
	   Session session = sessionFactory.getCurrentSession();
	    session.beginTransaction();
	    session.save(Employee);
	 
	    session.getTransaction().commit();
    
}


}
  
 