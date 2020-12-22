<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName"
           value="${message(code: 'products.label', default: 'Product')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-product" class="skip" tabindex="-1"><g:message
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

<div id="list-product" class="content scaffold-list" role="main">
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
            <g:sortableColumn property="productName" title="Name"/>
            <g:sortableColumn property="productPrice" title="Price"/>
            <th>Category</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${productInstanceL}" status="i" var="productInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
                <td>
                    <g:link action="show" id="${productInstance.id}">
                        ${fieldValue(bean: productInstance, field: "productName")}
                    </g:link>
                </td>
                <td>
                    <g:link action="show" id="${productInstance.id}">
                        ${fieldValue(bean: productInstance, field: "productPrice")}
                    </g:link>
                </td>
                <td>
                    ${fieldValue(bean: productInstance, field: "category.categoryName")}
                </td>
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