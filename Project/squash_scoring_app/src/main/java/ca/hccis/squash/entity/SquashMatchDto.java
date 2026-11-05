package ca.hccis.squash.entity;

import ca.hccis.squash.jpa.entity.SquashMatch;

import java.util.ArrayList;
import java.util.List;

public class SquashMatchDto {
    private List<SquashMatch> squashMatches;

    // default and parameterized constructor


    public SquashMatchDto() {
        squashMatches = new ArrayList<SquashMatch>();
    }

    public SquashMatchDto(List<SquashMatch> squashMatches) {
        this.squashMatches = squashMatches;
    }

    public void addSquashMatch(SquashMatch squashMatch) {
        this.squashMatches.add(squashMatch);
    }

    public List<SquashMatch> getSquashMatches() {
        return squashMatches;
    }

    public void setSquashMatches(List<SquashMatch> squashMatches) {
        this.squashMatches = squashMatches;
    }
}
