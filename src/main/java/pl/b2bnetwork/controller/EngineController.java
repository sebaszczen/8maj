package pl.b2bnetwork.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.b2bnetwork.domain.Engine;
import pl.b2bnetwork.domain.Part;
import pl.b2bnetwork.repository.PartRepository;
import pl.b2bnetwork.service.EngineService;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.List;

@RequestMapping("/engine")
@Controller
public class EngineController {

    @Autowired
    private EngineService engineService;
    @Autowired
    private PartRepository partRepository;

    @GetMapping("/findall")
    public String findAll(Model model) {
        model.addAttribute("engines", engineService.findAll());
        return "enginesList";
    }

    @PostMapping("/add")
    public String addEngine(Model model, @ModelAttribute @Valid Engine engine, BindingResult bindingResult,
                            @RequestParam Long[] id) {
        if (bindingResult.hasErrors()) {
            return "engineForm";
        } else {
            engineService.save(engine, id);
            model.addAttribute("engines", engineService.findAll());
            return "enginesList";
        }
    }

    @GetMapping("/add")
    public String showForm(Model model) {
        model.addAttribute("engine", new Engine());
        model.addAttribute("partsList", partRepository.findAll());
        return "engineForm";
    }

    @GetMapping("/delete")
    public String deleteEngine(Model model, @RequestParam Long id) {
        engineService.delete(id);
        model.addAttribute("engines", engineService.findAll());
        return "enginesList";
    }

    @GetMapping("/findone")
    public String findOne(Model model, @RequestParam Long id) {
        model.addAttribute("engines", engineService.findAll());
        return "enginesList";
    }
//    @PostMapping("/addParts")
//    public String addParts(Model model, @RequestParam List<Part> parts){
//        model.addAttribute("")
//    }
}
