package Task_2_Locale_ResourceBundle;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceProperty{

    private ResourceBundle resourceBundle;
    private int amountOfQuestions = 4;

    public ResourceProperty(Locale locale) {
        resourceBundle = ResourceBundle.getBundle("prop", locale);
    }

    public String getQuestion(Integer number){
        return resourceBundle.getString("question" + number.toString());
    }

    public String getAnswer(Integer number){
        return resourceBundle.getString("answer" + number.toString());
    }

    public String getAllQuestions(){
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= amountOfQuestions; i++){
            if (i != 1) str.append("\n");
            str.append(i + ". " + this.getQuestion(i));
        }
        return  str.toString();
    }

}
