<%-- 
    Document   : instructorThesis
    Created on : Aug 13, 2023, 11:03:14 AM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="card-body p-md-5">
    <div class="row justify-content-center">
        <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
            <c:url value="/instructorThesis" var="action"/>
            <%--@elvariable id="instructorThesis" type="antlr"--%>
            <input type="button" id="addI" class="btn btn-primary" onclick="addI()" value="+"/>
            <form method="post" enctype="multipart/form-data" action="${action}">
                <table class="table table-hover addUser" style="font-size: 12.5px;" id="thesisi">
                    <tr>
                        <th>Tên giáo viên hướng dẫn</th>
                        <th></th>
                    </tr>
                    <tr id="index">
                        <td>
                            <select class="form-select" name="gvId">
                                <c:forEach items="${user}" var="u">
                                    <c:if test="${u.userRole == 'ROLE_GV'}">
                                        <option value="${u.id}">
                                            ${u.firstName} ${u.lastName}
                                        </option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                </table>

                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <select class="form-select" name="thesisid2">
                            <c:forEach items="${t}" var="t">
                                <option value="${t.id}">
                                    ${t.name}
                                </option>
                            </c:forEach>
                        </select>
                        <label class="form-label" for="form3Example3c">Khóa luận tham gia</label>
                    </div>
                </div>
                <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <button  class="btn btn-primary btn-success" style="width: 100%">
                        Xác nhận
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
<script>
    function addI() {
        var x = document.getElementById("thesisi").rows.length;
        var index = x - 1;
        console.log(index);
        let template = `<tr id="index">
                        <td>
                            <select class="form-select" name="gvId">
    <c:forEach items="${user}" var="u">
        <c:if test="${u.userRole == 'ROLE_GV'}">
                                        <option value="${u.id}">
            ${u.firstName} ${u.lastName}
                                        </option>
        </c:if>
    </c:forEach>
                            </select>
                        </td>
                                        <td>
                <input class="btn-danger" id="deleteI" type="button" onclick="deleteIT(1)" value="X"/>
            </td>

                    </tr>`;
        let table = document.getElementById("thesisi");
        table.innerHTML += template;
        if (index > 1)
        {
            alert("Giáo viên hướng dẫn khóa luận không được quá 2");
            deleteIT();
        }

    }

    function deleteIT() {
        var d = document.getElementById("deleteI");
        d.closest("tr").remove();
    }
</script>