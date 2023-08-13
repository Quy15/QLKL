<%-- 
    Document   : usermanager
    Created on : Aug 9, 2023, 10:04:55 AM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/usermanager" var="action" />
<section class="container">
    <h1 class="text-center text-info mt-1">DANH SÁCH NGƯỜI DÙNG</h1>

    <c:if test="${count > 1}">
        <ul class="pagination mt-1">
            <li class="page-item"><a class="page-link" href="${action}">Tất cả</a></li>
                <c:forEach begin="1" end="${count}" var="i">
                    <c:url value="/usermanager" var="pageUrl">
                        <c:param name="page" value="${i}" />
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
        </ul>
    </c:if>
    <c:url value="/addUser" var="add"/>
    <a href="${add}" class="btn btn-success" style="font-size: 12.5px" >Thêm người dùng</a>

    <table class="table table-hover" style="font-size: 12.5px; border: 1px solid; border-collapse: collapse;">
        <thead>
            <tr>
                <th style="border: 1px solid; border-collapse: collapse;">ID</th>
                <th style="border: 1px solid; border-collapse: collapse;">Họ tên</th>
                <th style="border: 1px solid; border-collapse: collapse;">Tài khoản</th>
                <th style="border: 1px solid; border-collapse: collapse;">Avatar</th>
                <th style="border: 1px solid; border-collapse: collapse;">Email</th>
                <th style="border: 1px solid; border-collapse: collapse;">Ngành</th>
                <th style="border: 1px solid; border-collapse: collapse;">Vai trò</th>

            </tr>
        </thead>
        <tbody>
            <c:forEach items="${user}" var="u">
                <tr >
                    <c:choose>
                        <c:when test="${u.username == 'admin'}">
                            <td hidden style="border: 1px solid; border-collapse: collapse;">${u.id}</td>
                            <td hidden style="border: 1px solid; border-collapse: collapse;">${u.firstName} ${u.lastName}</td>
                            <td hidden style="border: 1px solid; border-collapse: collapse;">${u.username}</td>
                            <td hidden style="border: 1px solid; border-collapse: collapse;"><img src="${u.avatar}" alt="alt" style="width: 120px"/></td>
                            <td hidden style="border: 1px solid; border-collapse: collapse">${u.email}</td>
                            <td hidden style="border: 1px solid; border-collapse: collapse">
                                <c:forEach items="${major}" var="m">
                                    <c:if test="${m.id == u.majorId.id}">
                                        ${m.name}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td hidden style="border: 1px solid; border-collapse: collapse">
                                <c:forEach items="${role}" var="r">
                                    <c:if test="${r.id == u.roleId.id}">
                                        ${r.name}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td hidden style="display: flex; justify-content: space-around;border-collapse: collapse;">
                                <c:url value="/usermanager/${u.id}" var="api"/>
                                <a href="${api}" style="font-size: 12.5px" class="btn btn-info">Cập nhật</a>
                                <button class="btn btn-danger" style="font-size: 12.5px" onclick="deleteThesis('${api}')">Xóa</button>
                            </td>
                        </c:when>
                        <c:otherwise>
                            <td style="border: 1px solid; border-collapse: collapse;">${u.id}</td>
                            <td style="border: 1px solid; border-collapse: collapse;">${u.firstName} ${u.lastName}</td>
                            <td style="border: 1px solid; border-collapse: collapse;">${u.username}</td>
                            <td style="border: 1px solid; border-collapse: collapse;"><img src="${u.avatar}" alt="alt" style="width: 120px"/></td>
                            <td style="border: 1px solid; border-collapse: collapse">${u.email}</td>
                            <td style="border: 1px solid; border-collapse: collapse">
                                <c:forEach items="${major}" var="m">
                                    <c:if test="${m.id == u.majorId.id}">
                                        ${m.name}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td style="border: 1px solid; border-collapse: collapse">
                                <c:forEach items="${role}" var="r">
                                    <c:if test="${r.id == u.roleId.id}">
                                        ${r.name}
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td style="border: 1px solid; border-collapse: collapse;">
                                <c:url value="/usermanager/${u.id}" var="api"/>
                                <a href="${api}" style="font-size: 12.5px" class="btn btn-info">Cập nhật</a>
                                <button class="btn btn-danger" style="font-size: 12.5px" onclick="deleteUser('${api}')">Xóa</button>
                            </td>
                        </c:otherwise>
                    </c:choose>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/js/main.js"/>"></script>
