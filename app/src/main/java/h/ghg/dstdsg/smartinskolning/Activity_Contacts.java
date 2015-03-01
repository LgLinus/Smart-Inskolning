package h.ghg.dstdsg.smartinskolning;

import android.os.Bundle;
import android.widget.TextView;

/*
* Activity displaying contact information
 */
public class Activity_Contacts extends Activity_Base {

    private TextView tvMail,tvPhone,tvAddress,
        tvSick,tvMap,tvOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__contacts);
        init();
        loadText();
    }

    /**
     * Initialize the activity
     */
    public void init(){
        super.init();

        tvMail = (TextView)findViewById(R.id.tvContact_Mail_Info);
        tvPhone = (TextView)findViewById(R.id.tvContact_Phone_Info);
        tvAddress = (TextView)findViewById(R.id.tvContact_Address_Info);
        tvSick = (TextView)findViewById(R.id.tvContact_Sick_Info);
        tvMap = (TextView)findViewById(R.id.tvContact_Map_Info);
        tvOpen = (TextView)findViewById(R.id.tvContact_Open_Info);
    }

    /*
        Change the text in the activity from values from the database
     */
    public void loadText(){
        tvMail.setText(controller_menu.getValueFromDB(Database_SQL.KEY_MAIL));
        tvPhone.setText(controller_menu.getValueFromDB(Database_SQL.KEY_NUMBER));
        tvAddress.setText(controller_menu.getValueFromDB(Database_SQL.KEY_ADDRESS));
        tvSick.setText(controller_menu.getValueFromDB(Database_SQL.KEY_NUMBER));
        tvMap.setText(controller_menu.getValueFromDB(Database_SQL.KEY_LOCATION));
        tvOpen.setText(controller_menu.getValueFromDB(Database_SQL.KEY_OPEN));
    }
}
