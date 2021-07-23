package ru.specialist.demo.models.Controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ru.specialist.demo.models.Repositories.ClientRepository;
import ru.specialist.demo.models.client;

@Controller
public class ClientsController {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/client-main")
	public String clientMain(Model model) {
		Iterable<client> clients = clientRepository.findAll();
		model.addAttribute("clients", clients);
		return "client-main";
	}

	@GetMapping("/clients")
	public String clientsMain(Model model) {
		Iterable<client> clients = clientRepository.findAll();
		model.addAttribute("clients", clients);
		return "clients";
	}
	
	@GetMapping("/client/add")
	public String clientAdd(Model model) {
		
		return "client-add";
	}
	
	@GetMapping("/client/{id}")
	public String clientDetails(@PathVariable(value="id") long id, Model model) {
		if(!clientRepository.existsById(id)) {
			return "redirect:/client";
		}
			Optional<client> clientById = clientRepository.findById(id);
			ArrayList<client> res = new ArrayList<>();
			clientById.ifPresent(res::add);
			model.addAttribute("client", res);
			return "client-details";
	}
	
	@PostMapping("/client/add")
	public String clientPostAdd(@RequestParam String name, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String numberOfPhone,
								@RequestParam String pasport, @RequestParam String address, Model model) {
		client newClient = new client(name, firstname, numberOfPhone, lastname,pasport,address);
		clientRepository.save(newClient);
		return "redirect:/client-main";
	}
	
	@GetMapping("/client/{id}/edit")
	public String clientEdit(@PathVariable(value="id") long id, Model model) {
		if(!clientRepository.existsById(id)) {
			return "redirect:/client-main";
		}
			Optional<client> clientById = clientRepository.findById(id);
			ArrayList<client> res = new ArrayList<>();
			clientById.ifPresent(res::add);
			model.addAttribute("client", res);
			return "client-edit";
	}
	
	@PostMapping("/client/{id}/edit")
	public String clientPostUpdate(@PathVariable(value="id") long id, @RequestParam String name,@RequestParam String firstname,
								   @RequestParam String lastname, @RequestParam String numberOfPhone,
								   @RequestParam String pasport, @RequestParam String address, Model model) {
		client clientUpdate = clientRepository.findById(id).orElseThrow();
		clientUpdate.setName(name);
		clientUpdate.setFirstname(firstname);
		clientUpdate.setLastname(lastname);
		clientUpdate.setNumberOfPhone(numberOfPhone);
		clientUpdate.setPasport(pasport);
		clientUpdate.setAddress(address);
		clientRepository.save(clientUpdate);
		return "redirect:/client-main";
	}
	
	@PostMapping("/client/{id}/remove")
	public String clientPostDelete(@PathVariable(value="id") long id, Model model) {
		client clientUpdate = clientRepository.findById(id).orElseThrow();
		clientRepository.delete(clientUpdate);
		return "redirect:/client-main";
	}
}
