var city,weather,temp,min_temp,max_temp,wind_speed,humidity;

$(document).ready(function() {
	$("#submitWeather").click(function() {
		var xmlHttp = new XMLHttpRequest();
		var city = document.getElementById("city").value;
		var url = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric" +
		"&appid=3cde70023f333ed0c85fca223f5de840";
		xmlHttp.open("GET", url, true);
		xmlHttp.send();
		xmlHttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var data = JSON.parse(this.responseText);
				//var dataObj = JSON.stringify(myArr);
				alert(data);	
				city = data.name +","+ data.sys.country;
				weather = data.weather[0].main;
				temp = Math.ceil(data.main.temp);
				min_temp = data.main.temp_min;
				max_temp = data.main.temp_max;
				wind_speed = data.wind.speed;
				humidity = data.main.humidity;
				
				alert(city);
				document.getElementById("cityname").innerHTML = city;
				document.getElementById("temp").innerHTML = temp +"<sup>o</sup>C";
				document.getElementById("icon").innerHTML = "<img src='http://openweathermap.org/img/w/10d.png'>";
				document.getElementById("weather").innerHTML = weather;
				document.getElementById("wind_speed").innerHTML = "<img src='images/icon-wind.png'>" +wind_speed +"Km/h";
				document.getElementById("cityname").innerHTML = city;
				document.getElementById("humidity").innerHTML = "<img src='images/icon-umberella.png'>" +humidity +"%";
				document.getElementById("compass").innerHTML = "<img src='images/icon-compass.png'>" + "East";

				var button = document.createElement("button");
				
				button.innerHTML = "Add to favourites";
				button.onclick = function() {
					addToFavourites();

				}
				document.getElementById('addfav').replaceWith(button);
			}
		}
	});
});
	
function addToFavourites(){
	var xmlhttp = new XMLHttpRequest();
	
	xmlhttp.onreadystatechange = function(){
		if(xmlhttp.readyState == 4 && xmlhttp.status == 200){
			document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
		}
	};
	
	var params = "city=" +city+ "&weather=" +weather+ "&temp=" +temp+ "&min_temp=" +min_temp+ "&max_temp=" +max_temp+ "&wind_speed="+wind_speed + "&action=add";
	xmlhttp.open('GET',"http://localhost:8080/ClearSky/Favourites?"+params, true);
	xmlhttp.send();
}

function readJSON(){
	alert("data loaded");
	var request = new XMLHttpRequest();
	request.onreadystatechange = function(){
		if(request.readyState == 4 && request.status==200){
			var obj=JSON.parse(request.responseText);
			viewFavourites(obj);
		}
	};
	var params = "&action=view";
	request.open("GET", "http://localhost:8080/ClearSky/Favourites?"+params,true);
	request.send();
}

function viewFavourites(data){
	var len = data.Count;
	/*var movieObj="";
	 for(var i=0;i<len;i++){
	        movieObj+="<p class='nested_para'>";
	        movieObj+="Title:" + data.movies[i].title + "<br>";
	        movieObj+= "Release date: " + data.movies[i].release_date + "<br>";
	        movieObj+= "Rating: " + data.movies[i].rating + "<br>";
	        if(data.movies[i].overview.length!=0){
	            movieObj+= "Overview: " + data.movies[i].overview + "<br>";
	        }
	        movieObj+="</p>";
	        movieObj+= "<hr>";
	    }*/
	for(var i=0;i<=1;i++){
		document.getElementById("count" +i).innerHTML = "City : " +data.cities[i].city;
		document.getElementById("temp" +i).innerHTML = "Temperature : " +data.cities[i].temp;
		document.getElementById("mintemp" +i).innerHTML = "Min Temperature : " +data.cities[i].min_temp;
		document.getElementById("maxtemp" +i).innerHTML = "Max Temperature : " +data.cities[i].max_temp;
		document.getElementById("weather" +i).innerHTML = "Weather : " +data.cities[i].weather;
		document.getElementById("windspeed" +i).innerHTML = "Wind Speed : " +data.cities[i].wind_speed;
	}
}