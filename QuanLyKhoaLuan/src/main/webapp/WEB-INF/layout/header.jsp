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
<c:url value="/dclist" var="defense"/>
<c:url value="/infouser" var="info"/>
<c:url value="/changepassword" var="change"/>
<c:url value="/score" var="s"/>
<c:url value="/stat" var="stat"/>
<c:url value="/setcriteria" var="cri"/>
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${action}">ThesisManager</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav me-auto">
                <se:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_GVU')">
                    <li class="nav-item">
                        <a class="nav-link" href="${thesis}">Quản lý khóa luận</a>
                    </li>
                    <se:authorize access="hasRole('ROLE_ADMIN')">
                        <li class="nav-item">
                            <a class="nav-link" href="${user}">Quản lý người dùng</a>
                        </li>
                    </se:authorize>
                    <li class="nav-item">
                        <a class="nav-link" href="${defense}">Hội đồng khóa luận</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${stat}">Thống kê</a>
                    </li
                    <li class="nav-item">
                        <a class="nav-link" href="${cri}">Thiết lập tiêu chí</a>
                    </li>
                </se:authorize>

                <se:authorize access="hasRole('ROLE_SV')">
                    <li class="nav-item">
                        <a class="nav-link" href="#">Xem điểm</a>
                    </li>
                </se:authorize>
                <se:authorize access="hasRole('ROLE_GV')">
                    <li class="nav-item">
                        <a class="nav-link" href="${s}">Chấm điểm</a>
                    </li>
                </se:authorize>
            </ul>
            <ul class="navbar-nav ml-auto menu" >
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item" style="position: relative; right: 280px;">
<!--                            <img src="${avatar}" width="40" class="rounded-circle"
                                 alt=""/>-->
                            <span style="font-style: bold; color: white">Chào ${pageContext.request.userPrincipal.name}</span>
                        </li>
                        <div class="dropdown" style="position: relative; right: 270px;">
                            <a class="dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                                <!--<i class="fa-solid fa-caret-down"></i>-->
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                                <li><a class="dropdown-item" href="<c:url value="/logout"/>">Đăng xuất</a></li>
                                <li><a class="dropdown-item" href="${info}">Thông tin người dùng</a></li>
                                <li><a class="dropdown-item" href="${change}">Thay đổi mật khẩu</a></li>
                            </ul>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/login"/>">Đăng nhập</a>
                        </li>
                    </c:otherwise>
                </c:choose>
                <se:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_GVU')">
                    <li style="position: absolute; right: 15px">
                        <form class="d-flex" action="${action}">
                            <input class="form-control me-2" type="text" name="kw" placeholder="Nhập từ khóa...">
                            <button class="btn btn-primary" type="submit">Tìm</button>
                        </form>
                    </li>
                </se:authorize>
            </ul>
        </div>
    </div>
</nav>

