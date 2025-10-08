package poly.edu.service;



import java.util.Collection;

import poly.edu.model.Item;

public interface ShoppingCartService {
    void add(Integer id);
    void remove(Integer id);
    void update(Integer id, int qty);
    void clear();
    Collection<Item> getItems();
    double getAmount();
}
