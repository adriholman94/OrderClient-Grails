<div class="fieldcontain required">
    <label for="userName">user Name<span class="required-indicator">*</span>
    </label><input type="text" name="userName" value="${userInstance?.userName}" required="" maxlength="30" id="userName">
</div>

<div class="fieldcontain required">
    <label for="role">role<span class="required-indicator">*</span>
    </label>
    <g:select id="role" name="roleId" from="${roles}" optionKey="id" optionValue="roleName" required=""
                  value="${userInstance?.role?.id}" class="many-to-one"/>
</div>