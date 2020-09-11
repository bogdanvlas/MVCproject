package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import entity.User;
import service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("name", "Bogdan");
		return "index";
	}
	
	
	@GetMapping("/users")
	public String getAllUsers(Model model) {
		model.addAttribute("users", userService.findAll());
		return "usersList";
	}
	
	@GetMapping("/user/{id}")
	public String getById(@PathVariable int id, Model model) {
		model.addAttribute(userService.getById(id));
		return "showUser";
	}
	
	@GetMapping("/createUser")
	public String createUserPage() {
		return "createUser";
	}
	
	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:users";
	}
	@GetMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable int id) {
		userService.deleteById(id);
		return "redirect:/users";
	}
	
	@GetMapping("/editUser/{id}")
	public String editUser(Model model, @PathVariable int id) {
		model.addAttribute(userService.getById(id));
		return "editUser";
	}
	@PostMapping("/updateUser")
	public String doUpdate(@ModelAttribute("user") User user) {
		userService.update(user);
		return "redirect:/users";
	}
}
