/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.fall23.shopping;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<String, Item> items = null;

    public Cart() {
        this.items = new HashMap<>();
    }

    public Collection<Item> getItems() {
        return items.values();
    }

    public void add(Item item) {
        String id = item.getId();
        //neu trong gio hang da co item

//        for (Map.Entry<String, Item> entry : items.entrySet()) {
//            String key = entry.getKey();
//            Item value = entry.getValue();
//            // Xử lý key và value ở đây
//        }

        if(this.items.containsKey(id)){
            //lay item tu gio hang
            Item cItem = this.items.get(id);
            //cap nhat so luong
            cItem.setQuantity(cItem.getQuantity()+item.getQuantity());
        }else{
            //them item moi vao gio hang
            this.items.put(id, item);
        }
    }

    public void remove(int id) {
        this.items.remove(id);
    }

    public void empty() {
        this.items.clear();
    }

    public void update(String id, int quantity) {
        Item item = this.items.get(id);
        item.setQuantity(quantity);
    }

//    public int getQuantity() {
//        int quantity = 0;
//        for (int id : this.items.keySet()) {
//            Item item = this.items.get(id);
//            quantity += item.getQuantity();
//        }
//        return quantity;
//    }
//
    public double getTotalCost() {
        double totalCost = 0;
        for (Item item : this.getItems()) {
            totalCost += item.getCost();
        }
        return totalCost;
    }
}
