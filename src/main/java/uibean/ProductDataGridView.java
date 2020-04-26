/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uibean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Product;

/**
 *
 * @author vuvie
 */
@ManagedBean
@RequestScoped
public class ProductDataGridView {
    private Product selectedProduct;
    /**
     * Creates a new instance of ProductDataGridView
     */
    public ProductDataGridView() {
    }
    
    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }
}
