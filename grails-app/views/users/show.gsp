<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'user.label', default: 'users')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-users" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                               default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-users" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list users">
        <li class="fieldcontain">
            <label id="firstName-label" class="property-label">User Name:</label>

            <div class="property-value"
                 aria-labelledby="userName-label">${fieldValue(bean: userInstance, field: "userName")}</div>
        </li>

        <li class="fieldcontain">
            <label id="role-label" class="property-label">Role:</label>

            <div class="property-value"
                 aria-labelledby="role-label">${fieldValue(bean: userInstance, field: "role.roleName")}</div>
        </li>
    </ol>
    <g:form method="DELETE">
        <fieldset class="buttons">
            <g:hiddenField name="id" value="${userInstance?.id}"/>
            <g:link class="btn btn-outline-secondary btn-sm" action="edit" id="${userInstance?.id}">
                Edit
            </g:link>
            <g:actionSubmit class="btn btn-outline-secondary btn-sm" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}" formnovalidate=""
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
