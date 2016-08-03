package lt.tieto.msi2016.item.controller;

import javax.validation.Valid;
import java.util.List;

import lt.tieto.msi2016.user.model.Roles;
import lt.tieto.msi2016.utils.controller.BaseController;
import lt.tieto.msi2016.item.model.Item;
import lt.tieto.msi2016.item.service.ItemService;
import lt.tieto.msi2016.utils.security.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController extends BaseController {

    @Autowired
    private ItemService service;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(method = RequestMethod.GET, path = "/api/secured/annotation/operator")
    @Secured(Roles.OPERATOR)
    public String getOnlyOperatorAnnotation() {
        return "Success Operator Annotation";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/secured/service/operator")
    public String getOnlyOperatorService() {
        if (!securityService.hasAuthority(Roles.OPERATOR)) {
            throw new AccessDeniedException("Access denied by me");
        }
        return "Success Operator Service";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/items/{id}")
    public Item get(@PathVariable Long id) {
        return service.get(id);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/api/items")
    public List<Item> all() {
        return service.all();
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/api/items/{id}")
    public Item createOrUpdateItem(@PathVariable Long id, @Valid @RequestBody Item item) {
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
