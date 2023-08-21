<%-- 
    Document   : thesisParticipant
    Created on : Aug 13, 2023, 11:02:39 AM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>



<div class="card-body p-md-5">
    <div class="row justify-content-center">
        <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
            <c:url value="/thesisParticipant" var="action"/>

            <%--@elvariable id="thesisP" type="antlr"--%>

            <div class="d-flex flex-row align-items-center mb-4">
                <div class="form-outline flex-fill mb-0">
                    <select id ="sv1" class="form-select" name="sv1">
                        <c:forEach items="${user}" var="u">
                            <c:if test="${u.userRole == 'ROLE_SV'}">
                                <option value="${u.id}">
                                    ${u.firstName} ${u.lastName}
                                </option>
                            </c:if>
                        </c:forEach>
                    </select>

                    <label class="form-label" for="form3Example3c">Sinh viên thực hiện</label>
                </div>
            </div>

            <div class="d-flex flex-row align-items-center mb-4">
                <div class="form-outline flex-fill mb-0">
                    <select id="sv2" class="form-select" name="sv2">
                        <c:forEach items="${user}" var="u">
                            <c:if test="${u.userRole == 'ROLE_SV'}">
                                <option value="${u.id}">
                                    ${u.firstName} ${u.lastName}
                                </option>
                            </c:if>
                        </c:forEach>
                    </select>

                    <label class="form-label" for="form3Example3c">Sinh viên thực hiện</label>
                </div>
            </div>

            <div class="d-flex flex-row align-items-center mb-4">
                <div class="form-outline flex-fill mb-0">
                    <select class="form-select" id="thesisid" name="thesisid">
                        <c:forEach items="${the}" var="t">
                            <option value="${t.id}">
                                ${t.name}
                            </option>
                        </c:forEach>
                    </select>

                    <label class="form-label" for="form3Example3c">Khóa luận tham gia</label>
                </div>
            </div>

            <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                <button onclick="save()" class="btn btn-primary btn-success" style="width: 100%">
                    Tiếp tục
                </button>
            </div>    

        </div>
    </div>
</div>
<script src="<c:url value="/js/main.js"/>"></script>
