<%-- 
    Document   : changepassword
    Created on : Aug 17, 2023, 8:07:46 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="card-body p-md-5">
    <div class="row justify-content-center">
        <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
            <p class="text-center text-success">[[${s.message}]]</p>
            <h2 class="text-center text-info">Đổi mật khẩu</h2>
            <form enctype="multipart/form-data" action="/changepassword" method="post">

                <div class="form-outline mb-4">
                    <input type="password" id="oldpassword" class="form-control" name="oldpassword"/>
                    <label class="form-label" for="form1Example1">Mật khẩu cũ</label>
                </div>


                <div class="form-outline mb-4">
                    <input type="password" id="newpassword" class="form-control" name="newpassword"/>
                    <label class="form-label" for="form1Example2">Mật khẩu mới</label>
                </div>

                <button type="submit" class="btn btn-primary btn-block">Xác nhận</button>
            </form>
        </div>
    </div>
</div>