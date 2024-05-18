package pack.curd.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pack.curd.Service.UserlistService;

@Controller
public class UserlistController {
	
	@Autowired
	UserlistService service;
	
	@GetMapping("/deleteMyid/{id}")
	public String deletemyiteam(@PathVariable("id") int id) {
		service.deletebyidlist(id);
		return "redirect:/my_books";
		
	}

}
