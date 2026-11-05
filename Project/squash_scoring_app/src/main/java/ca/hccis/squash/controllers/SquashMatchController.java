package ca.hccis.squash.controllers;

import ca.hccis.squash.bo.SkillsAssessmentSquashTechnicalBO;
import ca.hccis.squash.bo.SkillsAssessmentSquashTechnicalValidationBO;
import ca.hccis.squash.bo.SquashMatchBO;
import ca.hccis.squash.entity.SkillsAssessmentSquashTechnicalDto;
import ca.hccis.squash.entity.SquashMatchDto;
import ca.hccis.squash.jpa.entity.SkillsAssessmentSquashTechnical;
import ca.hccis.squash.jpa.entity.SquashMatch;
import ca.hccis.squash.repositories.SquashMatchRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Optional;

/**
 * Controller to administer crud. Note that the code was taken from
 * Fred Campos' project from 2021 which also had modifications from Ferhad in
 * 2022.
 *
 * @author BJM
 * @since 20261023
 */
@Controller
@RequestMapping("/squashmatch")
public class SquashMatchController {

    private final SquashMatchRepository _smr;

    @Autowired
    public SquashMatchController(SquashMatchRepository smr) {
        _smr = smr;
    }

    @Autowired
    private MessageSource messageSource;
    private static final Logger logger = LoggerFactory.getLogger(SquashMatchController.class);

    @RequestMapping("")
    public String home(Model model) {
        Iterable<SquashMatch> squashMatches = _smr.findAll();
        model.addAttribute("squashMatches",squashMatches);
        return "squashmatch/list";
    }

    /**
     * Page to edit
     *
     * @param id    ID
     * @param model
     * @author BJM
     * @since 20251201
     */
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model, HttpSession session) {

        Optional squashMatch = _smr.findById(id);
        if (squashMatch.isPresent()) {
            model.addAttribute("squashMatch", squashMatch.get());
            return "squashmatch/add";
        }

        //todo How can we best communcicate this to the view.
        model.addAttribute("messageError", "Could not load the matches");
        Iterable<SquashMatch> squashMatches = _smr.findAll();
        model.addAttribute("squashMatches", squashMatches);
        model.addAttribute("squashMatch", new SquashMatch());
        return "squashmatch/list";
    }

    /**
     * Submit method that processes add and edit and any form submission
     *
     * @param model
     * @param request
     * @param squashMatch what is being added or modified
     * @param bindingResult                   Result of SQL
     * @return add with errors or busPass
     * @author CIS2232
     * @since 20251201
     */
    @RequestMapping("/submit")
    public String submit(Model model, HttpServletRequest request, @Valid @ModelAttribute("squashMatch") SquashMatch squashMatch, BindingResult bindingResult) {
        boolean valid = true;

        //Sprint 5 business validation
//        ArrayList<String> validationErrors = SkillsAssessmentSquashTechnicalValidationBO.validateAssessmentDate(skillsAssessmentSquashTechnical);
//        if (validationErrors.size() > 0) {
//            valid = false;
//        }

        if (!valid || bindingResult.hasErrors()) {
            System.out.println("--------------------------------------------");
            System.out.println("Validation error - BJM");
            for (ObjectError error : bindingResult.getAllErrors()) {
                System.out.println(error.getObjectName() + "-" + error.toString() + "-" + error.getDefaultMessage());
            }
            System.out.println("--------------------------------------------");
//            skillsAssessmentSquashTechnical.setTechnicalScore(0);
            model.addAttribute("squashMatch", squashMatch);
            //model.addAttribute("businessValidationErrorsAssessmentDate", validationErrors);
            return "squashmatch/add";
        }

        //BJM 20251124 calculate the score before saving.
        //SkillsAssessmentSquashTechnicalBO.calculateTechnicalScore(skillsAssessmentSquashTechnical);
        _smr.save(squashMatch);
        return "redirect:/squashmatch";
    }

    @RequestMapping("/list/edit")
    public String showCreateForm(Model model) {
        SquashMatchDto squashMatchForm = new SquashMatchDto();

        Iterable<SquashMatch> squashMatches = _smr.findAll();
        ArrayList<SquashMatch> tempList = new ArrayList<>();
        for (SquashMatch current : squashMatches) {
            tempList.add(current);
        }
        squashMatchForm.setSquashMatches(tempList);
        model.addAttribute("form", squashMatchForm);
        return "squashmatch/listedit";
    }

    @RequestMapping("/list/edit/submit")
    public String listEditSubmit(@ModelAttribute SquashMatchDto form, Model model) {

        //TODO calculate winners before saving

        for(SquashMatch current: form.getSquashMatches()){
            current.setWinnerName(SquashMatchBO.determineWinner(current));
        }

        _smr.saveAll(form.getSquashMatches());

        SquashMatchDto squashMatchForm = new SquashMatchDto();

        Iterable<SquashMatch> squashMatches = _smr.findAll();
        ArrayList<SquashMatch> tempList = new ArrayList<>();
        for (SquashMatch current : squashMatches) {
            tempList.add(current);
        }
        squashMatchForm.setSquashMatches(tempList);
        model.addAttribute("form", squashMatchForm);
        return "squashmatch/listedit";

    }

}
