<%-- 
    Document   : login
    Created on : Aug 7, 2023, 8:44:30 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<section class="vh-100">
    <div class="container-fluid h-custom">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-md-9 col-lg-6 col-xl-5">
                <img src="https://res.cloudinary.com/dt3oasocf/image/upload/v1691420822/logo_pikxic.png"
                     class="img-fluid" alt="Sample image">
            </div>
            <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                <c:url value="/login" var="action"/>
                <form method="post" action="${action}" >
                    <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start">
                        <p class="lead fw-normal mb-0 me-3">Đăng nhập hệ thống</p>
                    </div>
                    <div class="divider d-flex align-items-center my-4">
                        <p class="text-center fw-bold mx-3 mb-0"></p>
                    </div>

                
                    <div class="form-outline mb-4">
                        <input type="text" id="form3Example3" class="form-control form-control-lg"
                               placeholder="Nhập tài khoản" name="username"/>
                        <label class="form-label" for="form3Example3">Tài khoản</label>
                    </div>

                 
                    <div class="form-outline mb-3">
                        <input type="password" id="form3Example4" class="form-control form-control-lg"
                               placeholder="Nhập mật khẩu" name="password"/>
                        <label class="form-label" for="form3Example4">Mật khẩu</label>
                    </div>

                    <div class="d-flex justify-content-between align-items-center">
                        <a href="#!" class="text-body">Quên password?</a>
                    </div>

                    <div class="text-center text-lg-start mt-4 pt-2">
                        <button type="submit" class="btn btn-primary btn-lg"
                                style="padding-left: 2.5rem; padding-right: 2.5rem;">
                            Đăng nhập
                        </button>
                        <p class="small fw-bold mt-2 pt-1 mb-0">
                            Chưa có tài khoản? <a href="<c:url value="/register"/>"
                                                  class="link-danger">Đăng ký ngay</a>
                        </p>
                    </div>

                </form>
            </div>
        </div>
    </div>
</section>
