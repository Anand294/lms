<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.css">
<script src="https://code.jquery.com/jquery-3.6.4.min.js" type="text/javascript" 
        integrity="sha256-oP6HI9z1XaZNBrJURtCoUT5SUnxFr8s3BzRl+cbzUq8=" crossorigin="anonymous">
</script>

<script src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.js"></script>
 <script src="https://unpkg.com/react@18/umd/react.development.js" crossorigin></script>
  <script src="https://unpkg.com/react-dom@18/umd/react-dom.development.js" crossorigin></script>
  <script defer="defer" src="./js/main.b9278ea8.js"></script>
  <link href="./css/main.f855e6bc.css" rel="stylesheet">

<title>Insert title here</title>
</head>
<body>
    <input type="button" onclick="getData()" value="MIS Application">
<div id="divId"></div>
<div id="divId1"></div>

<div id="divId3"></div>

<div id="divId2"></div>
<div id="divId4"> </div>



</body>
<script>
var data={};
    function getData(){
    
$.ajax({
	 url : "./home",
		 type: "GET",
		 data : data,
		 success: function(result){	
            var resturnStr="";
			 
             result.forEach(element => {
resturnStr+="<tr><td>"+element.id+"</td><td>"+element.name+"</td><td>"+element.address+"</td></tr>";
                 
             });
				
			$("#divId").html("<table>"+resturnStr+"</table>"); 		
		  
		  }
});
    }
   

</script>
</html>
