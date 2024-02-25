package com.example.turistguidev2.controller;

import com.example.turistguidev2.model.TouristAttraction;
import com.example.turistguidev2.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("attractions")
public class TouristController {
    private TouristService touristService;

    public TouristController(TouristService touristService){
        this.touristService = touristService;
    }

    @GetMapping("")
    public String getAttractions(Model model){
        model.addAttribute("attractions", touristService.getTouristAttractionList());
        return "attractionList";
    }

    @GetMapping("/{name}/tags")
    public String tags(@PathVariable("name") String name, Model model){
        model.addAttribute("tags", touristService.attractionTagsList(name));
        return "tags";
    }


    @GetMapping("/add")
    public String addAttraction(Model model){
        model.addAttribute("attractionAdd", new TouristAttraction());
        model.addAttribute("attractionCities", touristService.getAttractionCities());
        model.addAttribute("attractionTags", touristService.getAttractionTags());
        return "add";
    }

    @PostMapping("/add")
    public String addedAttraction(@ModelAttribute TouristAttraction touristAttraction){
        touristService.addTouristAttraction(touristAttraction);
        return "redirect:/attractions";
    }

    @GetMapping("/{name}/updateAttraction")
    public String updateAttraction(@PathVariable("name") String name, Model model){
        TouristAttraction touristAttraction = touristService.getTouristAttraction(name);

        model.addAttribute("update", touristService.getTouristAttraction(name));
        model.addAttribute("attractionTags", touristService.getAttractionTags());
        return "update";
    }

    @PostMapping("/updateAttraction")
    public String updatedAttraction(@ModelAttribute TouristAttraction updatedTouristAttraction){
        touristService.updateAttraction(updatedTouristAttraction.getName(), updatedTouristAttraction);
        return "redirect:/attractions";
    }

    @GetMapping("/{name}/delete")
    public String deleteAttraction(@PathVariable("name") String name){
        touristService.deleteTouristAttraction(name);
        return "redirect:/attractions";
    }
}

