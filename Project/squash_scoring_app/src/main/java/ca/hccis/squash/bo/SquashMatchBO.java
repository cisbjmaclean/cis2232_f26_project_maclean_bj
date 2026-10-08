package ca.hccis.squash.bo;

import ca.hccis.squash.jpa.entity.SquashMatch;
import ca.hccis.squash.dao.SkillsAssessmentSquashTechnicalDAO;
import ca.hccis.squash.dao.SquashMatchDAO;
import ca.hccis.squash.jpa.entity.SkillsAssessmentSquashTechnical;
import ca.hccis.squash.util.CisUtilityFile;

import java.util.ArrayList;

public class SquashMatchBO {

    public ArrayList<SquashMatch> processSelectAllByName(String name) {

        //**********************************************************************
        // This could be done using the repository but there will be times when
        // jdbc will be useful.  For the reports, the requirements state that you
        // are to use jdbc to obtain the data for the report.
        //**********************************************************************

        SquashMatchDAO squashMatchDAO = new SquashMatchDAO();
        ArrayList<SquashMatch> squashMatches = squashMatchDAO.selectAllByName(name);

        SkillsAssessmentSquashTechnicalDAO skillsAssessmentSquashTechnicalDAO = new SkillsAssessmentSquashTechnicalDAO();
        ArrayList<SkillsAssessmentSquashTechnical> assessments = skillsAssessmentSquashTechnicalDAO.selectAllByAthleteAssessorName(name);

//        //Also write the report to a file
//        CisUtilityFile.writeReportToFile("athleteAssessorNameReport", assessments);

        return squashMatches;
    }


}
