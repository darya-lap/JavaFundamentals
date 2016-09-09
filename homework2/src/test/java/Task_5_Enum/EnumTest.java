package Task_5_Enum;

import org.junit.Test;

public class EnumTest {
    @Test
    public void IsStudentBelongToGroup(){
        Subject m = Subject.MATH_I;
        Subject h = Subject.HISTORY_D;
        Subject h1 = Subject.HISTORY_D;
        Student s1 = new Student("Tom",m,h);
        Student s2 = new Student("Emma", Subject.OOP_I, h1);
    }

}
