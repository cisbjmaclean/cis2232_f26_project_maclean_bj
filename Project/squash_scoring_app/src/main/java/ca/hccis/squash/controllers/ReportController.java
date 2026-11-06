package ca.hccis.squash.controllers;

import ca.hccis.squash.bo.ReportBO;
import ca.hccis.squash.entity.SquashMatchScoreSummary;
import ca.hccis.squash.jpa.entity.SquashMatch;
import ca.hccis.squash.bo.SquashMatchBO;
import ca.hccis.squash.entity.ReportInput;
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
     * Handles the base /report endpoint - displays the main reports list page.
     *
     * This is the entry point for the reports section, showing users a menu of
     * available reports they can run (player name report, player score report, etc.)
     *
     * @param model Spring MVC model for passing data to the view
     * @param session HTTP session for storing request-scoped data
     * @return View name "report/list" - the reports landing page
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
     * Handles GET request to /report/player/name - displays the player name search form.
     *
     * This endpoint allows users to search for squash matches by player name.
     * It initializes an empty ReportInput object and passes it to the view for form rendering.
     *
     * @param model Spring MVC model for passing data to the view
     * @return View name "report/reportPlayerName" - the player name search form
     * @author BJM
     * @since 2025-10-06
     */
    @RequestMapping("/player/name")
    public String reportPlayerName(Model model) {
        logger.info("Running the reports controller player score method");
        // Initialize empty form object for the view
        model.addAttribute("reportInput", new ReportInput());
        return "report/reportPlayerName";
    }


    /**
     * Handles POST request to /report/player/name/submit - processes the player name search.
     *
     * This endpoint receives the form submission with a player name, queries the database
     * for all matches involving that player, and returns the results to be displayed.
     * If no matches are found, an error message is added to the model.
     *
     * @param model Spring MVC model for passing data to the view
     * @param reportInput Form data containing the player name to search for
     * @return View name "report/reportPlayerName" - same page with results or error message
     * @author BJM
     * @since 2025-10-06
     */
    @RequestMapping("/player/name/submit")
    public String reportPlayerNameSubmit(Model model, @ModelAttribute("reportInput") ReportInput reportInput) {

        // Log the name submitted from the form for debugging
        System.out.println("Name from input form:" + reportInput.getName());

        // Create BO instance to access business logic for fetching matches
        SquashMatchBO squashMatchBO = new SquashMatchBO();
        // Fetch all matches for the specified player name
        ArrayList<SquashMatch> theList = squashMatchBO.processSelectAllByName(reportInput.getName());
        // Store the results back in the ReportInput object for the view
        reportInput.setSquashMatches(theList);

        // Check if no matches were found and add user-friendly message
        if (theList != null && theList.isEmpty()) {
            model.addAttribute("message", "No matches found for that name");
            System.out.println("BJM - no data found");
        }

        // Pass the ReportInput object (with results) to the view for display
        model.addAttribute("reportInput", reportInput);

        return "report/reportPlayerName"; // Re-render the same page with results
    }

    /**
     * Handles GET request to /report/player/score - displays the player score report page.
     *
     * This endpoint prepares a dropdown/list of all players in the system by fetching
     * all player names from the database and storing them in the session. This allows
     * users to select a player and view their scoring history.
     *
     * @param model Spring MVC model for passing data to the view
     * @param session HTTP session for storing the player list across requests
     * @return View name "report/reportPlayerScore" - the player score report form
     * @author BJM
     * @since 2026-10-16
     */
    @RequestMapping("/player/score")
    public String reportPlayerScore(Model model, HttpSession session) {
        logger.info("Running the reports controller player score method");

        // Create BO instance to access business logic
        SquashMatchBO squashMatchBO = new SquashMatchBO();
        // Fetch all unique player names from the database
        ArrayList<String> players = squashMatchBO.getAllPlayerNames();
        // Store player list in session for use in the view (dropdown/populated list)
        session.setAttribute("players", players);

        // Initialize empty form object for the view
        model.addAttribute("reportInput", new ReportInput());
        return "report/reportPlayerScore";
    }

    /**
     * Handles POST request to /report/player/score/submit - processes the player score report.
     *
     * This endpoint receives the form submission with player selection, calls the Business
     * Object layer to calculate and retrieve score summaries for that player, and returns
     * the results for display. Includes empty result handling with user-friendly messaging.
     *
     * @param model Spring MVC model for passing data to the view
     * @param reportInput Form data containing the player name for the score report
     * @return View name "report/reportPlayerScore" - same page with results or error message
     * @author BJM
     * @since 2026-10-19
     */
    @RequestMapping("/player/score/submit")
    public String reportPlayerScoreSubmit(Model model, @ModelAttribute("reportInput") ReportInput reportInput) {

        // Log the name submitted from the form for debugging
        System.out.println("Name from input form:" + reportInput.getName());

        // Call BO layer to process the player score report and populate reportInput with results
        ReportBO.processPlayerScoreReport(reportInput);

        // Check if no matches were found and add user-friendly message
        if (reportInput.getSquashMatches() != null && reportInput.getSquashMatches().isEmpty()) {
            model.addAttribute("message", "No matches found for that name");
            System.out.println("BJM - no data found");
        }

        // Pass the ReportInput object back to the view for form preservation
        model.addAttribute("reportInput", reportInput);
        // Pass the calculated score summaries for display in the report table
        model.addAttribute("squashMatchScoreSummaries", reportInput.getSquashMatchScoreSummaries());

        return "report/reportPlayerScore"; // Re-render the same page with results
    }


}
