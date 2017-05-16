package pl.eo.trainings.controllers;

import pl.eo.trainings.models.Invoicer;
import pl.eo.trainings.models.InvoicerData;
import pl.eo.trainings.models.InvoicerType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * IndexController - > InvoiceController
 */
@Controller
@RequestMapping("invoicer")
public class IndexController {

    // Request path: /invoicer
    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("invoice", InvoicerData.getAll());
        model.addAttribute("title", "Project Invoicer 16-05-2017");

        return "invoicer/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddInvoicerForm(Model model) {
        model.addAttribute("title", "Add Invoicer");
        model.addAttribute(new Invoicer());
        model.addAttribute("invoicerTypes", InvoicerType.values());
        return "invoicer/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddInvoicerForm(@ModelAttribute  @Valid Invoicer newInvoicer,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Invoicer");
            return "invoicer/add";
        }

        InvoicerData.add(newInvoicer);
        return "redirect:";
    }

    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveInvoicerForm(Model model) {
        model.addAttribute("invoice", InvoicerData.getAll());
        model.addAttribute("title", "Remove Invoicer");
        return "invoicer/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveInvoicerForm(@RequestParam int[] invoicerIds) {

        for (int invoicerId : invoicerIds) {
            InvoicerData.remove(invoicerId);
        }

        return "redirect:";
    }

}
