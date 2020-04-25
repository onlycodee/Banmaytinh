/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.HibernateUtil;
import dao.ProductDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Product;
import org.hibernate.Session;

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
        if (products == null) {
            products = ProductDAO.getInstance().findAll();
        }
        System.out.println("Lengthh: " + products.size());
        return products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
