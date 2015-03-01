package h.ghg.dstdsg.smartinskolning;

import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.widget.TextView;


public class Activity_Equipment extends Activity_Base {

    private TextView tvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__equipment);
        init();
    }

    /**
     * Initialize the activity
     */
    public void init(){
        super.init();
        tvList = (TextView)findViewById(R.id.tvEquipment_list);
        /* Set the list text equal to the text from the database */
        tvList.setText(controller_menu.getValueFromDB(Database_SQL.KEY_EQUIPMENT_LIST));
        /* Parse the text as HTML, giving us underlines at <u> and newlines at <br&> tags*/
        tvList.setText(Html.fromHtml(String.format(tvList.getText().toString())));
        //tvList.setText(tvList.getText().toString().replace("\u2022","\n\u2022"));
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
