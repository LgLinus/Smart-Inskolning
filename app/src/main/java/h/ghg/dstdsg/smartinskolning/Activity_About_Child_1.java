package h.ghg.dstdsg.smartinskolning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Activitity displaying information about the child
 * created by Linus Granath
 */
public class Activity_About_Child_1 extends Activity_Base {

    private EditText et_allergy, et_disease, et_disability;
    private CheckBox cb_allergy, cb_disease, cb_disability;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__about__child_1);
        init();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /**
     * Initialize the activity
     */
    public void init(){
        /* Retrieve the complicated layout ids in the xml file (<include> elements) */
        View allergyGroup = findViewById(R.id.inclAllergy_Group);
        View disabilityGroup = findViewById(R.id.inclDisability_Group);
        View diseaseGroup = findViewById(R.id.inclDisease_Group);

        /* Then retrieve the references to the elements inside the complicated layouts */
        et_allergy = (EditText)allergyGroup.findViewById(R.id.etInfo);
        et_disability = (EditText)disabilityGroup.findViewById(R.id.etInfo);
        et_disease = (EditText)diseaseGroup.findViewById(R.id.etInfo);
        cb_allergy = (CheckBox)allergyGroup.findViewById(R.id.checkbox);
        cb_disability = (CheckBox)disabilityGroup.findViewById(R.id.checkbox);
        cb_disease = (CheckBox)diseaseGroup.findViewById(R.id.checkbox);

        /* Set the title of the edittext fields */

        TextView tvAllergy = (TextView)allergyGroup.findViewById(R.id.tvTitle);
        TextView tvDisease = (TextView)diseaseGroup.findViewById(R.id.tvTitle);
        TextView tvDisability = (TextView)disabilityGroup.findViewById(R.id.tvTitle);

        /* Set the correct text for the title elements  */
        tvAllergy.setText(getResources().getString(R.string.allergy));
        tvDisease.setText(getResources().getString(R.string.disease));
        tvDisability.setText(getResources().getString(R.string.disability));

        et_allergy.setText(About_Child.allergy_details);
        et_disease.setText(About_Child.disease_details);
        et_disability.setText(About_Child.disability_details);

        if(About_Child.has_allergy!=0)
            cb_allergy.setChecked(true);
        if(About_Child.has_disease!=0)
            cb_disease.setChecked(true);
        if(About_Child.has_disability!=0)
            cb_disability.setChecked(true);

        Button btnNext = (Button)findViewById(R.id.btnabout_child_next);

        if(!cb_allergy.isChecked())
            et_allergy.setEnabled(false);
        if(!cb_disability.isChecked())
            et_disability.setEnabled(false);
        if(!cb_disease.isChecked())
            et_disease.setEnabled(false);

        /* When next button is pressed, store information in About_Child */
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Retrieve the text, store it
                About_Child.allergy_details = et_allergy.getText().toString();
                About_Child.disease_details = et_disease.getText().toString();
                About_Child.disability_details = et_disability.getText().toString();

                /* Store if the checkboxes are checked */
                if(cb_allergy.isChecked())
                    About_Child.has_allergy = 1;
                else
                    About_Child.has_allergy = 0;
                if(cb_disease.isChecked())
                    About_Child.has_disease = 1;
                else
                    About_Child.has_disease = 0;
                if(cb_disability.isChecked())
                    About_Child.has_disability = 1;
                else
                    About_Child.has_disability = 0;

                Intent i = new Intent(getApplicationContext(),Activity_About_Child_2.class);
                startActivity(i);
            }
        });

        /* Handles enabling of the EditText objects */
        cb_allergy.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(cb_allergy.isChecked())
                    et_allergy.setEnabled(true);
                else
                    et_allergy.setEnabled(false);
            }
        });
        cb_disease.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(cb_disease.isChecked())
                    et_disease.setEnabled(true);
                else
                    et_disease.setEnabled(false);
            }
        });
        cb_disability.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if(cb_disability.isChecked())
                    et_disability.setEnabled(true);
                else
                    et_disability.setEnabled(false);
            }
        });

        super.init();
    }

}
