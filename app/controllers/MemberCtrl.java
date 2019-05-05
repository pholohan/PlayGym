package controllers;

import models.Assessment;
import models.Member;
import models.Trainer;
import play.Logger;
import play.mvc.Controller;

import java.util.List;

public class MemberCtrl extends Controller
{
    public static void index() {
        Logger.info("Rendering Trainer");
        Trainer trainer = Accounts.getLoggedInTrainer();
        List<Member> memberlist = trainer.memberlist;
        render("trainer.html", memberlist);
    }

    public static void findassessment(long id)
    {
        Member member = Member.findById(id);
        List<Assessment> assessmentlist = member.assessmentlist;
        double bmi = GymUtility.calcBmi(member.startingweight, member.height);
        String bmicat = GymUtility.bmiCat(bmi);
        String iwiColor = GymUtility.iwiCalc(member.startingweight, member.height, member.gender);
        int noOfAssessments = member.assessmentlist.size();
        Logger.info ("Member id = " + id);
        render("trainerdashboard.html", member, assessmentlist, bmi, bmicat, iwiColor);
    }

    public static void addComment(long id, String comment)
    {
        Assessment assessmentlist = Assessment.findById(id);
        assessmentlist.comment = comment;
        assessmentlist.save();
        Logger.info("Assessment id = ", + id);
        redirect("/trainer");
    }
}