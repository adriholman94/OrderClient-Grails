<div class="fieldcontain required">
    <label for="productName">Product Name<span class="required-indicator">*</span>
    </label><input type="text" name="productName" value="${productInstance?.productName}" required="" maxlength="30" id="productName">
</div>
<div class="fieldcontain required">
    <label for="productPrice">Product Price<span class="required-indicator">*</span>
    </label><input type="text" name="productPrice" value="${productInstance?.productPrice}" required="" maxlength="30" id="productPrice">
</div>
<div class="fieldcontain required">
    <label for="category">Category<span class="required-indicator">*</span>
    </label>
    <g:select id="category" name="categoryId" from="${categories}" optionKey="id" optionValue="categoryName" required=""
                  value="${productInstance?.category?.id}" class="many-to-one"/>
</div>