package h.ghg.dstdsg.smartinskolning;

import android.os.Bundle;
import android.widget.TextView;

/*
/* Activity displayed once the user logsin. Displaying a simple welcome message
 */
public class Activity_Welcome extends Activity_Base {

    private TextView tv_Title;
    private TextView tv_Message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__welcome);
        init();
    }

    /**
     * Initialize the activity
     */
    public void init(){
        tv_Title = (TextView)(findViewById(R.id.tvWelcomeTitle));
        tv_Message = (TextView)(findViewById(R.id.tvWelcomeMessage));
        super.init();
        tv_Title.setText(this.controller_menu.getDB().getMessage(Database_SQL.KEY_WELCOME_TITLE));
        tv_Message.setText(this.controller_menu.getDB().getMessage(Database_SQL.KEY_WELCOME_MESSAGE));
    }

}
