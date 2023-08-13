<%-- 
    Document   : header
    Created on : Jul 27, 2023, 4:53:43 PM
    Author     : WIN10
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:url value="/" var="action"/>
<c:url value="/thesisManager" var="thesis"/>
<c:url value="/usermanager" var="user"/>
<c:url value="/thesisdefense" var="defense"/>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">ThesisManager</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav me-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${action}">Trang chủ</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="${thesis}">Quản lý khóa luận</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${user}">Quản lý người dùng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${defense}">Lập hội đồng</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Thống kê</a>
                </li>
            </ul>
            <ul class="navbar-nav ml-auto menu" >

                <li style="position: absolute; right: 220px">
                    <form class="d-flex" action="${action}">
                        <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ khóa...">
                        <button class="btn btn-primary" type="submit">Tìm</button>
                    </form>
                </li>

                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                            
                            <span style="font-style: bold; color: white">Chào ${pageContext.request.userPrincipal.name}</span>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/logout"/>">Đăng xuất</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/login"/>">Đăng nhập</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>

