<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'categories.label', default: 'Categories')}"/>
    <title><g:message code="default.edit.label" args="[entityName]"/></title>
</head>

<body>
<a href="#edit-categories" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                 default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <sec:ifNotLoggedIn>
        <a href="/login" class="">Login</a>
    </sec:ifNotLoggedIn>
    <sec:ifLoggedIn>
        <a>Hello, ${sec.username()}</a>
        <a href="/logout" class="">Logout</a>
    </sec:ifLoggedIn>
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>

</div>

<div id="edit-categories" class="content scaffold-edit" role="main">
    <h1><g:message code="default.edit.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <g:hasErrors bean="${categoryInstance}">
        <ul class="errors" role="alert">
            <g:eachError bean="${categoryInstance}" var="error">
                <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message
                        error="${error}"/></li>
            </g:eachError>
        </ul>
    </g:hasErrors>
    <g:form action="update">
        <fieldset class="form">
            <g:render template="form"/>
        </fieldset>
        <fieldset class="buttons">
            <button type="submit" class="btn btn-outline-secondary btn-sm" name="id" value="${categoryInstance?.id}">
                Update
            </button>
        </fieldset>
    </g:form>
</div>
</body>
</html>
