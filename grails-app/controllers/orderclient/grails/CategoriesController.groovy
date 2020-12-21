package orderclient.grails

import com.fuini.sd.web.beans.Category.CategoryB
import com.fuini.sd.web.service.Category.ICategoryService

class CategoriesController {

    def ICategoryService categoryService

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max){
        System.out.println("params -> " + params)
        def page = null == params['id'] ? 0 : Integer.valueOf(params['id'])
        def categories = categoryService.getAll(page)
        def next = categories.size() == 0 ? 0 : (categoryService.getCPages() == page + 1 ? 0 : 1)
        [categoryInstanceL: categories, categoryInstanceT: categories?.size(), page: page, next: next]
    }

    def show(Integer id) {
        System.out.println("params -> " + params)
        def categoryInstance = categoryService.getById(id)
        [categoryInstance: categoryInstance]
    }

    def create() {
        System.out.println("params -> " + params)
        [categoryInstance: new Categories(params)]
    }

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

    def edit(Integer id) {
        def categoryInstance = categoryService.getById(id.intValue())
        if (!categoryInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'categories.label', default: 'Categories'), id])
            redirect(action: "list")
            return
        }
        [categoryInstance: categoryInstance]
    }

    def update() {
        System.out.println("params -> " + params)
        def newCategoryInstance = new CategoryB(params)
        newCategoryInstance.setId(Integer.parseInt(params.get("edit")))
        newCategoryInstance.setCategoryName(params.get("categoryName"))
        categoryService.update(newCategoryInstance)

        flash.message = message(code: 'default.updated.message', args: [message(code: 'categories.label', default: 'Categories'), newCategoryInstance.getId()])
        redirect(action: "show", id: newCategoryInstance.getId())
    }

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
