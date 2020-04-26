/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import model.Product;
import org.hibernate.query.Query;

/**
 *
 * @author vuvie
 */
public class ProductDAO extends AbstractModel {
    public ProductDAO() {
        super(Product.class);
    }
    
    public List<Product> getAllProductWithCategory(String categoryId) {
        try {
            if (!sessionFactory.getCurrentSession().getTransaction().isActive())
                sessionFactory.getCurrentSession().getTransaction().begin();    
            return sessionFactory.getCurrentSession()
                    .createQuery("from Product pr where pr.productCategory.id =" + categoryId).list();
        } catch (RuntimeException re) {
            return null;
        }
    }
    
    public static ProductDAO getInstance() {
        return SingletonHelper.INSTANCE;
    }
 
    private static class SingletonHelper {
        private static final ProductDAO INSTANCE = new ProductDAO();
    }
}
