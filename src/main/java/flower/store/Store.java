package flower.store;


import java.util.ArrayList;
import java.util.List;


public class Store {
    private List<Item> items;

    public Store() {
        this.items = new ArrayList<>();
    }

    public List<Item> search(SearchFilter filter) {
        List<Item> foundItems = new ArrayList<>();
        for (Item item : items) {
            if (filter.match(item)) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }

    public void addItem(Item item) {
        items.add(item);
    }
}