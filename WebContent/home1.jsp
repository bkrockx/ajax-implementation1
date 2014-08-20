<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script language="javascript">


function deleteData(id){
	var xmlhttp;
	if(window.XMLHttpRequest){
		xmlhttp = new XMLHttpRequest();
	}
	else{
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp.open("GET","http://localhost:8080/First/deleteData1?id="+id+"&format=fragment",true);
	xmlhttp.send(null);
	
	xmlhttp.onreadystatechange = function()
	{
		if(xmlhttp.readyState==4 && xmlhttp.status==200){
			document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
		}
	}
	
	
}

function editData(id){
	
	var xmlhttp1;
	
	var newName = id+"name";
	var dep = id+"department";
	var pass = id+"password";
	
	var name = document.getElementById(newName).value;
	var department = document.getElementById(dep).value;
	var password = document.getElementById(pass).value;
	
	//var url = "http://localhost:8080/First/UpdateData1?id="+id+"&name="+name+"&department="+department+"&password="+password;
	//console.log(url);
	
	if(window.XMLHttpRequest){
		xmlhttp1 = new XMLHttpRequest();
	}
	else{
		xmlhttp1 = new ActiveXobject("Microsoft.XMLHTTP");
	}
	
    xmlhttp1.open("GET","http://localhost:8080/First/UpdateData1?id="+id+"&name="+name+"&department="+department+"&password="+password,true);
	xmlhttp1.send(null);

}

function showData(){
	var xmlhttp2;
	if(window.XMLHttpRequest){
		xmlhttp2 = new XMLHttpRequest();
	}
	else{
		xmlhttp2 = new ActiveXObject("Microsoft.XMLHTTP");
	}
	
	xmlhttp2.open("GET","http://localhost:8080/First/Display4",true);
	xmlhttp2.send(null);
	
	xmlhttp2.onreadystatechange = function()
	{
		if(xmlhttp2.readyState==4 && xmlhttp2.status==200){
			document.getElementById("myDiv").innerHTML = xmlhttp2.responseText;
		}
	}
	
	
}

</script>

</head>
<body>
	<div id="myDiv">
		<form>
		<table border='1' width='300' cellpadding='1' cellspacing='0'>
			<tr>
				<td colspan=7 align="center"></td>
			</tr>
			<tr>
				<td>Id</td>
				<td>Name</td>
				<td>Department</td>
				<td>Password</td>
				<td>Edit</td>
				<td>Delete</td>
				<td>Show</td>
			</tr>

			<%
				List Li = new ArrayList();
				Iterator lr;

				if (request.getAttribute("userList") != null
						&& request.getAttribute("userList") != "") {
					List userList = (ArrayList) request.getAttribute("userList");
					Iterator itr = userList.iterator();

					while (itr.hasNext()) {
						Li = (ArrayList) itr.next();
						lr = Li.iterator();
						Integer id = (Integer) lr.next();
						String name = (String) lr.next();
						String department = (String) lr.next();
						String password = (String) lr.next();
			%> 

			<tr>
				<td><%=id%></td>
				<td><input type="text" name="name" id="<%=id%>name" value="<%=name%>"></td>
				<td><input type="text" name="department" id="<%=id%>department" value="<%=department%>"></td>
				<td><input type="text" name="password" id="<%=id%>password" value="<%=password%>"></td>

				<td><input type="button" name="edit" value="edit" onclick="editData(<%=id%>);"></td>
				<td><input type="button" name="delete" value="Delete" onclick="deleteData(<%=id%>);"></td>
				<td><input type="button" name="show" value="show" onclick="showData();"></td>
			</tr>

			<%
				}
				}
			%>
		</table>
		</form>
	</div>
</body>
</html>