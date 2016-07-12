package lt.tieto.msi2016.item.controller;


import lt.tieto.msi2016.item.model.Item;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ItemController {

    static final List<Item> ITEMS_LIST = Arrays.asList(
            new Item(1l, "Item 1", 1, "20x20"),
            new Item(2l, "Item 2", 10, "200x120"),
            new Item(3l, "Item 3", 15, "20x10"),
            new Item(4l, "Item 4", 15, "20x10")
    );

    @RequestMapping(method = RequestMethod.GET, path = "/api/items/{id}")
    public Item get(@PathVariable Long id) {
        return ITEMS_LIST.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/items")
    public List<Item> items() {
        return ITEMS_LIST;
    }
}
