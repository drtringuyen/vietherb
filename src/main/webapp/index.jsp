<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
</head>
<body>
    <h2>Jersey RESTful Web Application!</h2>
    <p><a href="webapi/herbs">Herbs Here!</a>
    <script>
    $.getJSON("http://localhost:14708/vietherb/webapi/herbs",function(data){
    	console.log("it works!")
    });
    </script>
</body>
</html>
