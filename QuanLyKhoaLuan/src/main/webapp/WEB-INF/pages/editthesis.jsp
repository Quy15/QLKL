<%-- 
    Document   : editthesis
    Created on : Sep 5, 2023, 8:41:05 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="card-body p-md-5">
    <div class="row justify-content-center">
        <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
            <h1 class="text-center mb-10">Quản lý khóa luận</h1>
            <c:url value="/editthesis" var="action"/>
            <form:form id="sample-form" method="post" action="${action}" modelAttribute="the" enctype="multipart/form-data">
                <form:errors path="*" element="div" cssClass="alert alert-danger"/>
                <form:hidden path="id" />
                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <form:input type="text" class="form-control" path="name" id="name" placeholder="Tên khóa luận" name="name"/>
                        <label class="form-label" for="form3Example1c">Tên khóa luận</label>
                        <form:errors path="name" element="div" cssClass="text-danger"/>
                    </div>
                </div>

                <div class="d-flex flex-row align-items-center mb-4">

                    <div class="form-outline flex-fill mb-0">
                        <form:input type="date" class="form-control" path="date" id="date" placeholder="Ngày thực hiện" name="date"/>
                        <label class="form-label" for="form3Example1c">Ngày thực hiện</label>
                    </div>
                </div>

                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <c:choose>
                            <c:when test="${thesiss.id != null}">
                                <form:select class="form-select" path="status" id="status" placeholder="Trạng thái" name="status">
                                    <option value="${thesiss.status}">${thesiss.status}</option>
                                </form:select>
                            </c:when>
                            <c:otherwise>
                                <form:select class="form-select" path="status" id="status" placeholder="Trạng thái" name="status">
                                    <option value="Sắp thực hiện">Sắp thực hiện</option>
                                    <option value="Đang thực hiện">Đang thực hiện</option>
                                    <option value="Đã thực hiện">Đã thực hiện</option>
                                </form:select>
                            </c:otherwise>
                        </c:choose>

                        <%--<form:errors path="status" element="div" cssClass="text-danger"/>--%>
                        <label class="form-label" for="form3Example3c">Trạng thái</label>
                    </div>
                </div>
                <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                    <button type="submit" class="btn btn-primary btn-success" style="width: 100%">
                        <c:choose>
                            <c:when test="${the.id != null}">Cập nhật khóa luận</button></c:when>
                            <c:otherwise>Thêm</c:otherwise>
                        </c:choose>
                    </button>
                </div>    
            </form:form>
        </div>
    </div>
</div>


