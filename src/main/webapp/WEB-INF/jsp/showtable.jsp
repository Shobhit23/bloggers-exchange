<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#myInput").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#myTable tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});
</script>

<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
  background-image: url("/images/imgback.jpg");
}

.topnav {
  overflow: hidden;
}

.topnav a {
  float: centre;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 30px;
  height:60px;
}

.topnav a:hover {
  cursor: pointer;
}

#main{
  position: fixed;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  height:500px;
  width:600px;
  background-color:darkcyan;
  box-shadow: 10px 10px 5px grey;
}

#scrollable{
height:225px;
overflow-y:scroll;
}
::placeholder{
color:black;
}

table,th,td{
border:1px solid black;
}
table {
  border-collapse: collapse;
}

</style>


<title>Bloggers Exchange</title>
</head>
<body>

<script>
function add() {
  var x = document.getElementById("addform");
  var y = document.getElementById("showtable");
  x.style.display = "block";
  y.style.display = "none";
}
function show() {
  var x = document.getElementById("addform");
  var y = document.getElementById("showtable");
  x.style.display = "none";
  y.style.display = "block";
}
</script>

	<div align='center' id="main">
	
	<h1 style="font-size:50px">BloggersExchange</h1><br />
	<!-- <form action="CustomerLogin.jsp"> -->
	
	
	<div class="topnav">
  	<a onclick="add()" style="border-right:1px solid black">Add</a>
  	<a href="showtable" onclick="show()">View</a>
  	</div>
  	
  	<br>
  	<br>
  	
  	<div id="addform" style="display:none;margin-top:60px">
		<form action="add" method="post" name="user">
		<input type="text" name="loginName" placeholder="Search User..." style="background-color:transparent;border:none;border-bottom:1px solid black;outline:none;font-size:35px"><br/><br/>
		<input type="submit" value="submit" style="visibility: hidden;"/>
	</form>
	</div>
	
	<div id="showtable" style="display:block">
	<input id="myInput" type="text" placeholder="Find.." style="background-color:transparent;border:none;border-bottom:1px solid black;outline:none;font-size:35px">
	<br>
	<br>
	
	
	
	<div id="scrollable">
	<table border="1">
		
		<th>Full Name</th>
		<th>Username</th>
		<th>Followers</th>
		<th>Following</th>
		<th>Category</th>
		<th>Total Posts</th>
		<th>Unique Id</th>
		
		
		<c:forEach var="user" items="${userList}">
		<tbody id="myTable">
			<tr>
				
				<td>${user.fullname}</td>
				<td>${user.username}</td>
				<td>${user.followers}</td>
				<td>${user.following}</td>
				<td>${user.category}</td>
				<td>${user.postcount}</td>
				<td>${user.id}</td>
			</tr>
		</tbody>
		</c:forEach>
		
		
	</table>
	</div>
	
	
	</div>
	</div>
</body>
</html>