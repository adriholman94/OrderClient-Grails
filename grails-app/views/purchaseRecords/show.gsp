<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <g:set var="entityName" value="${message(code: 'purchaseRecords.label', default: 'PurchaseRecords')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-purchaseRecords" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                                      default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-purchaseRecords" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <div class="" id="head" style="margin-left: 25%; margin-right: 25%">
        <table class="table">
            <thead class="text-white color-fondo">
            <tr>
                <th>Final Price</th>
                <th>Date</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${fieldValue(bean: purchaseRecordInstance, field: "finalPrice")}</td>
                <td>${fieldValue(bean: purchaseRecordInstance, field: "date")}</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="jumbotron" id="detail" style="margin-left: 25%; margin-right: 25%">
        <table class="table">
            <thead class="text-white color-fondo">
            <tr>
                <th>Product</th>
                <th>Supplier</th>
                <th>Unit Price</th>
                <th>Quantity</th>
                <th>Quantity Price</th>
            </tr>
            </thead>
            <tbody>
            <g:each in="${purchaseRecordDetailInstance}" status="i" var="detailInstance">
                <tr>
                    <td>${fieldValue(bean: detailInstance, field: "product.productName")}</td>
                    <td>${fieldValue(bean: detailInstance, field: "supplier.supplierName")}</td>
                    <td>${fieldValue(bean: detailInstance, field: "unitPrice")}</td>
                    <td>${fieldValue(bean: detailInstance, field: "productQuantity")}</td>
                    <td>${fieldValue(bean: detailInstance, field: "totalPrice")}</td>
                </tr>
            </g:each>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
