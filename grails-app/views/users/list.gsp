<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName"
           value="${message(code: 'users.label', default: 'User')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-user" class="skip" tabindex="-1"><g:message
        code="default.link.skip.label" default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message
                code="default.home.label"/></a></li>
        <li><g:link class="create" action="create">
            <g:message code="default.new.label" args="[entityName]"/>
        </g:link></li>
    </ul>
</div>

<div id="list-user" class="content scaffold-list" role="main">
    <h1>
        <g:message code="default.list.label" args="[entityName]"/>
    </h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">
            ${flash.message}
        </div>
    </g:if>
    <table>
        <thead>
        <tr>
            <g:sortableColumn property="userName" title="User Name"/>
             <g:sortableColumn property="email" title="email"/>
        </tr>
        </thead>
        <tbody>
        <g:each in="${userInstanceL}" status="i" var="userInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td><g:link action="show" id="${userInstance.id}">
                    ${fieldValue(bean: userInstance, field: "userName")}
                </g:link></td>
                <td>${fieldValue(bean: userInstance, field: "email")}</td>
            </tr>
        </g:each>
        </tbody>
    </table>

    <nav>
        <ul class="pagination justify-content-start">
            <li class="page-item">
                <g:if test="${page > 0}">
                    <g:link class="btn btn-outline-secondary btn-sm" id="${page - 1}"
                            action="list">Back</g:link>
                </g:if>
            </li>
            <li class="page-item ">
                <g:if test="${next > 0}">
                    <g:link class="btn btn-outline-secondary btn-sm" id="${page + 1}"
                            action="list">Next</g:link>
                </g:if>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>