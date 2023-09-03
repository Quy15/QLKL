<%-- 
    Document   : stat
    Created on : Aug 27, 2023, 1:57:07 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/stat" var="s"/>

<script>
    
    var dataChart = [];
    <c:forEach items="${stats}" var="st">
    dataChart.push({y: ${st[1]}, label: "${st[0]}"});
    </c:forEach>
    var dataChart2 = [];
    <c:forEach items="${scorestats}" var="score">
    dataChart2.push({y: ${score[1]}, label: "${score[0]}"});
    </c:forEach>
    window.onload = function () {

        var chart = new CanvasJS.Chart("chartContainer", {
            theme: "light2", // "light1", "light2", "dark1", "dark2"
            exportEnabled: true,
            animationEnabled: true,
            title: {
                text: "Thống kê tần suất thực hiện khóa luận từng ngành"
            },
            data: [{
                    type: "pie",
                    startAngle: 25,
                    toolTipContent: "<b>{label}</b>: {y}Khóa luận",
                    showInLegend: "true",
                    legendText: "{label}",
                    indexLabelFontSize: 16,
                    indexLabel: "{label} - {y}lần",
                    dataPoints: dataChart
                }]
        });
        chart.render();
        
        var chart2 = new CanvasJS.Chart("chartContainer2", {
            animationEnabled: true,
            theme: "light2", // "light1", "light2", "dark1", "dark2"
            title: {
                text: "Thống kê điểm trung bình khóa luận theo năm"
            },
            axisY: {
                title: "Tổng số"
            },
            data: [{
                    type: "column",
                    showInLegend: true,
                    legendText: "Điểm",
                    dataPoints: dataChart2
                }]
        });
        chart2.render();
    };
</script>
<div id="chartContainer" style="height: 400px; width: 100%" class="mt-4"></div>
<form action="${s}" enctype="multipart/form-data">
    <input name="year" placeholder="Nhập..." id="search"/>
    <button type="submit" class="btn btn-info">Tìm</button>
</form>

<div id="chartContainer2" style="height: 400px; width: 100%" class="mt-4"></div>



<script src="https://cdn.canvasjs.com/canvasjs.min.js"></script>