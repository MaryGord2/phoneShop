package ru.specialist.demo.models.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.specialist.demo.models.Repositories.AccumRepository;
import ru.specialist.demo.models.Repositories.DolznostRepository;
import ru.specialist.demo.models.accumul;
import ru.specialist.demo.models.dolznost;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AccumController {

    @Autowired
    private AccumRepository accumRepository;

    @GetMapping("/accum-main")
    public String accumMain(Model model) {
        Iterable<accumul> accumuls = accumRepository.findAll();
        model.addAttribute("accumuls", accumuls);
        return "accum-main";
    }

    @GetMapping("/accum/add")
    public String accumAdd(Model model) {

        return "accum-add";
    }

    @PostMapping("/accum/add")
    public String accumPostAdd(@RequestParam String name, Model model) {
        accumul newAccum = new accumul(name);
        accumRepository.save(newAccum);
        return "redirect:/accum-main";
    }

    @GetMapping("/accum/{id}")
    public String accumDetails(@PathVariable(value="id") long id, Model model) {
        if(!accumRepository.existsById(id)) {
            return "redirect:/accum-main";
        }
        Optional<accumul> dolznostById = accumRepository.findById(id);
        ArrayList<accumul> res = new ArrayList<>();
        dolznostById.ifPresent(res::add);
        model.addAttribute("accum", res);
        return "accum-details";
    }

    @GetMapping("/accum/{id}/edit")
    public String dolznostEdit(@PathVariable(value="id") long id, Model model) {
        if(!accumRepository.existsById(id)) {
            return "redirect:/dolnost-main";
        }
        Optional<accumul> dolznostById = accumRepository.findById(id);
        ArrayList<accumul> res = new ArrayList<>();
        dolznostById.ifPresent(res::add);
        model.addAttribute("accum", res);
        return "accum-edit";
    }

    @PostMapping("/accum/{id}/edit")
    public String dolznostPostUpdate(@PathVariable(value="id") long id, @RequestParam String name, Model model) {
        accumul dolznostUpdate = accumRepository.findById(id).orElseThrow();
        dolznostUpdate.setName(name);
        accumRepository.save(dolznostUpdate);
        return "redirect:/accum-main";
    }

    @PostMapping("/accum/{id}/remove")
    public String dolznostPostDelete(@PathVariable(value="id") long id, Model model) {
        accumul dolznostUpdate = accumRepository.findById(id).orElseThrow();
        accumRepository.delete(dolznostUpdate);
        return "redirect:/accum-main";
    }
}
