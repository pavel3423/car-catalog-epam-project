<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ include file="../include/begin-html.jsp" %>

<br>
<c:if test="${msg!=null}">
    <div class="alert alert-danger" role="alert">
        <c:out value="${msg}"></c:out>
    </div>
</c:if>

<form class="form-horizontal col-md-4" method="post" action="login">

    <legend>
        Login
    </legend>

    <fieldset>
        <div class="form-group ">
            <label class="control-label" for="login">
                login:</label>
            <input class="form-control input-md" id="login" placeholder="login"/>
        </div>
        <div class="form-group ">
            <label class="control-label" for="password">
                password:</label>
            <input class="form-control input-md" id="password" type="password" maxlength="25" size="40" name="password"
                   placeholder="******">
        </div>

    </fieldset>
    <div class="form-group ">
        <input class="btn btn-success" type="submit"
               value="Login"/>
    </div>
</form>

<%@ include file="../include/end-html.jsp" %>