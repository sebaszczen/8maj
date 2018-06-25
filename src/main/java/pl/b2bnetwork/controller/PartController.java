package pl.b2bnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.b2bnetwork.domain.Engine;
import pl.b2bnetwork.domain.Part;
import pl.b2bnetwork.service.EngineService;
import pl.b2bnetwork.service.PartService;

import javax.validation.Valid;

@RequestMapping("/part")
@Controller
public class PartController {

    @Autowired
    private PartService partService;
    @Autowired
    private EngineService engineService;

    @GetMapping("/findall")
    public String findAll(Model model) {
        model.addAttribute("parts", partService.findAll());
        return "partsList";
    }

//    @PostMapping("/delete")
//    public String delete(Model model, @ModelAttribute @Valid Part part, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "partForm";
//        } else {
//            partService.delete(part.getId());
//            model.addAttribute("parts", partService.findAll());
//            return "partsList";
//        }
//    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        partService.delete(id);
        model.addAttribute("parts", partService.findAll());
        return "partsList";
    }

    @PostMapping("/update/{id}")
    public String updatePart(Model model,@ModelAttribute @Valid Part part, @PathVariable Long id){
        Long id1=id;
        if (part.getName()==null && part.getEngine()==null && part.getYearProducion()==0) {
            model.addAttribute("updated",id);
            return "partEditForm";
        } else {
//            part.setId(id);
            partService.update(part,id1);
            model.addAttribute("parts", partService.findAll());
        }
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
        Engine engine = partService.findById(id).getEngine();
        engineService.update(engine);
        model.addAttribute("parts", partService.findAll());
        return "partsList";
    }

    @GetMapping("/findone")
    public String findOne(Model model, @RequestParam Long id) {
        model.addAttribute("parts", partService.findAll());
        return "partsList";
    }

}
