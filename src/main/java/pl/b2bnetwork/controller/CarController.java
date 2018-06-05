package pl.b2bnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.b2bnetwork.domain.Car;
import pl.b2bnetwork.repository.EngineRepository;
import pl.b2bnetwork.service.CarService;
import pl.b2bnetwork.service.EngineService;

import javax.validation.Valid;

@RequestMapping("/car")
@Controller
public class CarController {

    @Autowired
    private CarService carService;
    @Autowired
    private EngineRepository engineRepository;

    @GetMapping("/findall")
    public String findAll(Model model){
        model.addAttribute("cars", carService.findAll());
        return "carsList";
    }

    @PostMapping("/add")
    public String addCar(Model model, @ModelAttribute @Valid Car car, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "carForm";
        } else {
            carService.save(car);
            model.addAttribute("cars", carService.findAll());
            return "carsList";
        }
    }

    @GetMapping("/add")
    public String showForm(Model model){
        model.addAttribute("car", new Car());
        model.addAttribute("engineList",engineRepository.findAll());
        return "carForm";
    }

    @GetMapping("/delcar")
    public String delCar(Model model, @RequestParam Long id){
        carService.delete(id);
        model.addAttribute("cars", carService.findAll());
        return "carsList";
    }

}
