package ca.hccis.squash.controllers;

import ca.hccis.squash.jpa.entity.SquashMatch;
import ca.hccis.squash.bo.SkillsAssessmentSquashTechnicalBO;
import ca.hccis.squash.bo.SquashMatchBO;
import ca.hccis.squash.dao.SkillsAssessmentSquashTechnicalDAO;
import ca.hccis.squash.entity.ReportSquash;
import ca.hccis.squash.jpa.entity.SkillsAssessmentSquashTechnical;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Controller to administer reports of the project.
 *
 * @author BJM
 * @since 20251009
 */
@Controller
@RequestMapping("/report")
public class ReportController {

    private static final Logger logger = LoggerFactory.getLogger(ReportController.class);

    /**
     * Send the user to list of reports view.
     *
     * @param model
     * @param session
     * @return To the appropriate view
     * @author BJM
     * @since 20251009
     */
    @RequestMapping("")
    public String home(Model model, HttpSession session) {

        //BJM 20200602 Issue#1 Set the current date in the session
        logger.info("Running the reports controller base method");
        return "report/list";
    }

    /**
     * Method to send user to the athlete/assessor name report.
     *
     * @param model
     * @return view for list
     * @author BJM
     * @since 2025-10-06
     */
    @RequestMapping("/player/name")
    public String reportSquashName(Model model) {
        logger.info("Running the reports controller player name method");
        model.addAttribute("reportInput",new ReportSquash());
        return "report/reportPlayerName";
    }


    /**
     * Process the report - name
     *
     * @param model
     * @param reportSquash Object containing inputs for the report
     * @return view to show report
     * @author BJM
     * @since 2025-10-06
     */
    @RequestMapping("/player/name/submit")
    public String reportSquashNameSubmit(Model model, @ModelAttribute("reportInput") ReportSquash reportSquash) {

        System.out.println("Name from input form:"+reportSquash.getName());

        //Write some model code to go to the db and get the appropriate assessments
        //Add them to a collection in the ReportSquash class

        SquashMatchBO squashMatchBO = new SquashMatchBO();
        ArrayList<SquashMatch> theList = squashMatchBO.processSelectAllByName(reportSquash.getName());
        reportSquash.setSquashMatches(theList);

        //Add a message in case the report does not contain any data
        if (theList != null && theList.isEmpty()) {
            model.addAttribute("message", "No matches found for that name");
            System.out.println("BJM - no data found");
        }

        //Put object in model so it can be used on the view (html)
        model.addAttribute("reportInput", reportSquash);

        return "report/reportPlayerName"; //Send user to another view.
    }


}
