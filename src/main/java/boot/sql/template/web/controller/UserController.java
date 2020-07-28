package boot.sql.template.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.sql.template.web.entity.User;
import boot.sql.template.web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping("/")
	public String start() {
		return "redirect:/users";
	}
	
	@GetMapping("/helloWorld")
	public String helloWorld(Model model) {
		String helloWorld = "Hello World!";
		model.addAttribute("helloWorld", helloWorld);
		return "helloWorld";
	}

	@GetMapping("/vintage")
	public String vintage(Model model) {
		List<User> users = userService.getAll();
		model.addAttribute("users", users);
		return "vintage";
	}
	
	@GetMapping("/users")
	public String users(Model model) {
		List<User> users = userService.getAll();
		model.addAttribute("users", users);
		return "users";
	}
	
	@GetMapping("/users/{userId}")
	public String readUser(@PathVariable int userId, Model model) {
		User user = userService.get(userId);
		model.addAttribute("user", user);
		return "user";
	}
	
	@GetMapping("/addUser")
	public String addUser(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "addUser";
	}
	
	@PostMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/users";
	}
	
	@GetMapping("/updateUser")
	public String updateUser(@RequestParam("userId") int id, Model model) {
		User user = userService.get(id);
		model.addAttribute("user", user);
		return "updateUser";
	}
	
	@PostMapping("/saveUpdate")
	public String saveUpdate(@ModelAttribute("user") User user) {
		userService.update(user);
		return "redirect:/users";
	}
	
	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam("userId") int id) {
		User user = userService.get(id);
		userService.delete(user);
		return "redirect:/users";
	}
	
}
