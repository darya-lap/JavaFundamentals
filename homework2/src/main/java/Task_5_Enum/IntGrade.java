package Task_5_Enum;

public class IntGrade extends Grade{
    int grade;
    IntGrade(Student s, Group g){
        super(s,g);
    }

    public void setGrade(int g){
        this.grade = g;
    }
}
