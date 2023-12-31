<%-- 
    Document   : index
    Created on : Jul 27, 2023, 4:52:54 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="se" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:url value="/" var="action" />
<c:choose>
    <c:when test="${pageContext.request.userPrincipal == null}">
        <section id="hero" class="d-flex align-items-center">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 d-flex flex-column justify-content-center pt-4 pt-lg-0 order-2 order-lg-1" data-aos="fade-up" data-aos-delay="200">
                        <h1>Quản Lý Khóa Luận Tốt Nghiệp</h1>
                        <h2></h2>
                        <div class="d-flex justify-content-center justify-content-lg-start">
                            <a href="<c:url value="/login"/>" class="btn btn-info">Đăng Nhập</a>
                        </div>
                    </div>
                    <div class="col-lg-6 order-1 order-lg-2 hero-img" data-aos="zoom-in" data-aos-delay="200">
                        <img src="https://res.cloudinary.com/dt3oasocf/image/upload/v1691420822/logo_pikxic.png" class="img-fluid mb-5"
                             style="" width="100%"
                             alt=""/>
                    </div>
                </div>
            </div>
        </section>
    </c:when>
    <c:otherwise>

        <se:authorize access="hasAnyRole('ROLE_SV', 'ROLE_GV')">
            <h1 class="text-center text-info">Xin chào ${pageContext.request.userPrincipal.name} đến với hệ thống</h1>
            <img src="https://res.cloudinary.com/dt3oasocf/image/upload/v1691420822/logo_pikxic.png"
                 class="img-fluid " style="margin-left: 300px" width="500px" alt="Sample image"/>
        </se:authorize>

        <se:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_GVU')">
            <section class="container">
                <!--In PDF-->
                <h1 class="text-center mt-5">Xuất bản điểm tổng hợp các điểm trung bình của các thành viên</h1>
                <form method="GET" action="/QuanLyKhoaLuan/admin/pdf">
                    <select class="form-select" name="thesisId">
                        <c:forEach items="${thesis}" var="t">
                            <option value="${t.id}">
                                ${t.name}
                            </option>
                        </c:forEach>
                    </select>
                    <button type="submit" class="btn btn-info mt-3">In PDF</button>
                </form>
                <!--<a href="/QuanLyKhoaLuan/admin/pdf" class="btn btn-info mt-3">In PDF</a>-->
                <h1 class="text-center text-info mt-1">DANH SÁCH KHÓA LUẬN</h1>
                <c:if test="${counter > 1}">
                    <ul class="pagination mt-1">
                        <li class="page-item"><a class="page-link" href="${action}">Tất cả</a></li>
                            <c:forEach begin="1" end="${counter}" var="i">
                                <c:url value="/" var="pageUrl">
                                    <c:param name="page" value="${i}" />
                                </c:url>
                            <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                            </c:forEach>
                    </ul>
                </c:if>


                <table class="table table-hover" style="font-size: 12.5px; border: 1px solid; border-collapse: collapse;">
                    <thead>
                        <tr>
                            <th style="border: 1px solid; border-collapse: collapse;">ID</th>
                            <th style="border: 1px solid; border-collapse: collapse;">Tên khóa luận</th>
                            <th style="border: 1px solid; border-collapse: collapse;">Ngày tạo</th>
                            <th style="border: 1px solid; border-collapse: collapse;">Trạng thái</th>
                            <th style="border: 1px solid; border-collapse: collapse;">Sinh viên tham gia</th>
                            <th style="border: 1px solid; border-collapse: collapse;">GVHD</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${thesis}" var="t">
                            <tr>
                                <td style="border: 1px solid; border-collapse: collapse;">${t.id}</td>
                                <td style="border: 1px solid; border-collapse: collapse;">${t.name}</td>
                                <td style="border: 1px solid; border-collapse: collapse;">${t.date}</td>
                                <td style="border: 1px solid; border-collapse: collapse;">${t.status}</td>
                                <td style="border: 1px solid; border-collapse: collapse">
                                    <c:forEach items="${user}" var="u">
                                        <c:forEach items="${thesisP}" var="p">
                                            <c:if test="${u.id == p.userId.id && t.id == p.thesisId.id}">                                       
                                                ${u.firstName} ${u.lastName}     
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                </td>
                                <td style="border: 1px solid; border-collapse: collapse">
                                    <c:forEach items="${user}" var="u">
                                        <c:forEach items="${thesisI}" var="i">
                                            <c:if test="${u.id == i.userId.id && t.id == i.thesisId.id}">
                                                ${u.firstName} ${u.lastName}
                                            </c:if>
                                        </c:forEach>
                                    </c:forEach>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </section>
            <script src="<c:url value="/js/main.js"/>"></script>
        </se:authorize>
    </c:otherwise>
</c:choose>
