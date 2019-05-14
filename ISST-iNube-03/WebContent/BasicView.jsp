<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="icon" type="image/png" href="assets/img/favicon.ico">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Dashboard</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="css/animate.min.css" rel="stylesheet"/>

    <!--  Light Bootstrap Table core CSS    -->
    <link href="css/light-bootstrap-dashboard.css?v=1.4.0" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="assets/css/demo.css" rel="stylesheet" />


    <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>
    <link href="css/pe-icon-7-stroke.css" rel="stylesheet" />

</head>
<body>

<div class="wrapper">
    <div class="sidebar" data-color="blue">

    <!--

        Tip 1: you can change the color of the sidebar using: data-color="blue | azure | green | orange | red | purple"
        Tip 2: you can also add an image using data-image tag

    -->

    	<div class="sidebar-wrapper">
            <div class="logo">
                <a class="simple-text">
                    iNUBE
                </a>
            </div>

            <ul class="nav">
                <li class="active">
                    <a href="BasicServlet?email=${user.email}">
                        <i class="pe-7s-graph"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
                <shiro:hasRole name="premium"><li>
                    <a href="PremiumServlet?email=${user.email}">
                        <i class="pe-7s-graph"></i>
                        <p>Comparativa</p>
                    </a>
                </li></shiro:hasRole>
                <li>
                    <a href="ProfileServlet?email=${user.email }">
                        <i class="pe-7s-user"></i>
                        <p>Mi Perfil</p>
                    </a>
                </li>
                <li>
                    <a href="TableServlet?terminal=${user.business.tpv.id}">
                        <i class="pe-7s-note2"></i>
                        <p>Table List</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Dashboard</a>
                </div>
                <div class="collapse navbar-collapse">
                    <img src="images/logo2.png">

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="LogoutView.jsp?email=${user.email }">
                                <p>Log out</p>
                            </a>
                        </li>
						<li class="separator hidden-lg"></li>
                    </ul>
                </div>
            </div>
        </nav>


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12"> 
                        <div class="card">

                            <div id="grafica3">
                                    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">

                                    </script>
                                    <script type="text/javascript">
                                        google.charts.load('current', {packages: ['corechart']});
                                    </script>
                                    
                                   

                            </div>
                                <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                                <script language="JavaScript" type="text/javascript">
                                
                                $(document).ready(function(){
                                    $.ajax({
                                        url: 'DataServlet',
                                        data: {
                                            type: 'dia',
                                            tpv: '${user.business.tpv.id}'
                                        },
                                        method: 'GET',
                                        success: function (response) {
                                            console.log(response);
                                            response = JSON.parse(response);
                                            var data = [
                                                ['Dia', 'Importe']
                                            ]
                                            for (var i = 0; i < Object.keys(response).length; i++) {
                                                data.push([Object.keys(response)[i], Object.values(response)[i]])
                                                console.log(data)
                                            }               
                                            function drawChart3() {
                                                // Define the chart to be drawn.
                                                var data3 = google.visualization.arrayToDataTable(data);
                                            
                                                var options = {title: 'Ingresos por día',
                                                legend: {position: 'none'},
                                                'height':250,};
                                            
                                                // Instantiate and draw the chart.
                                                var chart = new google.visualization.ColumnChart(document.getElementById('grafica3'));
                                                chart.draw(data3, options);
                                            }
                                            google.charts.setOnLoadCallback(drawChart3);
                                            
                                        }
                                    })
                                })
                                </script>
                        </div>
                    </div> 
                </div>
                <div class="row"> 
                    <div class="col-md-12"> 
                        <div class="card">
                            <div id="grafica4">
                                    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">

                                    </script>
                                    <script type="text/javascript">
                                        google.charts.load('current', {packages: ['corechart']});
                                    </script>
                                    
                                    

                            </div>
                                <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                                <script language="JavaScript" type="text/javascript">
                                
                                $(document).ready(function(){
                                    $.ajax({
                                        url: 'DataServlet',
                                        data: {
                                            type: 'mes',
                                            tpv: '${user.business.tpv.id}'
                                        },
                                        method: 'GET',
                                        success: function (response) {
                                            console.log(response);
                                            response = JSON.parse(response);
                                            var data = [
                                                ['Mes', 'Importe']
                                            ]
                                            for (var i = 0; i < Object.keys(response).length; i++) {
                                                data.push([Object.keys(response)[i], Object.values(response)[i]])
                                                console.log(data)
                                            }               
                                            function drawChart4() {
                                                // Define the chart to be drawn.
                                                var data4 = google.visualization.arrayToDataTable(data);
                                            
                                                var options = {title: 'Ingresos por mes',
                                                legend: {position: 'none'},
                                                'height':400,};
                                            
                                                // Instantiate and draw the chart.
                                                var chart = new google.visualization.ColumnChart(document.getElementById('grafica4'));
                                                chart.draw(data4, options);
                                            }
                                            google.charts.setOnLoadCallback(drawChart4);
                                            
                                        }
                                    })
                                })
                                </script>
                            
                        </div>
                    </div> 
                </div> 
                <div class="row"> 
                    <div class="col-md-12"> 
                        <div class="card">
                            <div id="grafica5">
                                    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">

                                    </script>
                                    <script type="text/javascript">
                                        google.charts.load('current', {packages: ['corechart']});
                                    </script>
                                    
                                  

                             </div>
                                <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                                <script language="JavaScript" type="text/javascript">
                                
                                $(document).ready(function(){
                                    $.ajax({
                                        url: 'DataServlet',
                                        data: {
                                            type: 'transmes',
                                            tpv: '${user.business.tpv.id}'
                                        },
                                        method: 'GET',
                                        success: function (response) {
                                            console.log(response);
                                            response = JSON.parse(response);
                                            var data = [
                                                ['Mes', 'Importe']
                                            ]
                                            for (var i = 0; i < Object.keys(response).length; i++) {
                                                data.push([Object.keys(response)[i], Object.values(response)[i]])
                                                console.log(data)
                                            }               
                                            function drawChart5() {
                                                // Define the chart to be drawn.
                                                var data5 = google.visualization.arrayToDataTable(data);
                                            
                                                var options = {title: 'Transacciones por mes',
                                                legend: {position: 'none'},
                                                'height':400,};
                                            
                                                // Instantiate and draw the chart.
                                                var chart = new google.visualization.ColumnChart(document.getElementById('grafica5'));
                                                chart.draw(data5, options);
                                            }
                                            google.charts.setOnLoadCallback(drawChart5);
                                            
                                        }
                                    })
                                })
                                </script>
                            
                        </div>
                    </div> 
                </div> 
<shiro:hasRole name="premium">
<div class="row">
                    <div class="col-md-12">
                        <div class="card ">
                                <div id="grafica6">
                                    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">

                                    </script>
                                    <script type="text/javascript">
                                        google.charts.load('current', {packages: ['corechart']});
                                    </script>
                                    
                                    
                                </div>
                                <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                                <script language="JavaScript" type="text/javascript">
                                
                                $(document).ready(function(){
                                    $.ajax({
                                        url: 'DataServlet',
                                        data: {
                                            type: 'edad',
                                            tpv: '${user.business.tpv.id}'
                                        },
                                        method: 'GET',
                                        success: function (response) {
                                            console.log(response);
                                            response = JSON.parse(response);
                                            var data = [
                                                ['Edad', 'Clientes']
                                            ]
                                            for (var i = 0; i < Object.keys(response).length; i++) {
                                                data.push([Object.keys(response)[i], Object.values(response)[i]])
                                                console.log(data)
                                            }               
                                            function drawChart6() {
                                                // Define the chart to be drawn.
                                                var data6 = google.visualization.arrayToDataTable(data);
                                            
                                                var options = {title: 'Clientes por edad',
                                                'height':400,};
                                            
                                                // Instantiate and draw the chart.
                                                var chart = new google.visualization.ColumnChart(document.getElementById('grafica6'));
                                                chart.draw(data6, options);
                                            }
                                            google.charts.setOnLoadCallback(drawChart6);
                                            
                                        }
                                    })
                                })
                                </script> 
                        </div>
                    </div>
                </div>
                <div class="row">                 
                    <div class="col-md-12">
                        <div class="card ">
                            <div id="grafica7">
                                <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">

                                </script>
                                <script type="text/javascript">
                                    google.charts.load('current', {packages: ['corechart']});
                                </script>
                                
                                

                            </div>
                            <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                            <script language="JavaScript" type="text/javascript">
                            
                            $(document).ready(function(){
                                $.ajax({
                                    url: 'DataServlet',
                                    data: {
                                        type: 'zipcode',
                                        tpv: '${user.business.tpv.id}'
                                    },
                                    method: 'GET',
                                    success: function (response) {
                                        console.log(response);
                                        response = JSON.parse(response);
                                        var data = [
                                            ['Codigo Postal', 'Cantidad']
                                        ]
                                        for (var i = 0; i < Object.keys(response).length; i++) {
                                            data.push([Object.keys(response)[i], Object.values(response)[i]])
                                            console.log(data)
                                        }               
                                        function drawChart7() {
                                            // Define the chart to be drawn.
                                            var data7 = google.visualization.arrayToDataTable(data);
                                        
                                            var options = {title: 'Transacciones por código postal del cliente',
                                            'height':400,};
                                        
                                            // Instantiate and draw the chart.
                                            var chart = new google.visualization.PieChart(document.getElementById('grafica7'));
                                            chart.draw(data7, options);
                                        }
                                        google.charts.setOnLoadCallback(drawChart7);
                                        
                                    }
                                })
                            })
                            </script>
                            
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <div class="card ">
                                <div id="grafica8">
                                    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">

                                    </script>
                                    <script type="text/javascript">
                                        google.charts.load('current', {packages: ['corechart']});
                                    </script>
                                    
                                    

                                </div>
                                <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                                <script language="JavaScript" type="text/javascript">
                                
                                $(document).ready(function(){
                                    $.ajax({
                                        url: 'DataServlet',
                                        data: {
                                            type: 'genero',
                                            tpv: '${user.business.tpv.id}'
                                        },
                                        method: 'GET',
                                        success: function (response) {
                                            console.log(response);
                                            response = JSON.parse(response);
                                            var data = [
                                                ['Genero', 'Cantidad']
                                            ]
                                            for (var i = 0; i < Object.keys(response).length; i++) {
                                                data.push([Object.keys(response)[i], Object.values(response)[i]])
                                                console.log(data)
                                            }               
                                            function drawChart8() {
                                                // Define the chart to be drawn.
                                                var data8 = google.visualization.arrayToDataTable(data);
                                            
                                                var options = {title: 'Transacciones por género',
                                                
                                                'height':400,
                                                pieHole:0.4,};
                                            
                                                // Instantiate and draw the chart.
                                                var chart = new google.visualization.PieChart(document.getElementById('grafica8'));
                                                chart.draw(data8, options);
                                            }
                                            google.charts.setOnLoadCallback(drawChart8);
                                            
                                        }
                                    })
                                })
                                </script>
                        </div>
                    </div>

                    <div class="col-md-6">
                        <div class="card ">
                            <div id="grafica9">
                                <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">

                                </script>
                                <script type="text/javascript">
                                    google.charts.load('current', {packages: ['corechart']});
                                </script>
                                
                                

                            </div>
                            <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                            <script language="JavaScript" type="text/javascript">
                            
                            $(document).ready(function(){
                                $.ajax({
                                    url: 'DataServlet',
                                    data: {
                                        type: 'fidelidad',
                                        tpv: '${user.business.tpv.id}'
                                    },
                                    method: 'GET',
                                    success: function (response) {
                                        console.log(response);
                                        response = JSON.parse(response);
                                        var data = [
                                            ['Cliente', 'Cantidad']
                                        ]
                                        for (var i = 0; i < Object.keys(response).length; i++) {
                                            data.push([Object.keys(response)[i], Object.values(response)[i]])
                                            console.log(data)
                                        }               
                                        function drawChart9() {
                                            // Define the chart to be drawn.
                                            var data9 = google.visualization.arrayToDataTable(data);
                                        
                                            var options = {title: 'Transacciones por cliente',
                                            legend: {position: 'none'},
                                            'height':400,};
                                        
                                            // Instantiate and draw the chart.
                                            var chart = new google.visualization.PieChart(document.getElementById('grafica9'));
                                            chart.draw(data9, options);
                                        }
                                        google.charts.setOnLoadCallback(drawChart9);
                                        
                                    }
                                })
                            })
                            </script>
                            
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12"> 
                        <div class="card">
                            <div id="grafica10">
                                    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">

                                    </script>
                                    <script type="text/javascript">
                                        google.charts.load('current', {packages: ['corechart']});
                                    </script>
                                    
                             
                            </div>
                                <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
                                <script language="JavaScript" type="text/javascript">
                                
                                $(document).ready(function(){
                                    $.ajax({
                                        url: 'DataServlet',
                                        data: {
                                            type: 'hora',
                                            tpv: '${user.business.tpv.id}'
                                        },
                                        method: 'GET',
                                        success: function (response) {
                                            console.log(response);
                                            response = JSON.parse(response);
                                            var data = [
                                                ['Hora', 'Importe']
                                            ]
                                            for (var i = 0; i < Object.keys(response).length; i++) {
                                                data.push([Object.keys(response)[i], Object.values(response)[i]])
                                                console.log(data)
                                            }               
                                            function drawChart10() {
                                                // Define the chart to be drawn.
                                                var data10 = google.visualization.arrayToDataTable(data);
                                            
                                                var options = {title: 'Ingresos por hora',
                                                legend: {position: 'none'},
                                                'height':400,};
                                            
                                                // Instantiate and draw the chart.
                                                var chart = new google.visualization.SteppedAreaChart(document.getElementById('grafica10'));
                                                chart.draw(data10, options);
                                            }
                                            google.charts.setOnLoadCallback(drawChart10);
                                            
                                        }
                                    })
                                })
                                </script>
                            
                        </div>
                    </div> 
                </div> 
</shiro:hasRole>
            </div>
        </div>

    </div>
</div>


</body>

    <!--   Core JS Files   -->
    <script src="assets/js/jquery.3.2.1.min.js" type="text/javascript"></script>
	<script src="assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Charts Plugin -->
	<script src="assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="assets/js/light-bootstrap-dashboard.js?v=1.4.0"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="assets/js/demo.js"></script>

	<script type="text/javascript">
    	$(document).ready(function(){

        	demo.initChartist();

        	$.notify({
            	icon: 'pe-7s-gift',
            	message: "Welcome to <b>Light Bootstrap Dashboard</b> - a beautiful freebie for every web developer."

            },{
                type: 'info',
                timer: 4000
            });

    	});
	</script>

</html>