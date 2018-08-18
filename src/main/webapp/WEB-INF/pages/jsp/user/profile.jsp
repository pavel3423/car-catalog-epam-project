<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../include/begin-html.jsp" %>
<div class="container">
    <div class="row">
        <div class="col-12">
            <div class="head-h4">
                <h4>
                    <spring:message code="User Profile"/>
                    <c:out value="${user.login }"/>
                </h4>
            </div>
        </div>
        <div class="col-md-4">
            <div class="col-12">
                <br>
                <button type="button" class="btn btn-info" data-toggle="modal"
                        data-target="#exampleModalCenter" style="width: 210px">
                    <spring:message code="To change the data"/>
                </button>
            </div>
            <div class="modal fade" id="exampleModalCenter" tabindex="-1"
                 role="dialog" aria-labelledby="exampleModalCenterTitle"
                 aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalCenterTitle">
                                <spring:message code="Editing"/>
                            </h5>
                            <button type="button" class="close" data-dismiss="modal"
                                    aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <c:url var="edit_user" value="/profile"/>
                        <form method="POST" action="${edit_user }">
                            <div class="modal-body">
                                <div class="form-group ">
                                    <label class="control-label" for="Email"><spring:message
                                            code="label.email"/></label> <input id="email" name="email"
                                                                                type="text" value="${user.email}"
                                                                                class="form-control input-md">

                                </div>

                                <div class="form-group">
                                    <label class=" control-label" for="Password"><spring:message
                                            code="label.password"/></label> <input id="password"
                                                                                   name="password" type="password"
                                                                                   placeholder="******"
                                                                                   class="form-control input-md">

                                </div>
                            </div>
                            <div class="modal-footer">

                                <button type="button" class="btn btn-secondary"
                                        data-dismiss="modal">
                                    <spring:message code="Cancel"/>
                                </button>
                                <button type="submit" name="brand" value="${brand}"
                                        class="btn btn-success">
                                    <spring:message code="Save"/>
                                </button>

                            </div>
                        </form>
                    </div>
                </div>
            </div>


            <c:if test="${moderator }">
                <div class="col-12">
                    <br> <a href="<c:url value="/editor" />"
                            class="btn btn-outline-success" style="width: 210px"><spring:message
                        code="Car Editor"/></a>
                </div>
            </c:if>

            <c:if test="${admin }">
                <div class="col-12">
                    <br> <a href="<c:url value="/editor" />"
                            class="btn btn-outline-success" style="width: 210px"><spring:message
                        code="Admin panel"/></a>
                </div>
            </c:if>
        </div>
        <div class="col-md-8">
            <br>
            <div class="alert alert-secondary" role="alert">
                <spring:message code="Email"/>
                : ${user.email }
            </div>
        </div>
    </div>
</div>
<%@ include file="../include/end-html.jsp" %>