package h.ghg.dstdsg.smartinskolning;

import android.app.Activity;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by LgLinuss on 2015-03-01.
 */
public class Contact_Information {

    public static ArrayList<String> contact_name = new ArrayList<String>();
    public static ArrayList<String> contact_mail = new ArrayList<String>();
    public static ArrayList<String> contact_number = new ArrayList<String>();
    public static ArrayList<String> contact_image = new ArrayList<String>();
    public static ArrayList<String> contact_profession = new ArrayList<String>();

    public static void addContact(String name, String mail, String number, String image, String profession){
        contact_name.add(name);
        contact_mail.add(mail);
        contact_number.add(number);
        contact_image.add(image);
        contact_profession.add(profession);
    }

    public static void displayContacts(Activity activity){
        String res = "";
        for (int i = 0; i < contact_name.size();i++) {
            res+=contact_name.get(i) + contact_mail.get(i) +"\n";
        }
        Toast.makeText(activity.getApplicationContext(), res, Toast.LENGTH_SHORT).show();
    }

}
