<%-- 
    Document   : index
    Created on : Jul 27, 2023, 4:52:54 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="action" />
<section class="container">
    <h1 class="text-center text-info mt-1">DANH SÁCH KHÓA LUẬN</h1>

    <c:if test="${counter > 1}">
        <ul class="pagination mt-1">
            <li class="page-item"><a class="page-link" href="${action}">Tất cả</a></li>
                <c:forEach begin="1" end="${counter}" var="i">
                    <c:url value="/" var="pageUrl">
                        <c:param name="page" value="${i}" />
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
        </ul>
    </c:if>

    <table class="table table-hover" style="border: 1px 1px solid; border-collapse: collapse">
        <thead>
            <tr>
                <th> </th>
                <th>Id</th>
                <th>Tên khóa luận</th>
                <th>Ngày tạo</th>
                <th>Trạng thái</th>
                <th>Sinh viên tham gia</th>
                <th>GV hướng dẫn</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${thesis}" var="t">
                <tr>
                    <td></td>
                    <td>${t.id}</td>
                    <td>${t.name}</td>
                    <td>${t.date}</td>
                    <td>${t.status}</td>
                    <td>${t.userSet1}</td>
                    <td></td>
                    <td>
                        <c:url value="/thesisManager/${t.id}" var="api"/>
                        <a href="${api}" class="btn btn-info">Cập nhật</a>
                        <button class="btn btn-danger">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>


