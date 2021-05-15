<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>Google Map</title>
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAhuErE4MLshdi-pRpvT7s-x8UMdzFD0ew&callback=initMap&region=kr"></script>
</head>

<body>
<button onclick="getLocation()">Try It</button>

	<p id="demo"></p>

	<script>
		var x = document.getElementById("demo");

		function getLocation() {
			if (navigator.geolocation) {
				navigator.geolocation.getCurrentPosition(showPosition);
			} else {
				x.innerHTML = "Geolocation is not supported by this browser.";
			}
		}

		function showPosition(position) {

			x.innerHTML = "Latitude: " + position.coords.latitude
					+ "<br>Longitude: " + position.coords.longitude;
		}
	</script>
	<div id="map" style="width: 100%; height: 100vh;"></div>
	<script>
		
	</script>
	<script src="http://code.jquery.com/jquery-1.11.0.js"></script>
	<script>
		$(function() {
			function initMap() {

				var seoul = {
					lat : 37.567912199999995,
					lng : 126.98296549999999
				};
				var map = new google.maps.Map(document.getElementById('map'), {
					zoom : 18,
					center : seoul
				});

			}
			var seoul = {
				lat : 37.5642135,
				lng : 127.0016985
			};
			map = new google.maps.Map(document.getElementById('map'), {
				zoom : 15,
				center : seoul
			});

			new google.maps.Marker({
				position : seoul,
				map : map,
				label : "서울 중심 좌표"
			});
			// Geolocation API에 액세스할 수 있는지를 확인
			if (navigator.geolocation) {
				//위치 정보를 얻기
				navigator.geolocation.getCurrentPosition(function(pos) {
					$('#latitude').html(pos.coords.latitude); // 위도
					$('#longitude').html(pos.coords.longitude); // 경도
				});
			} else {
				alert("이 브라우저에서는 Geolocation이 지원되지 않습니다.")
			}
			initMap();
		});
	</script>
	<ul>
		<li>위도:<span id="latitude"></span></li>
		<li>경도:<span id="longitude"></span></li>
	</ul>
</body>
</html>