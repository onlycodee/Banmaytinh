/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.ProductCategory;

/**
 *
 * @author vuvie
 */
public class ProductCategoryDAO extends AbstractModel {
    public ProductCategoryDAO() {
        super(ProductCategory.class);
    }
    
    public static ProductCategoryDAO getInstance() {
        return SingletonHelper.INSTANCE;
    }
 
    private static class SingletonHelper {
        private static final ProductCategoryDAO INSTANCE = new ProductCategoryDAO();
    }
}
