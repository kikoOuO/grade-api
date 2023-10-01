package use_case;
import api.GradeDB;
import entity.Grade;
import entity.Team;

public final class GetAverageGradeUseCase {
    private final GradeDB gradeDB;

    public GetAverageGradeUseCase(GradeDB gradeDB) {
        this.gradeDB = gradeDB;
    }

    public float getAverageGrade(String course) {
        Team myteam = gradeDB.getMyTeam();
        String[] member = myteam.getMembers();
        float obj = 0.0f;
        for (int i = 0; i < member.length; i++) {
            obj += gradeDB.getGrade(member[i], course).getGrade();
        }
        return obj/ member.length;
    }
}
