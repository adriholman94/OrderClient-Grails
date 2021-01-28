package orderclient.grails

import com.fuini.sd.web.beans.Category.CategoryB
import com.fuini.sd.web.service.Category.ICategoryService
import grails.plugin.springsecurity.annotation.Secured

class CategoriesController {

    ICategoryService categoryService

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    @Secured([
            'ROLE_ADMIN'
    ])
    def index() {
        redirect(action: "list", params: params)
    }

    @Secured([
            'ROLE_ADMIN'
    ])
    def list(){
        System.out.println("params -> " + params)
        def page = null == params['id'] ? 0 : Integer.valueOf(params['id'])
        def categories = categoryService.getAll(page)
        def next = categories.size() == 0 ? 0 : (categoryService.getCPages() == page + 1 ? 0 : 1)
        [categoryInstanceL: categories, categoryInstanceT: categories?.size(), page: page, next: next]
    }

    @Secured([
            'ROLE_ADMIN'
    ])
    def show(Integer id) {
        System.out.println("params -> " + params)
        def categoryInstance = categoryService.getById(id)
        [categoryInstance: categoryInstance]
    }

    @Secured([
            'ROLE_ADMIN'
    ])
    def create() {
        System.out.println("params -> " + params)
        [categoryInstance: new Categories(params)]
    }

    @Secured([
            'ROLE_ADMIN'
    ])
    def save() {
        System.out.println("params -> " + params)
        def categoryInstance = new CategoryB(params)
        def newCategoryInstance = categoryService.save(categoryInstance)
        if (!newCategoryInstance?.getId()) {
            render(view: "create", model: [categoryInstance: categoryInstance])
            return
        }
        flash.message = message(code: 'default.created.message', args: [message(code: 'categories.label', default: 'Categories'), newCategoryInstance.getId()])
        redirect(action: "show", id: newCategoryInstance.getId())
    }

    @Secured([
            'ROLE_ADMIN'
    ])
    def edit(Integer id) {
        def categoryInstance = categoryService.getById(id.intValue())
        if (!categoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'categories.label', default: 'Categories'), id])
            redirect(action: "list")
            return
        }
        [categoryInstance: categoryInstance]
    }

    @Secured([
            'ROLE_ADMIN'
    ])
    def update() {
        System.out.println("params -> " + params)
        def newCategoryInstance = new CategoryB(params)
        newCategoryInstance.setCategoryName(params.get("categoryName"))
        categoryService.update(newCategoryInstance)

        flash.message = message(code: 'default.updated.message', args: [message(code: 'categories.label', default: 'Categories'), newCategoryInstance.getId()])
        redirect(action: "show", id: newCategoryInstance.getId())
    }

    @Secured([
            'ROLE_ADMIN'
    ])
    def delete(Integer id) {
        System.out.println("params -> " + params)
        def categoryInstance = categoryService.delete(id)
        if (!categoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'categories.label', default: 'Categories'),
                    id
            ])
            redirect(action: "list")
            return
        }else {
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'categories.label', default: 'Categories'),
                    id
            ])
            redirect(action: "list")
            return
        }
    }
}
