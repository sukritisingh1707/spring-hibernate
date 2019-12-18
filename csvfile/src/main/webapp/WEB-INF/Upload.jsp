<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
h1{
color:blue;
}
tr{
padding:10px;
}
#button {
	text-align: center;
	background-color: grey;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
}
#file{
	text-align: center;
	background-color: white;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	   
}


::-ms-browse {
  background: grey;
  color: white;
  padding: 1em;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UP LOAD YOUR FILE HERE</title>
</head>
<body>
    <div align="center">
        <h1>UP LOAD YOUR FILE HERE</h1>
        <form method="post" action="doUpload" enctype="multipart/form-data">
            <table border="0">
                <tr>
                    <td>Pick file 1:</td>
                    <td><input type="file" name="fileUpload" size="50" id="file"/></td><br><br>
                </tr><br><br>
                <tr>
                    <td>Pick file 2:</td>
                    <td><input type="file" name="fileUpload" size="50" id="file2"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Upload" id ="button"/></td>
                </tr>
            </table>
        </form>
    </div>

</body>
</html>