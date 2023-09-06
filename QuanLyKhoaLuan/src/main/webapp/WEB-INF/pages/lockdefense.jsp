<%-- 
    Document   : lockdefense
    Created on : Sep 4, 2023, 6:53:00 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/lockdefense/${defense.id}" var="action"/>
<div class="card-body p-md-5">
    <div class="row justify-content-center">
        <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
            <h1 class="text-center mb-10">Khóa hội đồng</h1>
            <form action="${action}" method="post" enctype="multipart/form-data" >
                <input type="text" hidden="hidden" name="defenseId" value="${defense.id}"/>
                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <input type="text" class="form-control" id="name" placeholder="Tên hội đồng" name="name" value="${defense.name}"/>
                        <label class="form-label" for="form3Example1c">Tên hội đồng</label>
                    </div>
                </div>

                <div class="form-outline flex-fill mb-0">
                    <c:forEach items="${udc}" var="user">
                        <c:forEach items="${thesisscore}" var="sc">
                            <c:forEach items="${thesis}" var="kluan">
                                <c:if test="${user.defenseCommitteeId.id == defense.id &&
                                              user.id == sc.userDefenseCommitteeId.id &&
                                              sc.thesisId.id == kluan.id && sc.score != null}">
                                      <input hidden type="text" class="form-control" id="name" placeholder="Tên hội đồng" name="thesisid" value="${kluan.id}"/>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </c:forEach>
                </div>
                <div class="form-outline flex-fill mb-0">
                    <c:forEach items="${user}" var="nd">
                        <c:forEach items="${thesis}" var="khoaluan">
                            <c:forEach items="${thesisP}" var="tp">
                                <c:if test="${tp.userId.id == nd.id && tp.thesisId.id == khoaluan.id && khoaluan.status == 'Đã thực hiện'}">
                                    <input hidden type="text" name="userId" value="${nd.id}"/>
                                </c:if>
                            </c:forEach>
                        </c:forEach>
                    </c:forEach>
                </div>

                <div class="form-outline flex-fill mb-0">
                    <c:forEach items="${udc}" var="ud">
                        <c:if test="${ud.defenseCommitteeId.id == defense.id}">
                            <input hidden type="text" class="form-control"  id="name" placeholder="Tên hội đồng" name="userdefenseid" value="${ud.id}"/>
                        </c:if>
                    </c:forEach>
                </div>

                <div class="form-outline flex-fill mb-0">
                    <c:forEach items="${thesisscore}" var="ts">
                        <c:forEach items="${udc}" var="udc">
                            <c:if test="${ts.userDefenseCommitteeId.id == udc.id && udc.defenseCommitteeId.id == defense.id}">
                                <input hidden type="text" class="form-control"  id="name" placeholder="Tên hội đồng" name="thesisscoreid" value="${ts.id}"/>
                            </c:if>
                        </c:forEach>
                    </c:forEach>
                </div>

                <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <button type="submit" class="btn btn-primary btn-danger" style="width: 100%">
                        Khóa hội đồng
                    </button>
                </div> 
            </form>
        </div>
    </div>
</div>      
