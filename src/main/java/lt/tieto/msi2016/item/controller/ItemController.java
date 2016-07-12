package lt.tieto.msi2016.item.controller;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {

    @RequestMapping(method = RequestMethod.GET, path = "/api/items")
    public String items() {
        return "[" +
                "  {" +
                "    \"id\": 1," +
                "    \"name\": \"Item 1\"," +
                "    \"quantity\": 1," +
                "    \"size\": \"20x20\"" +
                "  }," +
                "  {" +
                "    \"id\": 2," +
                "    \"name\": \"Item 2\"," +
                "    \"quantity\": 5," +
                "    \"size\": \"20x40\"" +
                "  }," +
                "  {" +
                "    \"id\": 3," +
                "    \"name\": \"Item 3\"," +
                "    \"quantity\": 45," +
                "    \"size\": \"55x20\"" +
                "  }" +
                "]";
    }
}
