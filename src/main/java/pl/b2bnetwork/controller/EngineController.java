package pl.b2bnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.b2bnetwork.domain.Engine;
import pl.b2bnetwork.service.EngineService;

import javax.validation.Valid;

@RequestMapping("/engine")
@Controller
public class EngineController {

    @Autowired
    EngineService engineService;

    @GetMapping("/findall")
    public String findAll(Model model) {
        model.addAttribute("model", engineService.findAll());
        return "enginesList";
    }

    @PostMapping(name = "/add")
    public String addEngine(Model model, @ModelAttribute @Valid Engine engine, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "engineForm";
        } else {
            engineService.save(engine);
            model.addAttribute("engines", engineService.findAll());
            return "enginesList";
        }
    }

    @GetMapping(name ="/add")
    public String showForm(Model model){
        model.addAttribute("engine", new Engine());
        return "enginesList";
    }

    @GetMapping(name = "/delete")
    public String deleteEngine(Model model, @RequestParam Long id){
        engineService.delete(id);
        model.addAttribute("engines", engineService.findAll());
        return "enginesList";
    }

    @GetMapping(name = "/findone")
    public String findOne(Model model, @RequestParam Long id){
        engineService.findById(id);
        model.addAttribute("engines", engineService.findAll());
        return "enginesList";
    }
}
