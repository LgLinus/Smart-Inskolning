package h.ghg.dstdsg.smartinskolning;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Activity displaying a form where the parents can give feedback about the application
 */
public class Activity_Evaluation_2 extends Activity_Base {

    private TextView tvExperienceApp, tvFeatures, tvOther;
    private EditText etExperienceApp, etFeatures, etOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__evaluation_2);
        init();
    }

    /**
     * Initialize the activity
     */
    public void init(){

        View experienceGroup = findViewById(R.id.thoughts_Experience_AppGroup);
        View featuresGroup = findViewById(R.id.thoughts_New_FeaturesGroup);
        View otherGroup = findViewById(R.id.other_ThoughtsGroup);

        tvExperienceApp = (TextView) experienceGroup.findViewById(R.id.tvTitle);
        tvFeatures = (TextView) featuresGroup.findViewById(R.id.tvTitle);
        tvOther = (TextView) otherGroup.findViewById(R.id.tvTitle);

        etExperienceApp = (EditText) experienceGroup.findViewById(R.id.etInfo);
        etFeatures = (EditText) featuresGroup.findViewById(R.id.etInfo);
        etOther = (EditText) otherGroup.findViewById(R.id.etInfo);

        Button btn_Next = (Button)findViewById(R.id.btnEvaluation_Confirm);


        tvExperienceApp.setText(getResources().getString(R.string.ev_experience_app));
        tvFeatures.setText(getResources().getString(R.string.ev_features));
        tvOther.setText(getResources().getString(R.string.ev_other2));


        etExperienceApp.setText(Evaluation_Values.experience_App2);
        etFeatures.setText(Evaluation_Values.features);
        etOther.setText(Evaluation_Values.other2);


        btn_Next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Evaluation_Values.experience_App2 = etExperienceApp.getText().toString();
                Evaluation_Values.features = etFeatures.getText().toString();
                Evaluation_Values.other2 = etOther.getText().toString();
                // Intent i = new Intent(getApplicationContext(),Activity_Evaluation_2.class);
                //startActivity(i) ;

                Toast.makeText(getApplicationContext(), getResources().getString(R.string.saved), Toast.LENGTH_LONG).show();

                controller_menu.writeEvaluationValues();


            }
        });

        super.init();
    }

}
