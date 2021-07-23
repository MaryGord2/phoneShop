package ru.specialist.demo.models.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.specialist.demo.models.Repositories.OsRepository;
import ru.specialist.demo.models.os;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class OsController {

    @Autowired
    private OsRepository osRepository;

    @GetMapping("/os-main")
    public String osMain(Model model) {
        Iterable<os> os = osRepository.findAll();
        model.addAttribute("os", os);
        return "os-main";
    }

    @GetMapping("/os/add")
    public String osAdd(Model model) {

        return "os-add";
    }

    @PostMapping("/os/add")
    public String osPostAdd(@RequestParam String name, Model model) {
        os newos= new os(name);
        osRepository.save(newos);
        return "redirect:/os-main";
    }

    @GetMapping("/os/{id}")
    public String osDetails(@PathVariable(value="id") long id, Model model) {
        if(!osRepository.existsById(id)) {
            return "redirect:/os-main";
        }
        Optional<os> osById = osRepository.findById(id);
        ArrayList<os> res = new ArrayList<>();
        osById.ifPresent(res::add);
        model.addAttribute("os", res);
        return "os-details";
    }

    @GetMapping("/os/{id}/edit")
    public String osEdit(@PathVariable(value="id") long id, Model model) {
        if(!osRepository.existsById(id)) {
            return "redirect:/os-main";
        }
        Optional<os> osById = osRepository.findById(id);
        ArrayList<os> res = new ArrayList<>();
        osById.ifPresent(res::add);
        model.addAttribute("os", res);
        return "os-edit";
    }

    @PostMapping("/os/{id}/edit")
    public String osPostUpdate(@PathVariable(value="id") long id, @RequestParam String name, Model model) {
        os dolznostUpdate = osRepository.findById(id).orElseThrow();
        dolznostUpdate.setName(name);
        osRepository.save(dolznostUpdate);
        return "redirect:/os-main";
    }

    @PostMapping("/os/{id}/remove")
    public String osPostDelete(@PathVariable(value="id") long id, Model model) {
        os dolznostUpdate = osRepository.findById(id).orElseThrow();
        osRepository.delete(dolznostUpdate);
        return "redirect:/os-main";
    }
}
