package poly.edu.service;

import org.springframework.stereotype.Service;

import poly.edu.model.DB;
import poly.edu.model.Item;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    Map<Integer, Item> map = new HashMap<>();

    @Override
    public void add(Integer id) {
        Item item = map.get(id);
        if (item == null) {
            item = DB.items.get(id);
            item.setQty(1);
            map.put(id, item);
        } else {
            item.setQty(item.getQty() + 1);
        }
    }

    @Override
    public void remove(Integer id) {
        map.remove(id);
    }

    @Override
    public void update(Integer id, int qty) {
        Item item = map.get(id);
        if (item != null) {
            item.setQty(qty);
        }
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Collection<Item> getItems() {
        return map.values();
    }

    @Override
    public double getAmount() {
        return map.values().stream()
                .mapToDouble(i -> i.getPrice() * i.getQty())
                .sum();
    }
}
