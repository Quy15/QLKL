<%-- 
    Document   : defenseuser
    Created on : Aug 13, 2023, 1:55:42 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url value="/defenseuser" var="de"/>

<h3 class="text-center">Thành viên khóa luận</h3>

<!--    <input type="button" id="btnAdd" class="btn btn-primary" onclick="display()" value="+"/>-->
<form method="post" enctype="multipart/form-data" action="${de}">
    <table class="table table-hover addUser" style="font-size: 12.5px;" id="defenseuser">
        <tr>
            <th style="border: 1px solid; border-collapse: collapse;">Tên giáo viên</th>
            <th style="border: 1px solid; border-collapse: collapse;">Vai trò</th>
            <!--            <td style="border: 1px solid; border-collapse: collapse;"></td>-->
        </tr>
        <tr id="index">
            <td style="border: 1px solid; border-collapse: collapse;">
                <select class="form-select" name="userId">
                    <c:forEach items="${user}" var="u">
                        <c:if test="${u.userRole == 'ROLE_GV'}">
                            <option value="${u.id}">
                                ${u.firstName} ${u.lastName}
                            </option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td style="border: 1px solid; border-collapse: collapse">
                <select class="form-select" name="defenseCommitteeRoleId">
                    <c:forEach items="${drole}" var="dr">
                        <option value="${dr.id}">
                            ${dr.name}
                        </option>
                    </c:forEach>
                </select>
            </td>
            <!--            <td style="border: 1px solid; border-collapse: collapse">
                            <input class="btn-danger" id="btn-delete" type="button" onclick="deleteRow(1)" value="X"/>
                        </td>-->
        </tr>
        <tr id="index">
            <td style="border: 1px solid; border-collapse: collapse;">
                <select class="form-select" name="userId2">
                    <c:forEach items="${user}" var="u">
                        <c:if test="${u.userRole == 'ROLE_GV'}">
                            <option value="${u.id}">
                                ${u.firstName} ${u.lastName}
                            </option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td style="border: 1px solid; border-collapse: collapse">
                <select class="form-select" name="defenseCommitteeRoleId2">
                    <c:forEach items="${drole}" var="dr">
                        <option value="${dr.id}">
                            ${dr.name}
                        </option>
                    </c:forEach>
                </select>
            </td>
            <!--            <td style="border: 1px solid; border-collapse: collapse">
                            <input class="btn-danger" id="btn-delete" type="button" onclick="deleteRow(1)" value="X"/>
                        </td>-->
        </tr>
        <tr id="index">
            <td style="border: 1px solid; border-collapse: collapse;">
                <select class="form-select" name="userId3">
                    <c:forEach items="${user}" var="u">
                        <c:if test="${u.userRole == 'ROLE_GV'}">
                            <option value="${u.id}">
                                ${u.firstName} ${u.lastName}
                            </option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td style="border: 1px solid; border-collapse: collapse">
                <select class="form-select" name="defenseCommitteeRoleId3">
                    <c:forEach items="${drole}" var="dr">
                        <option value="${dr.id}">
                            ${dr.name}
                        </option>
                    </c:forEach>
                </select>
            </td>
            <!--            <td style="border: 1px solid; border-collapse: collapse">
                            <input class="btn-danger" id="btn-delete" type="button" onclick="deleteRow(1)" value="X"/>
                        </td>-->
        </tr>
        <tr id="index">
            <td style="border: 1px solid; border-collapse: collapse;">
                <select class="form-select" name="userId4">
                    <c:forEach items="${user}" var="u">
                        <c:if test="${u.userRole == 'ROLE_GV'}">
                            <option value="${u.id}">
                                ${u.firstName} ${u.lastName}
                            </option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td style="border: 1px solid; border-collapse: collapse">
                <select class="form-select" name="defenseCommitteeRoleId4">
                    <c:forEach items="${drole}" var="dr">
                        <option value="${dr.id}">
                            ${dr.name}
                        </option>
                    </c:forEach>
                </select>
            </td>
            <!--            <td style="border: 1px solid; border-collapse: collapse">
                            <input class="btn-danger" id="btn-delete" type="button" onclick="deleteRow(1)" value="X"/>
                        </td>-->
        </tr>
        <tr id="index">
            <td style="border: 1px solid; border-collapse: collapse;">
                <select class="form-select" name="userId5">
                    <c:forEach items="${user}" var="u">
                        <c:if test="${u.userRole == 'ROLE_GV'}">
                            <option value="${u.id}">
                                ${u.firstName} ${u.lastName}
                            </option>
                        </c:if>
                    </c:forEach>
                </select>
            </td>
            <td style="border: 1px solid; border-collapse: collapse">
                <select class="form-select" name="defenseCommitteeRoleId5">
                    <c:forEach items="${drole}" var="dr">
                        <option value="${dr.id}">
                            ${dr.name}
                        </option>
                    </c:forEach>
                </select>
            </td>
            <!--            <td style="border: 1px solid; border-collapse: collapse">
                            <input class="btn-danger" id="btn-delete" type="button" onclick="deleteRow(1)" value="X"/>
                        </td>-->
        </tr>
    </table>

    <h3 class="text-center">Hội đồng tham gia</h3>
    <table class="table table-hover addThesis" style="font-size: 12.5px; " id="t">
        <thead>
            <tr>
                <th style="border: 1px solid; border-collapse: collapse;">Tên hội đồng</th>
            </tr>
        </thead>
        <tbody>
            <tr>
                <td style="border: 1px solid; border-collapse: collapse;">
                    <select class="form-select" name="defenseCommitteeId">
                        <c:forEach items="${dc}" var="d">
                            <option value="${d.id}">
                                ${d.name}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
        </tbody>
    </table>

    <!--    <h3 class="text-center">Khóa luận cần chấm</h3>
        <table class="table table-hover addThesis" style="font-size: 12.5px; " id="t">
            <thead>
                <tr>
                    <th style="border: 1px solid; border-collapse: collapse;">Tên khóa luận</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td style="border: 1px solid; border-collapse: collapse;">
                        <select class="form-select" name="thesisId">
    <c:forEach items="${thesis}" var="t">
        <option value="${t.id}">
        ${t.name}
    </option>
    </c:forEach>
</select>
</td>
</tr>
</tbody>
</table>-->

    <button type="submit" class="btn btn-success" style="font-size: 12.5px">Xác nhận</button>
</form>
<script>
    function display(){
    var x = document.getElementById("defenseuser").rows.length - 1;
    var index;
    window.index = x + 1;
    let template = `<tr id="index">
            <td style="border: 1px solid; border-collapse: collapse;">
                <select class="form-select" name="userIdindex">
    <c:forEach items="${user}" var="u">
        <c:if test="${u.userRole == 'ROLE_GV'}">
                            <option value="${u.id}">
            ${u.firstName} ${u.lastName}
                            </option>
        </c:if>
    </c:forEach>
                </select>
            </td>
            <td style="border: 1px solid; border-collapse: collapse">
                <select class="form-select" name="defenseCommitteeRoleIdindex">
    <c:forEach items="${drole}" var="dr">
                        <option value="${dr.id}">
        ${dr.name}
                        </option>
    </c:forEach>
                </select>
            </td>
            <td style="border: 1px solid; border-collapse: collapse">
                <input class="btn-danger" id="btn-delete" type="button" onclick="deleteRow(1)" value="X"/>
            </td>
        </tr>
                    `;
    let table = document.getElementById("defenseuser");
    table.innerHTML += template;
    }

    function deleteRow(){
    var d = document.getElementById("btn-delete");
    d.closest("tr").remove();
    }
</script>
