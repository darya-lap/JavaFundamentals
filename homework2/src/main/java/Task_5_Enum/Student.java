package Task_5_Enum;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Student {
    private String nameOfStudent;
    private Map <Group,Grade> grades;

    Student (String name){
        nameOfStudent = name;
        grades = new HashMap<Group, Grade>();
    }

    public void setGrade(Group group, int grade){
        if (group.isInt()){
            IntGrade intGrade = new IntGrade(this, group);
            intGrade.setGrade(grade);
            grades.put(group, intGrade);
            group.setGrade(this,intGrade);
        }
        else {
            DoubleGrade doubleGrade = new DoubleGrade(this, group);
            doubleGrade.setGrade(grade);
            grades.put(group, doubleGrade);
            group.setGrade(this,doubleGrade);
        }
    }

    public void setGrade(Group group, double grade){
        DoubleGrade doubleGrade = new DoubleGrade(this, group);
        doubleGrade.setGrade(grade);
        grades.put(group, doubleGrade);
        group.setGrade(this, doubleGrade);
    }

    public Map<Group,Grade> getGrades(){
        return this.grades;
    }

    public String getNameOfStudent(){
        return nameOfStudent;
    }

    public Set<Group> getStudentGroups(){
        Set<Group> groups = grades.keySet();
        return groups;
    }

    public boolean isBelongToGroup(Group name) {
        for (Group j: grades.keySet()) {
            if (j.equals(name)) return true;
        }
        return false;
    }



}

