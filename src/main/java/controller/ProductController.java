/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.HibernateUtil;
import dao.ProductDAO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import model.Product;
import org.hibernate.Session;
import org.primefaces.PrimeFaces;

/**
 *
 * @author vuvie
 */
@ManagedBean
@RequestScoped
public class ProductController {

    /**
     * Creates a new instance of ProductController
     */
    private List<Product> products = null;
    
    public ProductController() {
    }
    public List<Product> getProducts() {
        Map<String, String> params = FacesContext.getCurrentInstance().
                   getExternalContext().getRequestParameterMap();
        String parameterOne = params.get("categoryId");
        if (products == null) {
            products = ProductDAO.getInstance().findAll();
        } else if (parameterOne != null) {
            System.out.println("Category id : " + parameterOne);
            products = ProductDAO.getInstance().getAllProductWithCategory(parameterOne);
        }
//        System.out.println("Lengthh: " + products.size());
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
