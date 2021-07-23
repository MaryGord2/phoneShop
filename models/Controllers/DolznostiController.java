package ru.specialist.demo.models.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.specialist.demo.models.Repositories.DolznostRepository;
import ru.specialist.demo.models.client;
import ru.specialist.demo.models.dolznost;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class DolznostiController {

    @Autowired
    private DolznostRepository dolznostRepository;

    @GetMapping("/dolnost-main")
    public String dolznostiMain(Model model) {
        Iterable<dolznost> dolznosti = dolznostRepository.findAll();
        model.addAttribute("dolznosti", dolznosti);
        return "dolnost-main";
    }

    @GetMapping("/dolznost/add")
    public String dolznostAdd(Model model) {

        return "dolznost-add";
    }

    @PostMapping("/dolznost/add")
    public String clientPostAdd(@RequestParam String name, Model model) {
        dolznost newDolz = new dolznost(name);
        dolznostRepository.save(newDolz);
        return "redirect:/dolnost-main";
    }

    @GetMapping("/dolznost/{id}")
    public String dolznostDetails(@PathVariable(value="id") long id, Model model) {
        if(!dolznostRepository.existsById(id)) {
            return "redirect:/dolnost-main";
        }
        Optional<dolznost> dolznostById = dolznostRepository.findById(id);
        ArrayList<dolznost> res = new ArrayList<>();
        dolznostById.ifPresent(res::add);
        model.addAttribute("dolznost", res);
        return "dolznost-details";
    }

    @GetMapping("/dolznost/{id}/edit")
    public String dolznostEdit(@PathVariable(value="id") long id, Model model) {
        if(!dolznostRepository.existsById(id)) {
            return "redirect:/dolnost-main";
        }
        Optional<dolznost> dolznostById = dolznostRepository.findById(id);
        ArrayList<dolznost> res = new ArrayList<>();
        dolznostById.ifPresent(res::add);
        model.addAttribute("dolznost", res);
        return "dolznost-edit";
    }

    @PostMapping("/dolznost/{id}/edit")
    public String dolznostPostUpdate(@PathVariable(value="id") long id, @RequestParam String name, Model model) {
        dolznost dolznostUpdate = dolznostRepository.findById(id).orElseThrow();
        dolznostUpdate.setName(name);
        dolznostRepository.save(dolznostUpdate);
        return "redirect:/dolnost-main";
    }

    @PostMapping("/dolznost/{id}/remove")
    public String dolznostPostDelete(@PathVariable(value="id") long id, Model model) {
        dolznost dolznostUpdate = dolznostRepository.findById(id).orElseThrow();
        dolznostRepository.delete(dolznostUpdate);
        return "redirect:/dolnost-main";
    }
}
