<%-- 
    Document   : infouser
    Created on : Aug 17, 2023, 7:00:17 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<section style="background-color: #eee;">
    <div class="container py-5">
        <div class="row">
            <div class="col">
                <nav aria-label="breadcrumb" class="bg-light rounded-3 p-3 mb-4">
                    <ol class="breadcrumb mb-0">
                        <li class="breadcrumb-item"><span style="color: black; font-size: 30px">Thông tin người dùng</span></li>
                    </ol>
                </nav>
            </div>
        </div>
        <c:forEach items="${userinfor}" var="info">
            <c:if test="${info.username == name}">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="card mb-4">

                            <div class="card-body text-center">
                                <img src="${info.avatar}" alt="avatar"
                                     class="rounded-circle img-fluid" style="width: 150px;">
                                <h5 class="my-3">${info.firstName} ${info.lastName}</h5>
                                <p hidden class="text-muted mb-1">Full Stack Developer</p>
                                <p hidden class="text-muted mb-4">Bay Area, San Francisco, CA</p>
                            </div>
                        </div>

                    </div>
                    <div class="col-lg-8">
                        <div class="card mb-4">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">ID</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">${info.id}</p>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Họ tên</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">${info.firstName} ${info.lastName}</p>
                                    </div>
                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Tài khoản</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <p class="text-muted mb-0">${info.username}</p>
                                    </div>
                                </div>
                                <hr>

                                <div class="row">
                                    <div class="col-sm-3">
                                        <p class="mb-0">Khoa</p>
                                    </div>
                                    <div class="col-sm-9">
                                        <c:forEach items="${major}" var="m">
                                            <c:if test="${m.id == info.majorId.id}">
                                                <p class="text-muted mb-0">${m.name}</p>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </div>
                                <hr/>
                                <div class="row">
                                    <div class="col-sm-3">
                                        <a href="<c:url value="/infouser/${info.id}"/>" class="btn btn-info">Đổi mật khẩu</a>
                                    </div>                                   
                                </div>
                            </div>
                        </div>
                    </c:if>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</div>
</section>
