<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
  
<h2>Search Employee</h2>
<p>Enter your id:</p>
<form class="example" action="/SpringCRUD_App1/search" method="post">
  <input type="text" name="id" /><br>
  <input type="submit" value="Search"/>
</form>

</body>

</html>