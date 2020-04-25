/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Product;

/**
 *
 * @author vuvie
 */
public class ProductDAO extends AbstractModel {
    public ProductDAO() {
        super(Product.class);
    }
    
    public static ProductDAO getInstance() {
        return SingletonHelper.INSTANCE;
    }
 
    private static class SingletonHelper {
        private static final ProductDAO INSTANCE = new ProductDAO();
    }
}
