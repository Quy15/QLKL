<%-- 
    Document   : setcriteria
    Created on : Aug 27, 2023, 2:33:10 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/setcriteria/${dfe.id}" var="cr"/>
<form method="post" enctype="multipart/form-data" action="${cr}">
    <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start mt-4 mb-4">
        <p class="lead fw-normal mb-0 me-3">Danh sách khóa luận</p>
        <select name="thesisId">
            <c:forEach items="${thesis}" var="t">
                <option value="${t.id}">
                    ${t.name}
                </option>
            </c:forEach>
        </select>
    </div>
    <c:forEach items="${udc}" var="ud">
        <c:forEach items="${thesisscore}" var="thescore">
            <c:if test="${ud.id == thescore.userDefenseCommitteeId.id && ud.defenseCommitteeId.id == dfe.id}">
                <input hidden value="${thescore.id}" name="thesisScoreId"/>
            </c:if>
        </c:forEach>
    </c:forEach>

    <input hidden="hidden" value="${dfe.id}" name="defenseId"/>
    <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start mt-4 mb-4">
        <p class="lead fw-normal mb-0 me-3">Danh sách thành viên hội đồng</p>
        <select name="userId">
            <c:forEach items="${udc}" var="userd">
                <c:if test="${dfe.id == userd.defenseCommitteeId.id}">
                    <option value="${userd.id}">
                        ${userd.userId.firstName} ${userd.userId.lastName}
                    </option>
                </c:if>
            </c:forEach>
        </select>
    </div>    





    <input type="button" id="btnAddCri" class="btn-primary" onclick="addCri()" value="+"/>
    <table id="addCrit">
        <tr>
            <th>
                <p class="lead fw-normal mb-0 me-3">Các tiêu chí</p>
            </th>
        </tr>
        <tr>
            <td>
                <select name="criteriaId" id="select">
                    <c:forEach items="${criteria}" var="c">
                        <option value="${c.id}">
                            ${c.name}
                        </option>
                    </c:forEach>
                </select>
            </td>
        </tr>
    </table> 
    <button type="submit" class="btn btn-success" style="font-size: 12.5px">Xác nhận</button>
</form>
<script>
    function addCri() {
        var z = document.getElementById("addCrit").rows.length;
        var i = z - 1;
        console.log(i);
        let template = `<tr>
            <td>
                <select name="criteriaId" id="select">
    <c:forEach items="${criteria}" var="c">
                        <option value="${c.id}">
        ${c.name}
                        </option>
    </c:forEach>
                </select>
                <input class="btn-danger" id="btn-deleteCri" type="button" onclick="deleteCriteria(1)" value="X"/>
            </td>
        </tr>`;
        let table = document.getElementById("addCrit");
        table.innerHTML += template;
    }

    function deleteCriteria() {
        var deleteCri = document.getElementById("btn-deleteCri");
        deleteCri.closest("tr").remove();
    }
</script>

