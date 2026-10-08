package ca.hccis.squash.entity;

import ca.hccis.squash.SquashMatch;
import ca.hccis.squash.jpa.entity.SkillsAssessmentSquashTechnical;

import java.util.ArrayList;

/**
 * Entity class to hold the attributes of the reports.
 * @author bjmaclean
 * @since 20261008
 */
public class ReportSquash {
    private String name;
    private ArrayList<SquashMatch> squashMatches;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<SquashMatch> getSquashMatches() {
        return squashMatches;
    }

    public void setSquashMatches(ArrayList<SquashMatch> squashMatches) {
        this.squashMatches = squashMatches;
    }
}
