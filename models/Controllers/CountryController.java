package ru.specialist.demo.models.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.specialist.demo.models.Repositories.CountryRepository;
import ru.specialist.demo.models.country;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/country-main")
    public String countryMain(Model model) {
        Iterable<country> countries = countryRepository.findAll();
        model.addAttribute("countries", countries);
        return "country-main";
    }

    @GetMapping("/country/add")
    public String countryAdd(Model model) {

        return "country-add";
    }

    @PostMapping("/country/add")
    public String countryPostAdd(@RequestParam String name, Model model) {
        country newcountry = new country(name);
        countryRepository.save(newcountry);
        return "redirect:/country-main";
    }

    @GetMapping("/country/{id}")
    public String countryDetails(@PathVariable(value="id") long id, Model model) {
        if(!countryRepository.existsById(id)) {
            return "redirect:/country-main";
        }
        Optional<country> dolznostById = countryRepository.findById(id);
        ArrayList<country> res = new ArrayList<>();
        dolznostById.ifPresent(res::add);
        model.addAttribute("country", res);
        return "country-details";
    }

    @GetMapping("/country/{id}/edit")
    public String countryEdit(@PathVariable(value="id") long id, Model model) {
        if(!countryRepository.existsById(id)) {
            return "redirect:/country-main";
        }
        Optional<country> dolznostById = countryRepository.findById(id);
        ArrayList<country> res = new ArrayList<>();
        dolznostById.ifPresent(res::add);
        model.addAttribute("country", res);
        return "country-edit";
    }

    @PostMapping("/country/{id}/edit")
    public String countryPostUpdate(@PathVariable(value="id") long id, @RequestParam String name, Model model) {
        country dolznostUpdate = countryRepository.findById(id).orElseThrow();
        dolznostUpdate.setCountryName(name);
        countryRepository.save(dolznostUpdate);
        return "redirect:/country-main";
    }

    @PostMapping("/country/{id}/remove")
    public String countryPostDelete(@PathVariable(value="id") long id, Model model) {
        country dolznostUpdate = countryRepository.findById(id).orElseThrow();
        countryRepository.delete(dolznostUpdate);
        return "redirect:/country-main";
    }
}
