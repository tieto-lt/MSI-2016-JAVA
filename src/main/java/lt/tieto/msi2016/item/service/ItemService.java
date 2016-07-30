package lt.tieto.msi2016.item.service;


import lt.tieto.msi2016.item.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {

    private static final List<Item> ITEMS_LIST = new ArrayList<>(Arrays.asList(
            new Item(1l, "Item 1", 1, "20x20"),
            new Item(2l, "Item 2", 10, "200x120"),
            new Item(3l, "Item 3", 15, "20x10"),
            new Item(4l, "Item 4", 15, "20x10")
    ));

    public Item get(Long id) {
        return getItemById(id);
    }

    public List<Item> all() {
        return ITEMS_LIST;
    }

    public Item createOrUpdateItem(Long id, Item item) {
        Item existingItem = getItemById(id);
        if (existingItem != null) {
            ITEMS_LIST.remove(existingItem);
            ITEMS_LIST.add(item);
        } else {
            ITEMS_LIST.add(item);
        }
        return item;
    }

    public Item createItem(Item item) {
        ITEMS_LIST.add(item);
        return item;
    }

    public void remove(Long id) {
        Item existingItem = getItemById(id);
        ITEMS_LIST.remove(existingItem);
    }

    private Item getItemById(Long id) {
        return ITEMS_LIST.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
