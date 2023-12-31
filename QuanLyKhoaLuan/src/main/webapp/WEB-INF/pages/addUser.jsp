<%-- 
    Document   : register
    Created on : Aug 7, 2023, 10:04:36 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="card-body p-md-5">
    <div class="row justify-content-center">
        <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">

            <c:url value="/addUser" var="action"/>
            <form:form method="post" action="${action}" enctype="multipart/form-data" modelAttribute="user1">
                <form:hidden path="id" />
                <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                    <p class="lead fw-normal mb-0 me-3">Đăng ký tài khoản</p>
                </div>
                <div class="divider d-flex align-items-center my-4">
                    <p class="text-center fw-bold mx-3 mb-0"></p>
                </div>


                <div class="form-outline mb-4">
                    <form:input type="text" id="form3Example3" class="form-control form-control-lg"
                                placeholder="Nhập họ" name="firstName" path="firstName"/>
                    <label class="form-label" for="form3Example3">Họ</label>
                </div>


                <div class="form-outline mb-3">
                    <form:input type="text" id="form3Example4" class="form-control form-control-lg"
                                placeholder="Nhập tên" name="lastName" path="lastName"/>
                    <label class="form-label" for="form3Example4">Tên</label>
                </div>

                <div class="form-outline mb-4">
                    <form:input type="text" id="form3Example3" class="form-control form-control-lg"
                                placeholder="Nhập tài khoản" name="username" path="username"/>
                    <label class="form-label" for="form3Example3">Tài khoản</label>
                </div>


                <div class="form-outline mb-3">
                    <form:input type="password" id="form3Example4" class="form-control form-control-lg"
                                placeholder="Nhập mật khẩu" name="password" path="password"/>
                    <label class="form-label" for="form3Example4">Mật khẩu</label>
                </div>

                <div class="form-outline mb-3">
                    <form:input type="file" accept="image/png" id="form3Example4" class="form-control form-control-lg"
                                name="avatar" path="file"/>
                    <label class="form-label" for="form3Example4">Avatar</label>
                    <c:if test="${user1.avatar != null}">
                        <img src="${user1.avatar}" width="120" />
                    </c:if>
                </div>   

                <div class="form-outline mb-3">
                    <form:input type="email" id="form3Example4" class="form-control form-control-lg"
                                placeholder="Nhập email" name="email" path="email"/>
                    <label class="form-label" for="form3Example4">Email</label>
                </div>

                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <form:select class="form-select" id="major" name="major" path="majorId">
                            <c:forEach items="${major}" var="m" >
                                <c:choose>
                                    <c:when test="${m.id == user1.majorId.id}">                        
                                        <option value="${m.id}" selected="selected">
                                            ${m.name}
                                        </option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="${m.id}">
                                            ${m.name}
                                        </option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </form:select>

                        <label class="form-label" for="form3Example3c">Ngành học</label>
                    </div>
                </div>

                <div class="d-flex flex-row align-items-center mb-4">
                    <div class="form-outline flex-fill mb-0">
                        <form:input type="text" id="form3Example3" class="form-control form-control-lg"
                                    placeholder="Nhập vai trò ROLE_GV, ROLE_GVU, ROLE_SV" name="role" path="userRole"/>
                        <label class="form-label" for="form3Example3c">Vai trò</label>
                    </div>
                </div>

                <div class="text-center text-lg-start mt-4 pt-2">
                    <button type="submit" class="btn btn-primary btn-success" style="width: 100%">
                        <c:choose>
                            <c:when test="${user1.id != null}">Cập nhật người dùng</button></c:when>
                        <c:otherwise>Thêm</c:otherwise>
                    </c:choose>
                    </button>
                </div>
            </form:form>
        </div>
    </div>
</div>

