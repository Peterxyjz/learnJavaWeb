package pe.fall23.shopping;

import pe.fall23.db.ProductDTO;

public class Item {
    private String id;
    private ProductDTO product;
    private int quantity;

    public Item() {
    }       

    public Item(String id, ProductDTO product, int quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
//    public double getNewPrice(){
//        return (1-this.product.getDiscount())*this.product.getPrice();
//    }
    
    public double getCost(){
        return this.quantity*this.product.getPrice();
    }
}
