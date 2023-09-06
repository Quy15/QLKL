<%-- 
    Document   : thesisManager
    Created on : Jul 31, 2023, 7:59:35 PM
    Author     : WIN10
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/thesisManager" var="action" />
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

    <c:url value="/addThesis" var="add"/>
    <a href="${add}" class="btn btn-success" style="font-size: 12.5px" >Thêm khóa luận</a>

    <table class="table table-hover" style="font-size: 12.5px; border: 1px solid; border-collapse: collapse;">
        <thead>
            <tr>
                <th style="border: 1px solid; border-collapse: collapse;">ID</th>
                <th style="border: 1px solid; border-collapse: collapse;">Tên khóa luận</th>
                <th style="border: 1px solid; border-collapse: collapse;">Ngày tạo</th>
                <th style="border: 1px solid; border-collapse: collapse;">Trạng thái</th>
                <th style="border: 1px solid; border-collapse: collapse;">Sinh viên tham gia</th>
                <th style="border: 1px solid; border-collapse: collapse;">GVHD</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${thesis}" var="t">
                <tr>
                    <td style="border: 1px solid; border-collapse: collapse;">${t.id}</td>
                    <td style="border: 1px solid; border-collapse: collapse;">${t.name}</td>
                    <td style="border: 1px solid; border-collapse: collapse;">${t.date}</td>
                    <td style="border: 1px solid; border-collapse: collapse;">${t.status}</td>
                    <td style="border: 1px solid; border-collapse: collapse">
                        <c:forEach items="${user}" var="u">
                            <c:forEach items="${thesisP}" var="p">
                                <c:if test="${u.id == p.userId.id && t.id == p.thesisId.id}">                                       
                                    ${u.firstName} ${u.lastName}
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>
                    <td style="border: 1px solid; border-collapse: collapse">
                        <c:forEach items="${user}" var="u">
                            <c:forEach items="${thesisI}" var="i">
                                <c:if test="${u.id == i.userId.id && t.id == i.thesisId.id}">
                                    ${u.firstName} ${u.lastName}
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </td>
                    <td style="display: flex; justify-content: space-around;border-collapse: collapse;">
                        <c:url value="/editthesis/${t.id}" var="api"/>
                        <a href="${api}" style="font-size: 12.5px" class="btn btn-info">Cập nhật</a>
                        <button class="btn btn-danger" style="font-size: 12.5px" onclick="deleteThesis('${api}')">Xóa</button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
<script src="<c:url value="/js/main.js"/>"></script>


