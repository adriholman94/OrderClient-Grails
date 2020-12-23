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
            <td><g:textField id="finalPrice" name="finalPrice" maxlength="50" required="" class="form-control"
                             value="${purchaseRecordInstance?.finalPrice}"/></td>
            <td><g:textField name="date" required="" data-date-format="dd/mm/yyyy" id="date"
                             value="${formatDate(format: 'dd/MM/yyyy', date: purchaseRecordInstance?.date)}"
                             class="form-control datepicker"
                             pattern="(?:(?:0[1-9]|1[0-9]|2[0-9])/(?:0[1-9]|1[0-2])|(?:(?:30)/(?!02)(?:0[1-9]|1[0-2]))|(?:31/(?:0[13578]|1[02])))/(?:19|20)[0-9]{2}"
                             title="dd/mm/yyyy"/></td>
        </tr>
        </tbody>
    </table>
</div>

<div class="detail">
    <button id="add" class="btn btn-outline-secondary btn-sm" type="button">Add</button>
<g:hiddenField name="rowCount" value="0" id="rowCount"/>
<table class="table" id="details">
    <thead class="text-white color-fondo">
    <tr>
        <th>Product</th>
        <th>Supplier</th>
        <th>Unit Price</th>
        <th>Quantity</th>
        <th>Quantity Price</th>
    </tr>
    </thead>
    <tbody id="table-details">
    <g:each in="${purchaseRecordInstance.purchaseRecordDetails}" status="i" var="details">
        <tr>
            <g:hiddenField labelFor="id" name="detailId"
                           inputMaxLength="10" value="${details?.id}"/>
            <td><g:select name="productId" from="${products}" optionKey="id"
                          optionValue="productName" required=""
                          value="${details?.product?.id}"
                          class="many-to-one form-control product"/></td>
            <td><g:select name="supplierId" from="${suppliers}" optionKey="id"
                          optionValue="supplierName" required=""
                          value="${details?.supplier?.id}"
                          class="many-to-one form-control supplier"/></td>
            <td><g:textField style="width: 100px" name="unitPrice" maxlength="50" required=""
                             value="${details?.unitPrice}" class="form-control unitPrice"
                             readonly="true"/></td>
            <td><g:textField style="width: 50px" name="productQuantity" maxlength="50" required=""
                             value="${details?.productQuantity}" class="form-control productQuantity" pattern="[0-9]*"
                             title="Must not be a negative number"/></td>
            <td><g:textField style="width: 100px" name="totalPrice" maxlength="50" required=""
                             value="${details?.totalPrice}" class="form-control totalPrice"
                             readonly="true"/></td>
            <td><button class="delete btn btn-outline-danger btn-sm" type="button"><i class="far fa-trash-alt"></i>
            </button></td>
        </tr>
    </g:each>
    </tbody>
</table>

<g:javascript>
    function displayMessage() {
        var newRow = '' +
            '<tr>' +
            '<td><button class="delete btn btn-outline-danger btn-sm" type="button"><i class="far fa-trash-alt"></i>
        </button></td></td>'+
            '<td>' + 'hola' + '</td>'+
            '<td>' + 'hola' + '</td>'+
            '<td>' + 'hola' + '</td>'+
            '<td>' + 'hola' + '</td>'+
            '</tr>'
        document.getElementById('table-details').append(newRow);
    }

    const btn = document.getElementById('add');
    btn.onclick = displayMessage;
</g:javascript>

