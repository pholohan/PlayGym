package controllers;

import models.Assessment;
import models.Member;
import models.Trainer;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class Dashboard extends Controller {
    public static void index() {
        Logger.info("Rendering Dashboard");
        Member member = Accounts.getLoggedInMember();
        List<Assessment> assessmentlist = member.assessmentlist;
        double bmi = GymUtility.calcBmi(member.startingweight, member.height);
        String bmicat = GymUtility.bmiCat(bmi);
        String iwiColor = GymUtility.iwiCalc(member.startingweight, member.height, member.gender);
        render("dashboard.html", member, assessmentlist, bmi, bmicat, iwiColor);
    }


    public static void addAssessment(double weight, double chest, double thigh, double upperarm, double waist, double hips, String comment) {
        Member member = Accounts.getLoggedInMember();
        Assessment assessment = new Assessment(weight, chest, thigh, upperarm, waist, hips, comment);
        member.assessmentlist.add(assessment);
        assessment.save();
        Logger.info("Adding Assessment");
        redirect("/dashboard");
    }

}
