package h.ghg.dstdsg.smartinskolning;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.TextView;


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
        this.menu_button = (ImageButton)findViewById(R.id.ibMenu);
        tv_Title = (TextView)(findViewById(R.id.tvWelcomeTitle));
        tv_Message = (TextView)(findViewById(R.id.tvWelcomeMessage));
        super.init();
        tv_Title.setText(this.controller_menu.getDB().getMessage(Database_SQL.KEY_WELCOME_TITLE));
        tv_Message.setText(this.controller_menu.getDB().getMessage(Database_SQL.KEY_WELCOME_MESSAGE));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_activity__welcome, menu);
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
