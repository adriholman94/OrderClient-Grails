package orderclient.grails

import com.fuini.sd.web.beans.Role.RoleB
import com.fuini.sd.web.service.Role.IRoleService

class RolesController {

    IRoleService roleService

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(){
        System.out.println("params -> " + params)
        def page = null == params['id'] ? 0 : Integer.valueOf(params['id'])
        def roles = roleService.getAll(page)
        def next = roles.size() == 0 ? 0 : (roleService.getCPages() == page + 1 ? 0 : 1)
        [roleInstanceL: roles, roleInstanceT: roles?.size(), page: page, next: next]
    }

    def show(Integer id) {
        System.out.println("params -> " + params)
        def roleInstance = roleService.getById(id)
        [roleInstance: roleInstance]
    }

    def create() {
        System.out.println("params -> " + params)
        [roleInstance: new Roles(params)]
    }

    def save() {
        System.out.println("params -> " + params)
        def roleInstance = new RoleB(params)
        def newRoleInstance = roleService.save(roleInstance)
        if (!newRoleInstance?.getId()) {
            render(view: "create", model: [roleInstance: roleInstance])
            return
        }
        flash.message = message(code: 'default.created.message', args: [message(code: 'roles.label', default: 'Roles'), newRoleInstance.getId()])
        redirect(action: "show", id: newRoleInstance.getId())
    }

    def edit(Integer id) {
        def roleInstance = roleService.getById(id.intValue())
        if (!roleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'roles.label', default: 'Roles'), id])
            redirect(action: "list")
            return
        }
        [roleInstance: roleInstance]
    }

    def update() {
        System.out.println("params -> " + params)
        def newRoleInstance = new RoleB(params)
        newRoleInstance.setRoleName(params.get("roleName"))
        roleService.update(newRoleInstance)

        flash.message = message(code: 'default.updated.message', args: [message(code: 'roles.label', default: 'Roles'), newRoleInstance.getId()])
        redirect(action: "show", id: newRoleInstance.getId())
    }

    def delete(Integer id) {
        System.out.println("params -> " + params)
        def roleInstance = roleService.delete(id)
        if (!roleInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'roles.label', default: 'Roles'),
                    id
            ])
            redirect(action: "list")
            return
        }else {
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'roles.label', default: 'Roles'),
                    id
            ])
            redirect(action: "list")
            return
        }
    }
}
