package model;
// Generated Apr 25, 2020 9:18:43 PM by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * PaymentType generated by hbm2java
 */
public class PaymentType  implements java.io.Serializable {


     private int id;
     private String name;
     private Set invoices = new HashSet(0);

    public PaymentType() {
    }

	
    public PaymentType(int id) {
        this.id = id;
    }
    public PaymentType(int id, String name, Set invoices) {
       this.id = id;
       this.name = name;
       this.invoices = invoices;
    }
   
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public Set getInvoices() {
        return this.invoices;
    }
    
    public void setInvoices(Set invoices) {
        this.invoices = invoices;
    }




}


