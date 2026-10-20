package ca.hccis.squash.entity;

import ca.hccis.squash.jpa.entity.SquashMatch;

import java.util.ArrayList;

/**
 * Entity class to hold the attributes of the reports.
 * @author bjmaclean
 * @since 20261008
 */
public class ReportInput {
    private String name;
    private String startDate;
    private String endDate;

    private ArrayList<SquashMatchScoreSummary> squashMatchScoreSummaries;
    private ArrayList<SquashMatch> squashMatches;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public ArrayList<SquashMatchScoreSummary> getSquashMatchScoreSummaries() {
        return squashMatchScoreSummaries;
    }

    public void setSquashMatchScoreSummaries(ArrayList<SquashMatchScoreSummary> squashMatchScoreSummaries) {
        this.squashMatchScoreSummaries = squashMatchScoreSummaries;
    }

    public ArrayList<SquashMatch> getSquashMatches() {
        return squashMatches;
    }

    public void setSquashMatches(ArrayList<SquashMatch> squashMatches) {
        this.squashMatches = squashMatches;
    }
}
