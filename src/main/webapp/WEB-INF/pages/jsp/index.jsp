<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>

<div class="container">
    <div class="row">
        <div class="col-md-12">
            <br> ${error }
        </div>
        <c:forEach items="${brands}" var="brand">
            <div class=" col-md-3">
                <div class="card">
                    <div class="imageBrand">

                    </div>

                    <div class="card-body" align="center">
                        <a href="${brand.brand}" class="btn btn-outline-info">${brand.brand}</a>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


<%@ include file="include/end-html.jsp" %>