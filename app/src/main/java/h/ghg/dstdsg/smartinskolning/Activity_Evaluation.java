package h.ghg.dstdsg.smartinskolning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Activity displaying a form where the parents can give feedback about the application
 */
public class Activity_Evaluation extends Activity_Base {

    private TextView tvExperienceApp, tvInfo_Clear, tvOther, tvInfo_Clear_Cb;
    private EditText etExperienceApp, etInfo_Clear, etOther;
    private CheckBox cb_info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__evaluation);
        init();
    }

    /**
     * Initialize the activity
     */
    public void init(){
        View experienceGroup = findViewById(R.id.thoughts_about_appGroup);
        View info_ClearGroup = findViewById(R.id.info_ClearGroup);
        View otherGroup = findViewById(R.id.other_ThoughtsGroup);

        tvExperienceApp = (TextView) experienceGroup.findViewById(R.id.tvTitle);
        tvInfo_Clear = (TextView) info_ClearGroup.findViewById(R.id.tv_allergy_yes);
        tvInfo_Clear_Cb = (TextView) info_ClearGroup.findViewById(R.id.tvTitle);
        tvOther = (TextView) otherGroup.findViewById(R.id.tvTitle);
        cb_info = (CheckBox) info_ClearGroup.findViewById(R.id.checkbox);
        etExperienceApp = (EditText) experienceGroup.findViewById(R.id.etInfo);
        etInfo_Clear = (EditText) info_ClearGroup.findViewById(R.id.etInfo);
        etOther = (EditText) otherGroup.findViewById(R.id.etInfo);
        Button btn_Next = (Button)findViewById(R.id.btnEvaluation_Next);


        tvExperienceApp.setText(getResources().getString(R.string.experience_app));
        tvInfo_Clear.setText(getResources().getString(R.string.info_clear));
        tvInfo_Clear_Cb.setText(getResources().getString(R.string.info_clear_cb));
        tvOther.setText(getResources().getString(R.string.ev_other));


        etExperienceApp.setText(Evaluation_Values.experience_App);
        etInfo_Clear.setText(Evaluation_Values.info_Clear);
        etOther.setText(Evaluation_Values.other);

        if(Evaluation_Values.has_Info_Clear!=0)
            cb_info.setChecked(true);

        btn_Next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Evaluation_Values.experience_App = etExperienceApp.getText().toString();
                Evaluation_Values.info_Clear = etInfo_Clear.getText().toString();
                Evaluation_Values.other = etOther.getText().toString();

                /* Store if the checkboxes are checked */
                if(cb_info.isChecked())
                    Evaluation_Values.has_Info_Clear = 1;
                else
                    Evaluation_Values.has_Info_Clear = 0;

                Intent i = new Intent(getApplicationContext(),Activity_Evaluation_2.class);
                startActivity(i);
            }
        });

        super.init();
    }

}
