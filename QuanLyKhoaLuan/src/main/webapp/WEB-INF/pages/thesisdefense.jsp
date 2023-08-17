<%-- 
    Document   : thesisdefense
    Created on : Aug 9, 2023, 9:13:55 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 class=" text-info text-center">Hội đồng bảo vệ khóa luận</h2>
<!--If you want your form elements to appear side by side, use .row and .col:-->
<c:url value="/thesisdefense" var="action"/>
<form:form method="post" enctype="multipart/form-data" action="${action}" modelAttribute="defenseCommittee">
    <form:input type="text" class="form-control" path="name" id="name" placeholder="Tên hội đồng" name="name"/>
    <label class="form-label" for="form3Example1c">Tên hội đồng</label>
    <br/>
    <button class="btn btn-success" style="font-size: 12.5px">Xác nhận</button>
</form:form>
<script src="<c:url value="/js/main.js"/>"></script>
