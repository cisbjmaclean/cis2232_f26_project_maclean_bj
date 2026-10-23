package ca.hccis.squash.controllers;

import ca.hccis.squash.jpa.entity.SquashMatch;
import ca.hccis.squash.repositories.SquashMatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String home() {

        for(SquashMatch current: _smr.findAll()){
            logger.info(current.toString());
            current.setMatchDate("2026-10-23");
            _smr.save(current);
        }


        return "other/about";
    }

}
