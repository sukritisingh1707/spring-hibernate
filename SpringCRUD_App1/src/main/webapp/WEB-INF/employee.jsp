<%@ page isELIgnored="false" %>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Employees List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Id</th><th>Name</th><th>Salary</th><th>Designation</th><th>Edit</th><th>Delete</th></tr>    
   <tr>  
   <td>${list.id}</td>  
   <td>${list.name}</td>
   <td>${list.gender}</td>
   <td>${list.dob} </td>  
   <td>${list.salary}</td>  
   <td>${list.designation}</td>  
   <td><a href="editemp/${list.id}">Edit</a></td>  
   <td><a href="deleteemp/${list.id}">Delete</a></td> 
    
   </tr>  
   </table>  
   <br/>  
   <a href="empform">Add New Employee</a>  
   <a href="search">Search Employee</a>