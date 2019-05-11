package cart;

import entity.Books;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Books, Integer> itemMap = new HashMap<>();

    public Map<Books, Integer> getItemMap() {
        return itemMap;
    }

    public void setItemMap(Map<Books, Integer> itemMap) {
        this.itemMap = itemMap;
    }
}
