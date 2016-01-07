package Controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 14.12.2015.
 */
public class MaskFinder {

        //Конвертирует сроку для работы с регулярными выражениями
        public String convert(String s){
            String mask="";
            String str;
            for(int i=0; i<s.length();i++ ){
                str = Character.toString(s.charAt(i));
                if (str.equals("?")){
                    mask+=".";
                }else
                if (str.equals("*")){
                    mask+="(\\D)+";
                }else
                if (str.equals(" ")){
                    mask+="(\\s)+";
                }else
                    mask+=str;
            }
           return mask;
        }

        public boolean find(String s, String fio) {
            return fio.matches(s);
        }
}
