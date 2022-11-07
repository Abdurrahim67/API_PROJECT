package homework.homework_test_data;

import java.util.HashMap;
import java.util.Map;

public class HW_RegresTestData {

    public Map<String,String> regresDataMethod(String name,String job ){

        Map<String,String>regresDataMap=new HashMap<>();
        regresDataMap.put("name",name);
        regresDataMap.put("job",job);


        return regresDataMap;


    }


}
