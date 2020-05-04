
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vuvie
 */
public class main {
    public static void main(String[] arge) {
        String string = "abc.def";
        String[] result = string.split(Pattern.quote("."));
        System.out.println("Length: " + result.length);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
