<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ClearSky</title>
  <meta name="viewport" content="width=device-width" intial-scale=1>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
  
 <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="jumbotron" style="margin-bottom:0px; color:white; background-color: #4aa1f3;">
        <h2 class="text-center" style="font-size: 50px; font-weight: 600;">Clear Sky WeatherApp</h2>     
    </div>

    <div class="container">
        <div class="row" style="margin-bottom: 20px;">
            <h3 class="text-center text-primary">Enter City name</h3>
            <span id="error"></span>
        </div>

        <div class="row form-group form-inline" id="rowDiv">
            <input type="text" name="city" id="city" class="form-control" placeholder="City Name">
            <button id="submitWeather" class="btn btn-primary">Search City</button>
        </div>        
    </div>
    
    <div id="show" class="floating-box"></div>
  	<div id="addfav" class="floating-box addtofav"></div>
	 <div id="myDiv" class="floating-box addtofav"></div>    


   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

   <script src="weather.js"></script>
</body>
</html>