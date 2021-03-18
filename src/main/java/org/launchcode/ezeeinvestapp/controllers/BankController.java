package org.launchcode.ezeeinvestapp.controllers;

import org.launchcode.ezeeinvestapp.models.Bank;
import org.launchcode.ezeeinvestapp.models.data.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("banks")
public class BankController {

    @Autowired
    private BankRepository skillsRepository;

    @GetMapping("add")
    public String displayAddSkillsForm(Model model) {
        model.addAttribute(new Bank());
        return "banks/add";
    }

    @PostMapping("add")
    public String processAddSkillsForm(@ModelAttribute @Valid Bank newBank,
                                       Errors errors, Model model) {

        if (errors.hasErrors()) {
            return "banks/add";
        }
        skillsRepository.save(newBank);
        return "redirect:../add";
    }

    @GetMapping("view/{skillId}")
    public String displayViewSkills(Model model, @PathVariable int skillId) {

        Optional optSkill = skillsRepository.findById(skillId);
        if (optSkill.isPresent()) {
            Bank bank = (Bank) optSkill.get();
            model.addAttribute("bank", bank);
            return "banks/view";
        } else {
            return "redirect:../";
        }
    }


}