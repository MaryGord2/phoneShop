package ru.specialist.demo.models.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.specialist.demo.models.Repositories.TypeDispRepository;
import ru.specialist.demo.models.typeDispl;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class TypeDispController {

    @Autowired
    private TypeDispRepository typeDispRepository;

    @GetMapping("/typeDisp-main")
    public String typeDispMain(Model model) {
        Iterable<typeDispl> os = typeDispRepository.findAll();
        model.addAttribute("typeDisp", os);
        return "typeDisp-main";
    }

    @GetMapping("/typeDisp/add")
    public String typeDispAdd(Model model) {

        return "typeDisp-add";
    }

    @PostMapping("/typeDisp/add")
    public String typeDispPostAdd(@RequestParam String name, Model model) {
        typeDispl newos= new typeDispl(name);
        typeDispRepository.save(newos);
        return "redirect:/typeDisp-main";
    }

    @GetMapping("/typeDisp/{id}")
    public String typeDispDetails(@PathVariable(value="id") long id, Model model) {
        if(!typeDispRepository.existsById(id)) {
            return "redirect:/typeDisp-main";
        }
        Optional<typeDispl> osById = typeDispRepository.findById(id);
        ArrayList<typeDispl> res = new ArrayList<>();
        osById.ifPresent(res::add);
        model.addAttribute("typeDisp", res);
        return "typeDisp-details";
    }

    @GetMapping("/typeDisp/{id}/edit")
    public String typeDispEdit(@PathVariable(value="id") long id, Model model) {
        if(!typeDispRepository.existsById(id)) {
            return "redirect:/typeDisp-main";
        }
        Optional<typeDispl> osById = typeDispRepository.findById(id);
        ArrayList<typeDispl> res = new ArrayList<>();
        osById.ifPresent(res::add);
        model.addAttribute("typeDisp", res);
        return "typeDisp-edit";
    }

    @PostMapping("/typeDisp/{id}/edit")
    public String typeDispPostUpdate(@PathVariable(value="id") long id, @RequestParam String name, Model model) {
        typeDispl dolznostUpdate = typeDispRepository.findById(id).orElseThrow();
        dolznostUpdate.setName(name);
        typeDispRepository.save(dolznostUpdate);
        return "redirect:/typeDisp-main";
    }

    @PostMapping("/typeDisp/{id}/remove")
    public String typeDispPostDelete(@PathVariable(value="id") long id, Model model) {
        typeDispl dolznostUpdate = typeDispRepository.findById(id).orElseThrow();
        typeDispRepository.delete(dolznostUpdate);
        return "redirect:/typeDisp-main";
    }
}
