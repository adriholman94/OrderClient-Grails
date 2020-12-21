
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'product.label', default: 'products')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-products" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                               default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-products" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list products">
        <li class="fieldcontain">
            <label id="firstName-label" class="property-label">Product Name:</label>

            <div class="property-value"
                 aria-labelledby="productName-label">${fieldValue(bean: productInstance, field: "productName")}</div>
        </li>
        <li class="fieldcontain">
            <label id="firstName-label" class="property-label">Product Price:</label>

            <div class="property-value"
                 aria-labelledby="productPrice-label">${fieldValue(bean: productInstance, field: "productPrice")}</div>
        </li>
        <li class="fieldcontain">
            <label id="category-label" class="property-label">Category:</label>

            <div class="property-value"
                 aria-labelledby="category-label">${fieldValue(bean: productInstance, field: "category.categoryName")}</div>
        </li>
    </ol>
    <g:form method="DELETE">
        <fieldset class="buttons">
            <g:hiddenField name="id" value="${productInstance?.id}"/>
            <g:link class="btn btn-outline-secondary btn-sm" action="edit" id="${productInstance?.id}">
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
