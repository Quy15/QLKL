<%-- 
    Document   : defenseuser
    Created on : Aug 13, 2023, 1:55:42 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/defenseuser" var="de"/>
<form:form method="post" enctype="multipart/form-data" action="${de}" modelAttribute="userdefensecommittee">
    <h3 class="text-center">Thành viên khóa luận</h3>
    <input type="button" id="btnAdd" class="btn btn-primary" onclick="addUser()" value="+"/>

    <table class="table table-hover addUser" style="font-size: 12.5px;" id="defenseuser">
        <thead>
            <tr>
                <th style="border: 1px solid; border-collapse: collapse;">STT</th>
                <th style="border: 1px solid; border-collapse: collapse;">Tên giáo viên</th>
                <th style="border: 1px solid; border-collapse: collapse;">Vai trò</th>

            </tr>
        </thead>
        <tbody>
            <tr id="1">
                <td style="border: 1px solid; border-collapse: collapse;" class="ordinal">1</td>
                <td style="border: 1px solid; border-collapse: collapse;">
                    <form:select class="form-select" path="userId">
                        <c:forEach items="${user}" var="u">
                            <c:if test="${u.userRole == 'ROLE_GV'}">
                                <form:option value="${u.id}">
                                    ${u.firstName} ${u.lastName}
                                </form:option>
                            </c:if>
                        </c:forEach>
                    </form:select>
                </td>
                <td style="border: 1px solid; border-collapse: collapse">
                    <form:select class="form-select" path="defenseCommitteeRoleId">
                        <c:forEach items="${drole}" var="dr">
                            <form:option value="${dr.id}">
                                ${dr.name}
                            </form:option>
                        </c:forEach>
                    </form:select>
                </td>
                <td>
                    <input class="btn-danger" type="button" onclick="deleteRow(1)" value="X"/>
                </td>
            </tr>
        </tbody>
    </table>

    <h3 class="text-center">Hội đồng tham gia</h3>
    <input type="button" id="btnAdd" class="btn btn-primary"  value="+"/>
    <table class="table table-hover addThesis" style="font-size: 12.5px; " id="t">
        <thead>
            <tr>
                <th style="border: 1px solid; border-collapse: collapse;">STT</th>
                <th style="border: 1px solid; border-collapse: collapse;">Tên hội đồng</th>

            </tr>
        </thead>
        <tbody>
            <tr>
                <td style="border: 1px solid; border-collapse: collapse;">1</td>
                <td style="border: 1px solid; border-collapse: collapse;">
                    <form:select class="form-select" path="defenseCommitteeId">
                        <c:forEach items="${dc}" var="d">
                            <form:option value="${d.id}">
                                ${d.name}
                            </form:option>
                        </c:forEach>
                    </form:select>
                </td>
                <td>
                    <input class="btn-danger" type="button" onclick="deleteRow(1)" value="X"/>
                </td>
            </tr>
        </tbody>
    </table>

    <button class="btn btn-success" style="font-size: 12.5px">Xác nhận</button>
</form:form>
<script>
    
</script>