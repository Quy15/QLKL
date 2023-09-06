<%-- 
    Document   : sendmail
    Created on : Sep 5, 2023, 9:57:13 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${user}" var="nd">
    <c:forEach items="${thesis}" var="khoaluan">
        <c:forEach items="${thesisP}" var="tp">
            <c:if test="${tp.userId.id == nd.id && tp.thesisId.id == khoaluan.id && khoaluan.status == 'Đã thực hiện'}">
                <input  type="text" name="userId" value="${nd.id}"/>
            </c:if>
        </c:forEach>
    </c:forEach>
</c:forEach>
