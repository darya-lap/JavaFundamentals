package Task_2_Map;

import java.util.*;

public class UniversalPropertiesMap {
    private Map<Locale,ArrayList<String>> map;

    UniversalPropertiesMap(){
        map = new HashMap<>();
        for (Locale m : createLocaleList()){
            ResourceBundle bundle = ResourceBundle.getBundle("prop", m);
            ArrayList<String> listOfValues = new ArrayList<>();
            for (String s: bundle.keySet()){
                listOfValues.add(bundle.getString(s));
            }
            map.put(m,listOfValues);
        }
    }

    private Set<Locale> createLocaleList(){
        Set<Locale> localies = new HashSet<>();
        localies.add(new Locale("en_EN"));
        localies.add(new Locale("en_US"));
        localies.add(new Locale("fr_FR"));
        return localies;
    }

    public ArrayList<String> getSetResources(Locale l){
       return map.get(l);
    }

    public String getResourse(Locale l, int i){
        try {
            return map.get(l).get(i - 1);
        }
        catch(IndexOutOfBoundsException e){
            e.printStackTrace();
            return null;
        }
    }

    public Set<Locale> getLocalies(){
        return map.keySet();
    }
}
