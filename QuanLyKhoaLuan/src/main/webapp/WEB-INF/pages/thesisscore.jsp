<%-- 
    Document   : thesisscore
    Created on : Sep 9, 2023, 8:23:59 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:url value="/thesisscore/${def.id}" var="ts"/>
<form method="post" enctype="multipart/form-data" action="${ts}">
    <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start mt-4 mb-4">
        <p class="lead fw-normal mb-0 me-3">Danh sách thành viên hội đồng</p>
        <select name="userdefenseId">
            <c:forEach items="${dc}" var="de">
                <c:forEach items="${udc}" var="udef">
                    <c:if test="${de.id == def.id && udef.defenseCommitteeId.id == def.id}">
                        <option value="${udef.id}">
                            ${udef.userId.firstName} ${udef.userId.lastName}
                        </option>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </select>
    </div>
    
    <input hidden="hidden" type="text" name="defenseId"${def.id}/>
    
    <h3 class="text-center">Khóa luận cần chấm</h3>
<!--    <input type="button" id="btnAddT" class="btn btn-primary" onclick="displayT()" value="+"/>-->
    <table class="table table-hover addThesis" style="font-size: 12.5px; " id="t">
        <tr>
            <th style="border: 1px solid; border-collapse: collapse;">Tên khóa luận</th>
        </tr>
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
    </table>

    <button type="submit" class="btn btn-success" style="font-size: 12.5px">Xác nhận</button>
</form>
<script type="text/javascript">
    function deleteRow2() {
        var d = document.getElementById("btn-delete1");
        d.closest("tr").remove();
    }
    function displayT() {
        var y = document.getElementById("t").rows.length;
        var i = y - 1;

        let temp = `<tr>
                <td style="border: 1px solid; border-collapse: collapse;">
                    <select class="form-select" name="thesisId">
    <c:forEach items="${thesis}" var="t">
                            <option value="${t.id}">
        ${t.name}
                            </option>
    </c:forEach>
                    </select>
                </td>
                <td style="border: 1px solid; border-collapse: collapse;">
                    <input class="btn-danger" id="btn-delete1" type="button" onclick="deleteRow2(1)" value="X"/>
                </td>
            </tr>
            `;
        let thesis = document.getElementById("t");
        thesis.innerHTML += temp;
        if (i > 4)
        {
            alert("Khóa luận không được quá 5");
            deleteRow2();
        }
    }

</script>