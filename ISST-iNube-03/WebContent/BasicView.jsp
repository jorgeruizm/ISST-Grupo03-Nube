<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>iNube</title>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<div id="container">

    <div id="header">
        <div id="title">
            <a>iNube</a>
            <img src="images/logo2.png">
        </div>
        
     <div id="navBar">
            <div class="navBarItem"><a href="BasicServlet?email=${user.email }">Mis gráficas</a></div>
            <div class="navBarItem"><a href="ComparativaView.jsp">Comparativa mercado</a></div>
            
            <div class="navBarItem"><a href="ProfileServlet?email=${user.email }">Mi Perfil</a></div>	
            <div class="navBarItem"><a href="LogoutView.jsp">Logout</a></div>
        </div>
    </div>


    <div id="front2">
        <span class="nTitle">Filtrar por fecha</span>
        <table class="filtro">
            <tr>
                <th>Inicio:</th>
                <td><input type="text" class="datepicker"></td>
            </tr>
            <tr>
                <th>Final:</th>
                <td><input type="text" class="datepicker"></td>
            </tr>
        </table>
        <tr>
            <th>
                <form id="loginF" action="BasicServlet" method="post">
                <button id="nButton2" action="submit">Filtrar</button></th>
                </form>
            </th>
        </tr>
    </div>
</div>


<div id="graficas">

    <div id="grafica1">


        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">

        </script>
        <script type="text/javascript">
            google.charts.load('current', {packages: ['corechart']});
        </script>


        <script language="JavaScript" type="text/javascript">

            function drawChart1() {
                // Define the chart to be drawn.
                var data1 = google.visualization.arrayToDataTable([
                    ['Mes', 'Ventas'],
                    ['Septiembre', 88000],
                    ['Octubre', 98000],
                    ['Noviembre', 100000],
                    ['Diciembre', 130000],
                    ['Enero', 110000],
                    ['Febrero', 105000],
                    ['Marzo', 111000],
                    ['Abril', 117000],
                    ['Mayo', 100000]

                ]);
                var options = {
                    title: 'Ingresos por mes de mi empresa',
                    'width': 1200,
                    'height': 400,
                };

                // Instantiate and draw the chart.
                var chart = new google.visualization.ColumnChart(document.getElementById('grafica1'));
                chart.draw(data1, options);
            }

            google.charts.setOnLoadCallback(drawChart1);
        </script>
    </div>

    <div id="grafica2">

        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">
        </script>

        <script type="text/javascript">
            google.charts.load('current', {packages: ['corechart']});
        </script>

        <script language="JavaScript" type="text/javascript">
        function drawChart2() {
        // Define the chart to be drawn.
        var data2 = new google.visualization.DataTable();
        data2.addColumn('string', 'Día');
        data2.addColumn('number', 'Ingresos por día');
        data2.addRows([
        ['1/01/2019', 2000],
        ['2/01/2019', 5000],
        ['3/01/2019', 2700],
        ['4/01/2019', 4800],
        ['5/01/2019', 4900],
        ['6/01/2019', 3800],
        ['7/01/2019', 2900],
        ['8/01/2019', 3500],
        ['9/01/2019', 3600],
        ['10/01/2019', 3400],
        ['11/01/2019', 3800],
        ['12/01/2019', 4000],
        ['13/01/2019', 4900],
        ['14/01/2019', 2500],
        ['15/01/2019', 2100],
        ['16/01/2019', 4800],
        ['17/01/2019', 3000],
        ['18/01/2019', 4850],
        ['19/01/2019', 5100],
        ['20/01/2019', 3500],
        ['21/01/2019', 2000],
        ['22/01/2019', 4000],
        ['23/01/2019', 2500],
        ['24/01/2019', 2100],
        ['25/01/2019', 4800],
        ['26/01/2019', 3000],
        ['27/01/2019', 4850],
        ['28/01/2019', 5100],
        ['29/01/2019', 3500],
        ['30/01/2019', 3598],
        ['31/01/2019', 4000],
        ['1/02/2019', 2000],
        ['2/02/2019', 5000],
        ['3/02/2019', 2700],
        ['4/02/2019', 4800],
        ['5/02/2019', 4900],
        ['6/02/2019', 3578],
        ['7/02/2019', 2900],
        ['8/02/2019', 3500],
        ['9/02/2019', 3600],
        ['10/02/2019', 3400],
        ['11/02/2019', 3800],
        ['12/02/2019', 4000],
        ['13/02/2019', 4900],
        ['14/02/2019', 2500],
        ['15/02/2019', 2100],
        ['16/02/2019', 4800],
        ['17/02/2019', 3000],
        ['18/02/2019', 4850],
        ['19/02/2019', 5100],
        ['20/02/2019', 3500],
        ['21/02/2019', 2000],
        ['22/02/2019', 4000],
        ['23/02/2019', 2500],
        ['24/02/2019', 2259],
        ['25/02/2019', 4800],
        ['26/02/2019', 3000],
        ['27/02/2019', 4850],
        ['28/02/2019', 5100],
        ['1/03/2019', 3500],
        ['2/03/2019', 5000],
        ['3/03/2019', 2700],
        ['4/03/2019', 2000],
        ['5/03/2019', 4900],
        ['6/03/2019', 3800],
        ['7/03/2019', 2900],
        ['8/03/2019', 4895],
        ['9/03/2019', 3600],
        ['10/03/2019', 3400],
        ['11/03/2019', 4000],
        ['12/03/2019', 4000],
        ['13/03/2019', 3000],
        ['14/03/2019', 2500],
        ['15/03/2019', 2300],
        ['16/03/2019', 4600],
        ['17/03/2019', 3100],
        ['18/03/2019', 4850],
        ['19/03/2019', 5100],
        ['20/03/2019', 3500],
        ['21/03/2019', 2000],
        ['22/03/2019', 4000],
        ['23/03/2019', 2500],
        ['24/03/2019', 2100],
        ['25/03/2019', 4800],
        ['26/03/2019', 3000],
        ['27/03/2019', 4850],
        ['28/03/2019', 2500],
        ['29/03/2019', 3500],
        ['30/03/2019', 2000]
        ]);
        // Set chart options
        var options = {'title' : 'Ingresos por día',
        hAxis: {
        title: 'Fecha'
        },
        vAxis: {
        title: 'Ingresos'
        },
        'width':1200,
        'height':400,
        pointsVisible: true
        };
        // Instantiate and draw the chart.
        var chart = new google.visualization.LineChart(document.getElementById('grafica2'));
        chart.draw(data2, options);
        }
        google.charts.setOnLoadCallback(drawChart2);
       </script>
    </div>



    <div id="grafica3">
        <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js">

        </script>
        <script type="text/javascript">
            google.charts.load('current', {packages: ['corechart']});
        </script>
        <script language="JavaScript" type="text/javascript">

            function drawChart3() {
        // Define the chart to be drawn.
        var data3 = google.visualization.arrayToDataTable([
        ['Mes', 'Ventas'],
        ['Septiembre', 500],
        ['Octubre', 600],
        ['Noviembre', 670],
        ['Diciembre', 710],
        ['Enero', 700],
        ['Febrero', 730],
        ['Marzo', 750],
        ['Abril', 710],
        ['Mayo', 640]
        ]);

        var options = {title: 'Número de transacciones por mes',
        'width':1200,
        'height':400,};

        // Instantiate and draw the chart.
        var chart = new google.visualization.ColumnChart(document.getElementById('grafica3'));
        chart.draw(data3, options);
        }

        google.charts.setOnLoadCallback(drawChart3);

        </script>
        </div>

    </div>
</body>
</html>