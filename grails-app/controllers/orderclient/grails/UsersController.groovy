package orderclient.grails

import com.fuini.sd.web.beans.User.UserB
import com.fuini.sd.web.service.Role.IRoleService
import com.fuini.sd.web.service.User.IUserService
import grails.validation.ValidationException
import static org.springframework.http.HttpStatus.*

class UsersController {

    IUserService userService
    IRoleService roleService

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(){
        System.out.println("params -> " + params)
        def page = null == params['id'] ? 0 : Integer.valueOf(params['id'])
        def users = userService.getAll(page)
        def next = users.size() == 0 ? 0 : (userService.getCPages() == page + 1 ? 0 : 1)
        [userInstanceL: users, userInstanceT: users?.size(), page: page, next: next]
    }

    def show(Integer id) {
        System.out.println("params -> " + params)
        def userInstance = userService.getById(id)
        [userInstance: userInstance]
    }

    def create() {
        System.out.println("params -> " + params)
        [userInstance: new Users(params), roles:RoleService.getRoles()]
    }

    def save() {
        System.out.println("params -> " + params)
        def userInstance = new UserB(params)
        def role = roleService.getById(Integer.valueOf(params['roleId']))
        System.out.println(userInstance.userPrice)
        userInstance.setRole(role)
        def newUserInstance = userService.save(userInstance)
        if (!newUserInstance?.getId()) {
            render(view: "create", model: [userInstance: userInstance])
            return
        }
        flash.message = message(code: 'default.created.message', args: [message(code: 'users.label', default: 'Users'), newUserInstance.getId()])
        redirect(action: "show", id: newUserInstance.getId())
    }

    def edit(Integer id) {
        def userInstance = userService.getById(id.intValue())
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'users.label', default: 'Users'), id])
            redirect(action: "list")
            return
        }
        [userInstance: userInstance, roles:roleService.getRoles()]
    }

    def update() {
        System.out.println("params -> " + params)
        def userInstance = userService.getById(Integer.parseInt(params.get("id")))
        def newUserInstance = new UserB(params)
        newUserInstance.setUserName(params.get("userName"))
        newUserInstance.setUserPrice(Integer.valueOf(params.get("userPrice")))
        def role = roleService.getById(Integer.valueOf(params['roleId']))
        newUserInstance.setRole(role)
        userInstance = userService.update(newUserInstance)

        flash.message = message(code: 'default.updated.message', args: [message(code: 'users.label', default: 'Users'), userInstance.getId()])
        redirect(action: "show", id: userInstance.getId())
    }

    def delete(Integer id) {
        System.out.println("params -> " + params)
        def userInstance = userService.delete(id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'users.label', default: 'Users'),
                    id
            ])
            redirect(action: "list")
            return
        }else {
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'users.label', default: 'Users'),
                    id
            ])
            redirect(action: "list")
            return
        }
    }
}
