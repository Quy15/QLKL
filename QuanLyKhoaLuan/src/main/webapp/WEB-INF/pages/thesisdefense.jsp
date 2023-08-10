<%-- 
    Document   : thesisdefense
    Created on : Aug 9, 2023, 9:13:55 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<h2 class=" text-info text-center">Hội đồng bảo vệ khóa luận</h2>
<!--If you want your form elements to appear side by side, use .row and .col:-->
<input type="button" class="btn btn-primary" onclick="addMem()" value="Thêm thành viên"/>
<form:form>
    <div class="row">
        <div class="col" id="input">
            <input type="text" class="form-control" placeholder="Enter email" name="email">
            <label class="form-label" for="form3Example3c">Thành viên</label>
        </div>
        <div class="col" id="input">
            <input type="password" class="form-control" placeholder="Enter password" name="pswd">
            <label class="form-label" for="form3Example3c">Vai trò</label>
        </div>
    </div>
</form:form>
</div>
<script src="<c:url value="/js/main.js"/>"></script>
