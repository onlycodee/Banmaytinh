/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uibean;

import dao.ProductCategoryDAO;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.ProductCategory;
import org.primefaces.component.menu.Menu;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

/**
 *
 * @author vuvie
 */
@ManagedBean
@RequestScoped
public class ProductCategoryMenu {

    /**
     * Creates a new instance of ProductCategoryMenu
     */
    private List<ProductCategory> productTypes;
    private MenuModel categoryMenu;
    
    public ProductCategoryMenu() {
    } 
    @PostConstruct
    public void init() {
        categoryMenu = new DefaultMenuModel();
        DefaultSubMenu submenu = new DefaultSubMenu();
                submenu.setLabel("Danh muc");
        System.out.println("Category length: " + getProductTypes().size());
        for (ProductCategory pc : getProductTypes()) {
            DefaultMenuItem item = new DefaultMenuItem();
                item.setValue(pc.getName());
                item.setParam("categoryId", pc.getId());
                item.setUrl("index.xhtml");
            submenu.getElements().add(item);
        }
        categoryMenu.getElements().add(submenu);
    }
    
    public void setCategoryMenu(MenuModel categoryMenu) {
        this.categoryMenu = categoryMenu;
    }

    public MenuModel getCategoryMenu() {
        return categoryMenu;
    }
    
    public void setProductTypes(List<ProductCategory> productTypes) {
        this.productTypes = productTypes;
    }

    public List<ProductCategory> getProductTypes() {
        if (productTypes == null) {
            productTypes = ProductCategoryDAO.getInstance().findAll();
        }
        return productTypes;
    }
}
