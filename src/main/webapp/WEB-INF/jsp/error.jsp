<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript">
// Using jQuery.

$(function() {
$('form').each(function() {
    $('input').keypress(function(e) {
        // Enter pressed?
        if(e.which == 10 || e.which == 13) {
            this.form.submit();
        }
    });

    $('input[type=submit]').hide();
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
::placeholder{
color:black;
}
</style>


<title>Bloggers Exchange</title>
</head>
<body>

<script>
function add() {
  var x = document.getElementById("addform");
  var y = document.getElementById("showtable");
  var z = document.getElementById("failure");
  x.style.display = "block";
  y.style.display = "none";
  z.style.display = "none";
}
function show() {
  var x = document.getElementById("addform");
  var y = document.getElementById("showtable");
  var z = document.getElementById("failure");
  x.style.display = "none";
  y.style.display = "block";
  z.style.display = "none";
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
  	
  	<div id="failure">
  	<a style="color:red">User not found.</a>
  	</div>
  	
  	
  	<div id="addform" style="display:none;margin-top:60px">
		<form action="bloggerexchange/add" method="post" name="user">
		<input type="text" name="loginName" id="inputusername" placeholder="Search User..." style="background-color:transparent;border:none;border-bottom:1px solid black;outline:none;font-size:35px"><br/><br/>
		<input type="submit" value="submit" style="visibility: hidden;"/>
	</form>
	</div>
	
	<div id="showtable" style="display:none">
	</div>
	</div>
</body>
</html>