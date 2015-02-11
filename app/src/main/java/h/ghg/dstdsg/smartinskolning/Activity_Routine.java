package h.ghg.dstdsg.smartinskolning;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;


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
        this.menu_button = (ImageButton)findViewById(R.id.ibMenu);
        tvTitle = (TextView)findViewById(R.id.tvRoutine_Title);
        tvMessage = (TextView)findViewById(R.id.tvRoutine_Message);
        super.init();
        tvTitle.setText(controller_menu.getDB().getMessage(Database_SQL.KEY_ROUTINE_TITLE));
        tvMessage.setText(controller_menu.getDB().getMessage(Database_SQL.KEY_ROUTINE_MESSAGE));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity__routine, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
