package ru.specialist.demo.models.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.specialist.demo.models.Repositories.AccumRepository;
import ru.specialist.demo.models.Repositories.SaleRepository;
import ru.specialist.demo.models.typeDispl;

public class SaleController {

    @Autowired
    private SaleRepository accumRepository;

    @GetMapping("/sale-main")
    public String typeDispMain(Model model) {

        return "sale-main";
    }

    @GetMapping("/products")
    public String reportMain(Model model) {

        return "products";
    }
}
