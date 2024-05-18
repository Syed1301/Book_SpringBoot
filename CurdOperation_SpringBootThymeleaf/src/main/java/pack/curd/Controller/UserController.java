package pack.curd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pack.curd.Model.UserModel;
import pack.curd.Model.Userlist;
import pack.curd.Service.UserService;
import pack.curd.Service.UserServiceImp;
import pack.curd.Service.UserlistService;

@Controller
public class UserController {

	@Autowired
	UserServiceImp service;
	
	@Autowired
	UserlistService listservice;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/book_register")
	public String register() {
		return "bookRegister";
	}
	
	
	@GetMapping("/available_Book")
	public ModelAndView getallbook() {
		List<UserModel> obj = service.getallbook();
		ModelAndView model =new ModelAndView();
		model.setViewName("booklist");
		model.addObject("list", obj);
		return model;
	}
	
	@PostMapping("/save")
	public String addbook(@ModelAttribute UserModel user) {
		service.save(user);
		return "redirect:/available_Book";
	}
	
	@GetMapping("/my_books")
	public String getbooks(ModelAndView model) {
		
		List<Userlist> list = listservice.getbooklist();
		model.addObject("list", list);
		return"mybook";	
	}
	
	@GetMapping("/mylist/{id}")
	public String getlist(@PathVariable("id") int id) {
		
		Userlist obj=listservice.getbookbyid(id);
		
		listservice.savebook(obj);
		
		return "redirect:/my_books";
	}
	
	@GetMapping("/editbook/{id}")
	public String editbook(@PathVariable("id") int id,ModelAndView model) {
		Userlist obj = listservice.getbookbyid(id);
		model.addObject("book", obj);
		return "bookEdit";
	}
	
	@GetMapping("/deleteBook/{id}")
	public String deletebyid(@PathVariable("id") int id) {
		
		service.deleteid(id);
		return "redirect:/available_Book";
	}

}
