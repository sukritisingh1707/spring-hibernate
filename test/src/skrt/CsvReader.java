package skrt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class CsvReader {
	public static void main(String[] args){
		
		CsvReader cs=new CsvReader();
		cs.read();
}
	


public void read(){
	File f=new File("C:\\Users\\Subhash Chaudhary\\Downloads\\Berkeley.csv");
	String line = "";  String splitBy = ",";  
	try   
	{  BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Subhash Chaudhary\\Downloads\\Berkeley.csv"));  
	while ((line = br.readLine()) != null)     
	{  String[] employee = line.split(splitBy);

	System.out.println("Employee [First Name=" + employee[0] + ", Last Name=" + employee[1] + ", Designation=" + employee[2] + ", Contact=" + employee[3] );//+ ", Salary= " + employee[4] ) ;  
	Employee em =new Employee();
	em.setFirstname(employee[0]);
	em.setLastname(employee[1]);
	em.setDesignation(employee[2]);
	em.setContact(employee[3]);
	Dao1 ddf= new Dao1();
	ddf.dTest(em);
}
	} catch(Exception e)
	{
		System.err.println("Problem : "+e);
	}}}