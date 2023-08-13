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
            <form:form action="${action}" method="post" enctype="multipart/form-data" modelAttribute="thesisParticipant">
                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <form:select class="form-select" id="thesisI" name="thesisI" path="userId">
                            <c:forEach items="${user}" var="u">
                                <c:forEach items="${role}" var = "r">
                                    <c:if test="${r.id == u.roleId.id && r.name == 'Sinh viên'}">
                                        <option value="${u.id}">
                                            ${u.firstName} ${u.lastName}
                                        </option>
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </form:select>
                        <label class="form-label" for="form3Example3c">Sinh viên thực hiện</label>
                    </div>
                </div>
                
                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <form:select class="form-select" id="thesisI" name="thesisI" path="thesisId">
                            <c:forEach items="${thesis}" var="t">
                                        <option value="${t.id}">
                                            ${t.name}
                                        </option>
                            </c:forEach>
                        </form:select>
                        <label class="form-label" for="form3Example3c">Khóa luận tham gia</label>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>