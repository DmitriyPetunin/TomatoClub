<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:mainLayout title="Register page">
    <form id="loginForm" class="form-horizontal" action="<c:url value="/register"/>" method="POST">
        <div class="form-group">
            <label class="control-label col-sm-3" for="name">Name</label>
            <div class="controls col-sm-9">
                <input id="name" name="name" class="form-control" type="text" value=""/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="email">E-mail</label>
            <div class="controls col-sm-9">
                <input id="email" name="email" class="form-control" type="text" value=""/>
            </div>
        </div>
        <div class="form-group">
            <label class="control-label col-sm-3" for="password">Password</label>
            <div class="controls col-sm-9">
                <input id="password" name="password" class="form-control" type="password" value=""/>
            </div>
        </div>
        <button type="submit" class="btn btn-success">Sign in</button>
    </form>
</t:mainLayout>
