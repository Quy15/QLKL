<%-- 
    Document   : dclist
    Created on : Aug 15, 2023, 7:34:30 PM
    Author     : WIN10
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:url value="/dclist" var="action" />


<section class="container">
    <h1 class="text-center text-info mt-1">DANH SÁCH HỘI ĐỒNG</h1>

    <c:if test="${counter > 1}">
        <ul class="pagination mt-1">
            <li class="page-item"><a class="page-link" href="${action}">Tất cả</a></li>
                <c:forEach begin="1" end="${counter}" var="i">
                    <c:url value="/dclist" var="pageUrl">
                        <c:param name="page" value="${i}" />
                    </c:url>
                <li class="page-item"><a class="page-link" href="${pageUrl}">${i}</a></li>
                </c:forEach>
        </ul>
    </c:if>

    <c:url value="/thesisdefense" var="add"/>
    <div class="d-flex flex-row align-items-center justify-content-center justify-content-lg-start mt-3 mb-3">
        <a href="${add}" class="btn btn-success me-2" style="font-size: 12.5px" >Tạo hội đồng</a>      
    </div>
    <table class="table table-hover" style="font-size: 12.5px; border: 1px solid; border-collapse: collapse;">
        <thead>
            <tr>
                <th style="border: 1px solid; border-collapse: collapse;">ID</th>
                <th style="border: 1px solid; border-collapse: collapse;">Tên hội đồng</th>
                <th style="border: 1px solid; border-collapse: collapse;">Chủ tịch</th>
                <th style="border: 1px solid; border-collapse: collapse;">Thư ký</th>
                <th style="border: 1px solid; border-collapse: collapse;">Phản biện</th>
                <th style="border: 1px solid; border-collapse: collapse;">Các thành viên</th>
                <th style="border: 1px solid; border-collapse: collapse;"></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${defenselist}" var="dl">
                <tr>
                    <td style="border: 1px solid; border-collapse: collapse;" name="defensecommitteeid">${dl.id}</td>
                    <td style="border: 1px solid; border-collapse: collapse;">${dl.name}</td>
                    <td style="border: 1px solid; border-collapse: collapse;">
                        <c:forEach items="${user}" var="u">
                            <c:forEach items="${drole}" var="dr">
                                <c:forEach items="${udefense}" var="ud">
                                    <c:if test="${u.id == ud.userId.id && dr.id == ud.defenseCommitteeRoleId.id && dr.name == 'Chủ tịch' && dl.id == ud.defenseCommitteeId.id}">
                                        ${u.firstName} ${u.lastName}
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </c:forEach>
                    </td>
                    <td style="border: 1px solid; border-collapse: collapse;">
                        <c:forEach items="${user}" var="u">
                            <c:forEach items="${drole}" var="dr">
                                <c:forEach items="${udefense}" var="ud">
                                    <c:if test="${u.id == ud.userId.id && dr.id == ud.defenseCommitteeRoleId.id && dr.name == 'Thư ký' && dl.id == ud.defenseCommitteeId.id}">
                                        ${u.firstName} ${u.lastName}
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </c:forEach>
                    </td>

                    <td style="border: 1px solid; border-collapse: collapse;">
                        <c:forEach items="${user}" var="u">
                            <c:forEach items="${drole}" var="dr">
                                <c:forEach items="${udefense}" var="ud">
                                    <c:if test="${u.id == ud.userId.id && dr.id == ud.defenseCommitteeRoleId.id && dr.name == 'Phản biện' && dl.id == ud.defenseCommitteeId.id}">
                                        ${u.firstName} ${u.lastName}
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </c:forEach>
                    </td>
                    <td style="border: 1px solid; border-collapse: collapse">
                        <c:forEach items="${user}" var="u">
                            <c:forEach items="${drole}" var="dr">
                                <c:forEach items="${udefense}" var="ud">
                                    <c:if test="${u.id == ud.userId.id && dr.id == ud.defenseCommitteeRoleId.id && dr.name == 'Thành viên' && dl.id == ud.defenseCommitteeId.id}">
                                        ${u.firstName} ${u.lastName}
                                    </c:if>
                                </c:forEach>
                            </c:forEach>
                        </c:forEach>
                    </td>
                    <td style="border: 1px solid; border-collapse: collapse">
                        <c:url value="/lockdefense/${dl.id}" var="link"/>
                        <a href="${link}" class="btn btn-danger" style="font-size: 12.5px">Khóa hội đồng</a>
                    </td>
                    <td style="border: 1px solid; border-collapse: collapse">
                        <c:url value="/thesisscore/${dl.id}" var="score"/>
                        <a href="${score}" class="btn btn-info" style="font-size: 12.5px">Thiết lập khóa luận cần chấm</a>
                    </td>
                    <td style="border: 1px solid; border-collapse: collapse">
                        <c:url value="/setcriteria/${dl.id}" var="cri"/>
                        <a href="${cri}" class="btn btn-info" style="font-size: 12.5px">Thiết lập tiêu chí</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>
