package lt.tieto.msi2016;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingRest {
	
	@RequestMapping("/greeting")
	String greeting(@RequestParam(defaultValue = "World") String name) {
		return "Hello, " + name + "!";
	}

}