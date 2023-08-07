<%-- 
    Document   : thesisManager
    Created on : Jul 31, 2023, 7:59:35 PM
    Author     : WIN10
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section class="vh-100" style="background-color: #eee;">
    <div class="card-body p-md-5">
        <div class="row justify-content-center">
            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                <h1 class="text-center mb-10">Thêm khóa luận</h1>
                <c:url value="/thesisManager" var="action"/>
                <form:form method="post" action="${action}" modelAttribute="thesis" enctype="accept-charset: utf-8">
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
                            <form:input type="text" class="form-control" path="date" id="date" placeholder="Ngày thực hiện" name="date"/>
                            <label class="form-label" for="form3Example1c">Ngày thực hiện</label>
                        </div>
                    </div>

                    <div class="d-flex flex-row align-items-center mb-4">

                        <div class="form-outline flex-fill mb-0">
                            <form:input type="text" class="form-control" path="status" id="status" placeholder="Trạng thái" name="status"/>
                            <label class="form-label" for="form3Example3c">Trạng thái</label>
                            <form:errors path="status" element="div" cssClass="text-danger"/>
                        </div>
                    </div>
                    <!--                    <div class="d-flex flex-row align-items-center mb-4">
                    
                                            <div class="form-outline flex-fill mb-0">
                                                <input type="text" id="form3Example3c" class="form-control" name="" />
                                                <label class="form-label" for="form3Example3c">Sinh viên thực hiện</label>
                                            </div>
                                        </div>-->
                    <div class="d-flex justify-content-center mx-4 mb-3 mb-lg-4">
                        <button type="submit" class="btn btn-primary btn-success" style="width: 100%">
                         <c:choose>
                            <c:when test="${thesis.id != null}">Cập nhật khóa luận</button></c:when>
                            <c:otherwise>Thêm</c:otherwise>
                        </c:choose>
                        </button>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</section>

