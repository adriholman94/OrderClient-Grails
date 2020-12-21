package orderclient.grails
import com.fuini.sd.web.beans.Supplier.SupplierB
import com.fuini.sd.web.service.Supplier.ISupplierService

class SuppliersController {

    def ISupplierService supplierService

    static allowedMethods = [save: "POST", update: "POST", delete: "DELETE"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max){
        System.out.println("params ==== " + params)
        def page = null == params['id'] ? 0 : Integer.valueOf(params['id'])
        def suppliers = supplierService.getAll(page)
        def next = suppliers.size() == 0 ? 0 : (supplierService.getCPages() == page + 1 ? 0 : 1)
        [supplierInstanceL: suppliers, supplierInstanceT: suppliers?.size(), page: page, next: next]
    }

    def show(Integer id) {
        System.out.println("params ==== " + params)
        def supplierInstance = supplierService.getById(id)
        [supplierInstance: supplierInstance]
    }

    def create() {
        System.out.println("params ==== " + params)
        [supplierInstance: new Suppliers(params)]
    }

    def save() {
        System.out.println("params ==== " + params)
        def supplierInstance = new SupplierB(params)
        def newSupplierInstance = supplierService.save(supplierInstance)
        if (!newSupplierInstance?.getId()) {
            render(view: "create", model: [supplierInstance: supplierInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'suppliers.label', default: 'Suppliers'), newSupplierInstance.getId()])
        redirect(action: "show", id: newSupplierInstance.getId())
    }

    def edit(Long id) {
        def supplierInstance = supplierService.getById(id.intValue())
        if (!supplierInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'suppliers.label', default: 'Suppliers'), id])
            redirect(action: "list")
            return
        }

        [supplierInstance: supplierInstance]
    }

    def update() {
        System.out.println("params ==== " + params)
        def newSupplierInstance = new SupplierB(params)
        newSupplierInstance.setId(Integer.parseInt(params.get("edit")))
        newSupplierInstance.setSupplierName(params.get("supplierName"))
        supplierService.update(newSupplierInstance)

        flash.message = message(code: 'default.updated.message', args: [message(code: 'suppliers.label', default: 'Suppliers'), newSupplierInstance.getId()])
        redirect(action: "show", id: newSupplierInstance.getId())
    }

    def delete(Integer id) {
        def supplierInstance = supplierService.delete(id)
        if (!supplierInstance) {
            flash.message = message(code: 'default.not.found.message', args: [
                    message(code: 'suppliers.label', default: 'Suppliers'),
                    id
            ])
            redirect(action: "list")
            return
        }else {
            flash.message = message(code: 'default.deleted.message', args: [
                    message(code: 'suppliers.label', default: 'Suppliers'),
                    id
            ])
            redirect(action: "list")
            return
        }
    }
}
