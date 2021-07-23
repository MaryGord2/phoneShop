package ru.specialist.demo.models.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.specialist.demo.models.Repositories.CountryRepository;
import ru.specialist.demo.models.Repositories.ProviderRepository;
import ru.specialist.demo.models.country;
import ru.specialist.demo.models.provider;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ProviderController {

    @Autowired
    private ProviderRepository providerRepository;
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/provider-main")
    public String providerMain(Model model) {
        Iterable<provider> accumuls = providerRepository.findAll();
        model.addAttribute("providers", accumuls);
        return "provider-main";
    }

    @GetMapping("/provider/add")
    public String providerAdd(Model model) {
        Iterable<country> dolznosts = countryRepository.findAll();
        model.addAttribute("countrys", dolznosts);
        return "provider-add";
    }

    @PostMapping("/provider/add")
    public String providerPostAdd(@RequestParam String nameProvider, @RequestParam String contact,
                                  @RequestParam String address, @RequestParam String numberOfPhone,
                                  @RequestParam String inn, @RequestParam String kpp,
                                  @RequestParam String schet,
                                  @RequestParam (value = "countries") String countries, Model model) {
        long idDolzn = Long.parseLong(countries) ;

        var countryOptional = countryRepository.findById(idDolzn);
        provider newAccum = new provider(nameProvider,contact,address,numberOfPhone, inn, kpp, schet,countryOptional.get());
        providerRepository.save(newAccum);
        return "redirect:/provider-main";
    }

    @GetMapping("/provider/{id}")
    public String providerDetails(@PathVariable(value="id") long id, Model model) {
        if(!providerRepository.existsById(id)) {
            return "redirect:/provider-main";
        }

        Optional<provider> dolznostById = providerRepository.findById(id);
        ArrayList<provider> res = new ArrayList<>();
        dolznostById.ifPresent(res::add);
        model.addAttribute("provider", res);
        var d = dolznostById.get().getCountryIds().countryName;
        model.addAttribute("countryName", d);
        return "provider-details";
    }

    @GetMapping("/provider/{id}/edit")
    public String providerEdit(@PathVariable(value="id") long id, Model model) {
        if(!providerRepository.existsById(id)) {
            return "redirect:/provider-main";
        }
        Optional<provider> dolznostById = providerRepository.findById(id);
        ArrayList<provider> res = new ArrayList<>();
        dolznostById.ifPresent(res::add);
        model.addAttribute("provider", res);
        Iterable<country> dolznosts = countryRepository.findAll();
        model.addAttribute("countries", dolznosts);
        var dolzn = res.get(0).getCountryIds();
        model.addAttribute("country", dolzn);
        return "provider-edit";
    }

    @PostMapping("/provider/{id}/edit")
    public String providerPostUpdate(@PathVariable(value="id") long id, @RequestParam String nameProvider,
                                     @RequestParam String contact,
                                     @RequestParam String address, @RequestParam String numberOfPhone,
                                     @RequestParam String inn, @RequestParam String kpp,
                                     @RequestParam String schet,@RequestParam (value = "countries") String countries, Model model) {
        provider producerUpdate = providerRepository.findById(id).orElseThrow();
        producerUpdate.setName(nameProvider);
        producerUpdate.setContact(contact);
        producerUpdate.setAddress(address);
        producerUpdate.setInn(inn);
        producerUpdate.setKpp(kpp);
        producerUpdate.setNumberOfPhone(numberOfPhone);
        producerUpdate.setSchet(schet);
        long idCountry = Long.parseLong(countries) ;

        var dolxnost = countryRepository.findById(idCountry);
        producerUpdate.setCountryIds(dolxnost.get());
        providerRepository.save(producerUpdate);
        return "redirect:/provider-main";
    }

    @PostMapping("/provider/{id}/remove")
    public String providerPostDelete(@PathVariable(value="id") long id, Model model) {
        provider dolznostUpdate = providerRepository.findById(id).orElseThrow();
        providerRepository.delete(dolznostUpdate);
        return "redirect:/provider-main";
    }
}
