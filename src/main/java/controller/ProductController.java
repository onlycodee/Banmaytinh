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
import java.util.regex.Pattern;
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
    private Product currentProduct = null;
    
    public String viewDetail(Product product) {
        this.currentProduct = product;
        System.out.println("path: " + product.getImagePath());
        return "/Home/productDetail.xhtml?face-redirect=true";
    }
    
    public void setCurrentProduct(Product currentProduct) {
        this.currentProduct = currentProduct;
    }

    public Product getCurrentProduct() {
        return currentProduct;
    }
    
    public ProductController() {
    }
    public List<Product> getProducts() {
        Map<String, String> params = FacesContext.getCurrentInstance().
                   getExternalContext().getRequestParameterMap();
        String parameterOne = params.get("categoryId");
        if (products == null) {
            products = ProductDAO.getInstance().findAll();
        } else if (parameterOne != null) {
            products = ProductDAO.getInstance().getAllProductWithCategory(parameterOne);
        }
//        System.out.println("Lengthh: " + products.size());
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
    
    public String[] productDetailList() {
        if (this.currentProduct != null) {
            String[] result = this.currentProduct.getDetail().split(Pattern.quote("."));
            return result;
        } else {
            return null;
        }
    }
}
