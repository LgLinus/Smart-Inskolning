package h.ghg.dstdsg.smartinskolning;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Activity displaying the routine of Smart inskolning.
 */
public class Activity_Routine extends Activity_Base {

    private TextView tvTitle;
    private TextView tvMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__routine);
        init();
    }

    /**
     * Initialize the activity
     */
    public void init(){
        tvTitle = (TextView)findViewById(R.id.tvRoutine_Title);
        tvMessage = (TextView)findViewById(R.id.tvRoutine_Message);
        super.init();
        tvTitle.setText(controller_menu.getDB().getMessage(Database_SQL.KEY_ROUTINE_TITLE));
        tvMessage.setText(controller_menu.getDB().getMessage(Database_SQL.KEY_ROUTINE_MESSAGE));
    }


}
