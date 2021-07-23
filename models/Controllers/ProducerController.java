package ru.specialist.demo.models.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.specialist.demo.models.Repositories.CountryRepository;
import ru.specialist.demo.models.Repositories.ProducerRepository;
import ru.specialist.demo.models.country;
import ru.specialist.demo.models.dolznost;
import ru.specialist.demo.models.producer;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ProducerController {

    @Autowired
    private ProducerRepository producerRepository;
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/producer-main")
    public String producerMain(Model model) {
        Iterable<producer> accumuls = producerRepository.findAll();
        model.addAttribute("producers", accumuls);
        return "producer-main";
    }

    @GetMapping("/producer/add")
    public String producerAdd(Model model) {
        Iterable<country> dolznosts = countryRepository.findAll();
        model.addAttribute("countrys", dolznosts);
        return "producer-add";
    }

    @PostMapping("/producer/add")
    public String producerPostAdd(@RequestParam String nameProducer, @RequestParam (value = "countries") String countries, Model model) {
        long idDolzn = Long.parseLong(countries) ;

        var countryOptional = countryRepository.findById(idDolzn);
        producer newAccum = new producer(nameProducer,countryOptional.get());
        producerRepository.save(newAccum);
        return "redirect:/producer-main";
    }

    @GetMapping("/producer/{id}")
    public String producerDetails(@PathVariable(value="id") long id, Model model) {
        if(!producerRepository.existsById(id)) {
            return "redirect:/producer-main";
        }

        Optional<producer> dolznostById = producerRepository.findById(id);
        ArrayList<producer> res = new ArrayList<>();
        dolznostById.ifPresent(res::add);
        model.addAttribute("producer", res);
        var d = dolznostById.get().getCountryProducer().countryName;
        model.addAttribute("countryName", d);
        return "producer-details";
    }

    @GetMapping("/producer/{id}/edit")
    public String producerEdit(@PathVariable(value="id") long id, Model model) {
        if(!producerRepository.existsById(id)) {
            return "redirect:/producer-main";
        }
        Optional<producer> dolznostById = producerRepository.findById(id);
        ArrayList<producer> res = new ArrayList<>();
        dolznostById.ifPresent(res::add);
        model.addAttribute("producer", res);
        Iterable<country> dolznosts = countryRepository.findAll();
        model.addAttribute("countries", dolznosts);
        var dolzn = res.get(0).getCountryProducer();
        model.addAttribute("country", dolzn);
        return "producer-edit";
    }

    @PostMapping("/producer/{id}/edit")
    public String producerPostUpdate(@PathVariable(value="id") long id, @RequestParam String nameProducer, @RequestParam (value = "countries") String countries, Model model) {
        producer producerUpdate = producerRepository.findById(id).orElseThrow();
        producerUpdate.setName(nameProducer);
        long idCountry = Long.parseLong(countries) ;

        var dolxnost = countryRepository.findById(idCountry);
        producerUpdate.setCountryProducer(dolxnost.get());
        producerRepository.save(producerUpdate);
        return "redirect:/producer-main";
    }

    @PostMapping("/producer/{id}/remove")
    public String producerPostDelete(@PathVariable(value="id") long id, Model model) {
        producer dolznostUpdate = producerRepository.findById(id).orElseThrow();
        producerRepository.delete(dolznostUpdate);
        return "redirect:/producer-main";
    }
}
