package ru.specialist.demo.models.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.specialist.demo.models.Repositories.FormFactorRepository;
import ru.specialist.demo.models.formFactor;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class FormFactorController {

    @Autowired
    private FormFactorRepository formFactorRepository;

    @GetMapping("/formFactor-main")
    public String formFactorMain(Model model) {
        Iterable<formFactor> formFactors = formFactorRepository.findAll();
        model.addAttribute("formFactors", formFactors);
        return "formFactor-main";
    }

    @GetMapping("/formFactor/add")
    public String formFactorAdd(Model model) {

        return "formFactor-add";
    }

    @PostMapping("/formFactor/add")
    public String formFactorPostAdd(@RequestParam String name, Model model) {
        formFactor newAccum = new formFactor(name);
        formFactorRepository.save(newAccum);
        return "redirect:/formFactor-main";
    }

    @GetMapping("/formFactor/{id}")
    public String formFactorDetails(@PathVariable(value="id") long id, Model model) {
        if(!formFactorRepository.existsById(id)) {
            return "redirect:/formFactor-main";
        }
        Optional<formFactor> dolznostById = formFactorRepository.findById(id);
        ArrayList<formFactor> res = new ArrayList<>();
        dolznostById.ifPresent(res::add);
        model.addAttribute("formFactor", res);
        return "formFactor-details";
    }

    @GetMapping("/formFactor/{id}/edit")
    public String formFactorEdit(@PathVariable(value="id") long id, Model model) {
        if(!formFactorRepository.existsById(id)) {
            return "redirect:/formFactor-main";
        }
        Optional<formFactor> dolznostById = formFactorRepository.findById(id);
        ArrayList<formFactor> res = new ArrayList<>();
        dolznostById.ifPresent(res::add);
        model.addAttribute("formFactor", res);
        return "formFactor-edit";
    }

    @PostMapping("/formFactor/{id}/edit")
    public String formFactorPostUpdate(@PathVariable(value="id") long id, @RequestParam String name, Model model) {
        formFactor dolznostUpdate = formFactorRepository.findById(id).orElseThrow();
        dolznostUpdate.setName(name);
        formFactorRepository.save(dolznostUpdate);
        return "redirect:/formFactor-main";
    }

    @PostMapping("/formFactor/{id}/remove")
    public String formFactorPostDelete(@PathVariable(value="id") long id, Model model) {
        formFactor dolznostUpdate = formFactorRepository.findById(id).orElseThrow();
        formFactorRepository.delete(dolznostUpdate);
        return "redirect:/formFactor-main";
    }
}
