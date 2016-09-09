package Task_5_Enum;

import static Task_5_Enum.Group.MAX_SIZE;

public class Student {
    String name;
    Subject[] subjects = new Subject[MAX_SIZE];
    private int index = 0;
    Student(String name, Subject ... sub){
        this.name = name;
        for (Subject j: sub){
            subjects[index] = j;
            index++;
        }
    }


}

