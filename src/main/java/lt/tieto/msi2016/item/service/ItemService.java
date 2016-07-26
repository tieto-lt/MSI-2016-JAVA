package lt.tieto.msi2016.item.service;


import lt.tieto.msi2016.item.model.Item;
import lt.tieto.msi2016.item.repository.ItemRepository;
import lt.tieto.msi2016.item.repository.model.ItemDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {

    @Autowired
    private ItemRepository repository;

    public Item get(Long id) {
        ItemDb item = repository.findOne(id);
        return mapToItem(item);
    }

    public List<Item> all() {
        return repository.findAll().stream()
                .map(ItemService::mapToItem)
                .collect(Collectors.toList());
    }

    public Item createOrUpdateItem(Long id, Item item) {
        if (repository.exists(id)) {
            ItemDb updated = repository.update(mapToItemDb(id, item));
            return mapToItem(updated);
        } else {
            ItemDb created = repository.create(mapToItemDb(id, item));
            return mapToItem(created);
        }
    }

    public Item createItem(Item item) {
        return mapToItem(repository.create(mapToItemDb(item)));
    }

    public void remove(Long id) {
        repository.delete(id);
    }

    private static Item mapToItem(ItemDb db) {
        Item api = new Item();
        api.setId(db.getId());
        api.setName(db.getName());
        api.setQuantity(db.getQuantity());
        api.setSize(db.getSize());
        return api;
    }

    private static ItemDb mapToItemDb(Long id, Item api) {
        ItemDb db = new ItemDb();
        db.setId(id);
        db.setName(api.getName());
        db.setQuantity(api.getQuantity());
        db.setSize(api.getSize());
        return db;
    }

    private static ItemDb mapToItemDb(Item api) {
        return mapToItemDb(api.getId(), api);
    }
}
