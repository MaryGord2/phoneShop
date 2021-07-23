package ru.specialist.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.specialist.demo.models.client;

@Controller
public class MainController {

	@GetMapping("/")//авторизация
	public String major(Model model) {
		model.addAttribute("title", "Главная страница");
		return "home";
	}
	
	@GetMapping("/about")// о разработчике
	public String about(Model model) {
		model.addAttribute("title", "Страница про разработчика");
		return "about";
	}

	@GetMapping("/mdm-main")//форма справочников
	public String mdms(Model model) {
		model.addAttribute("title", "Справочники");
		return "mdm-main";
	}

	@GetMapping("/reports")//форма справочников
	public String reports(Model model) {
		model.addAttribute("title", "Отчеты");
		return "reports";
	}
	
}
