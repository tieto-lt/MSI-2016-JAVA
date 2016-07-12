package lt.tieto.msi2016.item.controller;


import lt.tieto.msi2016.item.model.Item;
import lt.tieto.msi2016.item.service.ItemService;
import lt.tieto.msi2016.utils.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ItemController extends BaseController {

    @Autowired
    private ItemService service;

    @RequestMapping(method = RequestMethod.GET, path = "/api/items/{id}")
    public Item get(@PathVariable Long id) {
        return service.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/items")
    public List<Item> all() {
        return service.all();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/api/items/{id}")
    public Item createOrUpdateItem(@PathVariable Long id, @RequestBody @Valid Item item) {
        return service.createOrUpdateItem(id, item);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/api/items")
    public Item createItem(@RequestBody @Valid Item item) {
        return service.createItem(item);
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/api/items/{id}")
    public void remove(@PathVariable Long id) {
        service.remove(id);
    }
}
