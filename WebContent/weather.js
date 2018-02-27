var city,weather,temp,min_temp,max_temp,wind_speed;

$(document).ready(function(){

	$('#submitWeather').click(function(){

		var city = $("#city").val();

		if(city != ''){

			$.ajax({

				url: 'http://api.openweathermap.org/data/2.5/weather?q=' + city + "&units=metric" +
				"&appid=3cde70023f333ed0c85fca223f5de840",
				type: "GET",
				dataType: "jsonp",
				success: function(data){
					
					var widget = show(data);
					$("#show").html(widget);
					foo();
				}

			});

		} else{
			alert("Field cannot be empty");
		}
	});
});

var show = function(data){
	
	city = data.name +","+ data.sys.country;
	weather = data.weather[0].main;
	temp = data.main.temp;
	min_temp = data.main.temp_min;
	max_temp = data.main.temp_max;
	wind_speed = data.wind.speed;
	
	return 	"<h4><strong>Current Weather for </strong> "+data.name + "," + data.sys.country +" " +"(" +data.coord.lat +"," +data.coord.lon +")"+"</h4>" +
			"<h5><strong>Weather</strong>: "+ data.weather[0].main +"</h5>" +
			"<h5><strong>Description</strong>: "+ data.weather[0].description +"</h5>" +
			"<h5><strong>Temperature</strong>: "+ data.main.temp + "&deg;c" +"</h5>" +
			"<h5><strong>Pressure</strong>: "+ data.main.pressure +"</h5>" +
			"<h5><strong>Humidity</strong>: "+ data.main.humidity +"</h5>" +
			"<h5><strong>Min. Temperature</strong>: "+ data.main.temp_min + "&deg;c" +"</h5>" +
			"<h5><strong>Max. Temperature</strong>: "+ data.main.temp_max + "&deg;c" +"</h5>" +
			"<h5><strong>Sea level</strong>: "+ data.main.sea_level +"</h5>" +
			"<h5><strong>Wind Speed</strong>: "+ data.wind.speed +"</h5>" +
			"<h5><strong>Wind Direction</strong>: "+ data.wind.deg +"</h5>" +
			"<h5><strong>City id</strong>: "+ data.id +"</h5>";
}

var foo = function(){
	  var button = document.createElement('button');
	  button.innerHTML = 'Add to favourites';
	  button.onclick = function(){
		  callServletWithAjax();
		  //alert("Button Clicked");
	  };
	  document.getElementById('addfav').appendChild(button);
	};
	
function callServletWithAjax(){
	var xmlhttp = new XMLHttpRequest();
	
	xmlhttp.onreadystatechange = function(){
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
			document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
		}
	};
	
	var params = "city=" +city+ "&weather=" +weather+ "&temp=" +temp+ "&min_temp=" +min_temp+ "&max_temp=" +max_temp+ "&wind_speed="+wind_speed;
	xmlhttp.open('GET',"http://localhost:8080/ClearSky/Favourites?"+params, true);
	xmlhttp.send();
}