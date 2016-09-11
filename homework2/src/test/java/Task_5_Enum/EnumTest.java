package Task_5_Enum;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class EnumTest {
    @Test
    public void StudentBelongToGroup(){
        Group math = Group.MATH_I;
        Group web = Group.WEB_D;
        Student s1 = new Student("Emma");
        s1.setGrade(math, 4);
        Student s2 = new Student("Mark");
        s2.setGrade(math, 3);
        s1.setGrade(web, 7);
        assertEquals(s1.isBelongToGroup(Group.MATH_I),true);
    }

    @Test
    public void StudentDoesNotBelongToGroup(){
        Group math = Group.MATH_I;
        Group web = Group.WEB_D;
        Group oop = Group.OOP_I;
        Group history = Group.HISTORY_D;
        Student s1 = new Student("Emma");
        Student s2 = new Student("Robby");
        Student s3 = new Student("Bob");
        s1.setGrade(web, 4);
        s1.setGrade(math, 5);
        s1.setGrade(history, 5.4);
        s2.setGrade(math, 3);
        s2.setGrade(oop, 4);
        s3.setGrade(web, 3);
        assertEquals(s2.isBelongToGroup(web),false);
        assertEquals(s1.isBelongToGroup(math),true);
    }


}
