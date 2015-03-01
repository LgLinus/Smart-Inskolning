package h.ghg.dstdsg.smartinskolning;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Activity displaying the schedule of Smart inskolning.
 */
public class Activity_Schedule extends Activity_Base {

    /* Textviews used for describing the activities for each day */
    private TextView tvActivity1, tvActivity2, tvActivity3, tvActivity4
        ,tvActivity5, tvActivity6, tvActivity7;

    /* TextViews used for describing the schedule each day */
    private TextView tvTime1, tvTime2, tvTime3, tvTime4, tvTime5
            , tvTime6, tvTime7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__schedule);
        init();
        writeValues();
    }

    public String getString(String key){
        String res="";

        return res;
    }

    public void writeValues(){
        tvActivity1.setText(controller_menu.getValueFromDB(Database_SQL.KEY_SCHEDULE_DAY1_ACTIVITY));
        tvActivity2.setText(controller_menu.getValueFromDB(Database_SQL.KEY_SCHEDULE_DAY2_ACTIVITY));
        tvActivity3.setText(controller_menu.getValueFromDB(Database_SQL.KEY_SCHEDULE_DAY3_ACTIVITY));
        tvActivity4.setText(controller_menu.getValueFromDB(Database_SQL.KEY_SCHEDULE_DAY4_ACTIVITY));
        tvActivity5.setText(controller_menu.getValueFromDB(Database_SQL.KEY_SCHEDULE_DAY5_ACTIVITY));
        tvActivity6.setText(controller_menu.getValueFromDB(Database_SQL.KEY_SCHEDULE_DAY6_ACTIVITY));
        tvActivity7.setText(controller_menu.getValueFromDB(Database_SQL.KEY_SCHEDULE_DAY7_ACTIVITY));

        tvTime1.setText(controller_menu.getValueFromDB(Database_SQL.KEY_SCHEDULE_DAY1_TIME));
        tvTime2.setText(controller_menu.getValueFromDB(Database_SQL.KEY_SCHEDULE_DAY2_TIME));
        tvTime3.setText(controller_menu.getValueFromDB(Database_SQL.KEY_SCHEDULE_DAY3_TIME));
        tvTime4.setText(controller_menu.getValueFromDB(Database_SQL.KEY_SCHEDULE_DAY4_TIME));
        tvTime5.setText(controller_menu.getValueFromDB(Database_SQL.KEY_SCHEDULE_DAY5_TIME));
        tvTime6.setText(controller_menu.getValueFromDB(Database_SQL.KEY_SCHEDULE_DAY6_TIME));
        tvTime7.setText(controller_menu.getValueFromDB(Database_SQL.KEY_SCHEDULE_DAY7_TIME));
    }

    /**
     * Initialize the activity components
     */
    public void init(){
        super.init();
        tvActivity1 = (TextView)findViewById(R.id.tvSchedule_day1_activity);
        tvActivity2 = (TextView)findViewById(R.id.tvSchedule_day2_activity);
        tvActivity3 = (TextView)findViewById(R.id.tvSchedule_day3_activity);
        tvActivity4 = (TextView)findViewById(R.id.tvSchedule_day4_activity);
        tvActivity5 = (TextView)findViewById(R.id.tvSchedule_day5_activity);
        tvActivity6 = (TextView)findViewById(R.id.tvSchedule_day6_activity);
        tvActivity7 = (TextView)findViewById(R.id.tvSchedule_day7_activity);

        tvTime1 = (TextView)findViewById(R.id.tvSchedule_day1_time);
        tvTime2 = (TextView)findViewById(R.id.tvSchedule_day2_time);
        tvTime3 = (TextView)findViewById(R.id.tvSchedule_day3_time);
        tvTime4 = (TextView)findViewById(R.id.tvSchedule_day4_time);
        tvTime5 = (TextView)findViewById(R.id.tvSchedule_day5_time);
        tvTime6 = (TextView)findViewById(R.id.tvSchedule_day6_time);
        tvTime7 = (TextView)findViewById(R.id.tvSchedule_day7_time);
    }

}
