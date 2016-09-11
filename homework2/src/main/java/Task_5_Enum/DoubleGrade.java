package Task_5_Enum;

public class DoubleGrade extends Grade{
    double grade;
    DoubleGrade(Student s, Group g){
        super(s,g);
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
