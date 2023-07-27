<%-- 
    Document   : index
    Created on : Jul 27, 2023, 4:52:54 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/" var="action" />
<section class="container">
    <h1 class="text-center text-info mt-1">DANH SÁCH SẢN PHẨM</h1>
   
    <table class="table table-hover">
        <thead>
            <tr>
                <th></th>
                <th>Id</th>
                <th>Tên khóa luận</th>
                <th>Ngày tạo</th>
                <th>Trạng thái</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${thesis}" var="t">
                <tr>
                    <td>
                    </td>
                    <td>${t.id}</td>
                    <td>${t.name}</td>
                    <td>${t.date}</td>
                    <td>${t.status}</td>
                    <td>
                        <a href="#" class="btn btn-info">Cập nhật</a>
                        <button class="btn btn-danger">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
