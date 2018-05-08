package pl.b2bnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.b2bnetwork.domain.Part;
import pl.b2bnetwork.service.PartService;

import javax.validation.Valid;

@RequestMapping("/part")
@Controller
public class PartController {

    @Autowired
    private PartService partService;

    @GetMapping("/findall")
    public String findAll(Model model) {
        model.addAttribute("parts", partService.findAll());
        return "partsList";
    }

    @PostMapping("/add")
    public String addEngine(Model model, @ModelAttribute @Valid Part part, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "partForm";
        } else {
            partService.save(part);
            model.addAttribute("parts", partService.findAll());
            return "partsList";
        }
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("part", new Part());
        return "partForm";
    }

    @GetMapping("/delete")
    public String deleteEngine(Model model, @RequestParam Long id) {
        partService.delete(id);
        model.addAttribute("parts", partService.findAll());
        return "partsList";
    }

    @GetMapping("/findone")
    public String findOne(Model model, @RequestParam Long id) {
        model.addAttribute("parts", partService.findAll());
        return "partsList";
    }

}
