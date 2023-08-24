<%-- 
    Document   : score
    Created on : Aug 21, 2023, 10:01:31 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/score" var="s"/>
<div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start mt-4 mb-4">
    <p class="lead fw-normal mb-0 me-3">Khóa luận cần chấm</p>
    <select>
        <c:forEach items="${thesis}" var="t">
            <c:forEach items="${thesisscore}" var="ts">
                <c:forEach items="${udc}" var="userd">
                    <c:if test="${t.id == ts.thesisId.id && userd.id == ts.userDefenseCommitteeId.id && userd.userId.id == userid}">
                        <option>
                            ${t.name}
                        </option>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </c:forEach>
    </select>
</div>
<form method="post" enctype="multipart/form-data" action="${s}">
    <table class="table table-hover addUser" style="font-size: 12.5px;">
        <tr>
            <th hidden="hidden" style="border: 1px solid; border-collapse: collapse;">Id</th>
            <th style="border: 1px solid; border-collapse: collapse;">Các tiêu chí</th>
            <th style="border: 1px solid; border-collapse: collapse;">Điểm</th>

        </tr
        <c:forEach items="${criteria}" var="c">
            <tr id="index">
                <th hidden="hidden" style="border: 1px solid; border-collapse: collapse;">${c.id}</th>
                <td style="border: 1px solid; border-collapse: collapse;">
                    ${c.name}
                </td>
                <td style="border: 1px solid; border-collapse: collapse">
                    <input type="text"/>
                </td>
            </tr>
        </c:forEach>
    </table>

    <button type="submit" class="btn btn-success" style="font-size: 12.5px">Xác nhận</button>
</form>
