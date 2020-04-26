/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Product;
import viewmodel.CartItem;


/**
 *
 * @author vuvie
 */
@ManagedBean
@SessionScoped
public class CartController {

    /**
     * Creates a new instance of CartController
     */
    private HashMap<Integer, CartItem> cart = new HashMap<Integer, CartItem>();

    public void setCart(HashMap<Integer, CartItem> cart) {
        this.cart = cart;
    }

    public HashMap<Integer, CartItem> getCart() {
        System.out.println("Cart length: " + cart.values().size());
        return cart;
    }
    
    public String addItem(Product product) {
        System.out.println("addddddddddddddddddddddddding");
        if (cart.containsKey(product.getId())) {
            cart.get(product.getId()).increaseQuantity(1);
        } else {
            cart.put(product.getId(), new CartItem(product, 1));
        }
        System.out.println("Add item: " + product.getName());
        return "/Cart/index.xhtml?face-redirect=true";
    }
    
    public int ComputeTotalPrice() {
        int price = 0;
        for(CartItem item : cart.values()) {
            price += (item.getProduct().getPrice() * item.getQuantity());
        }
        return price;
    }
    public CartController() {
    }
    
}
