<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>ColumnChart1</title>

<script type="text/javascript">
	
</script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<script src="https://www.gstatic.com/charts/loader.js"></script>

<script>
	$(document).ready(function() {

		columnChart1();

	});
	google.charts.load('current', {
		packages : [ 'corechart' ]
	});
	google.charts.setOnLoadCallback(columnChart1);



	function columnChart1() {
		<%
		int cnt1 = (int) request.getAttribute("cnt1");
		int cnt2 = (int) request.getAttribute("cnt2");
		int cnt3 = (int) request.getAttribute("cnt3");
		int cnt4 = (int) request.getAttribute("cnt4");
		int cnt5 = (int) request.getAttribute("cnt5");
		%>

		var arr = [

		[ '인원', '인원수' ],

		[ '운동친구', <%=cnt1%> ],

		[ '영화친구', <%=cnt2%> ],

		[ '게임친구', <%=cnt3%> ],

		[ '음식친구', <%=cnt4%> ],
		[ '주식친구', <%=cnt5%> ]

		];

		var dataTable = google.visualization.arrayToDataTable(arr);


		var options = {

			title : '게시판별 글현황',

			hAxis : {

				title : '게시글수(개)',

				titleTextStyle : {

					color : 'black'

				}

			}

		};


		var objDiv = document.getElementById('column_chart_div1');


		var chart = new google.visualization.ColumnChart(objDiv);


		chart.draw(dataTable, options);

	} 

</script>

</head>

<body>
	<div id="column_chart_div1" style="width: 900px; height: 500px;"></div>

</body>

</html>