package Task_5_Enum;

import java.util.HashMap;
import java.util.Map;

enum Group implements IsInt {
    MATH_I{
        @Override
        public boolean isInt() {
            return true;
        }
        @Override
        public String getGroupName(){
            return "Math";
        }
    },
    OOP_I{
        @Override
        public boolean isInt() {
            return true;
        }
        @Override
        public String getGroupName(){
            return "OOP";
        }
    },
    WEB_D{
        @Override
        public String getGroupName(){
            return "Web";
        }
    },
    HISTORY_D{
        @Override
        public String getGroupName(){
            return "History";
        }
    };

    Map<Student, Grade> grades = new HashMap<>() ;

    @Override
    public boolean isInt() {
        return false;
    }

    public Group getGroup(){return this;}
    public String getGroupName(){return "";};

    public Map<Student, Grade> getGrades(){
        return this.grades;
    }

    public void setGrade(Student student, Grade grade){
        grades.put(student,grade);
    }

}
