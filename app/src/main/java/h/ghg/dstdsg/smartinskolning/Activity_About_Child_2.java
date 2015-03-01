package h.ghg.dstdsg.smartinskolning;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Activity_About_Child_2 extends Activity_Base {

    private EditText etFood_Habits;
    private EditText etSleeping_Habits;
    private EditText etFears;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__about__child_2);
        init();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /**
     * Initialize the activity components
     */
    public void init(){

        /* Retrieve the complicated layout ids in the xml file (<include> elements) */
        View foodGroup = findViewById(R.id.foodGroup);
        View sleepGroup = findViewById(R.id.sleepGroup);

        /* Then retrieve the references to the elements inside the complicated layouts */
        etSleeping_Habits = (EditText)sleepGroup.findViewById(R.id.etInfo);
        etFood_Habits = (EditText)foodGroup.findViewById(R.id.etInfo);

        /* Retrieve the information already in the database on the child */
        etSleeping_Habits.setText(About_Child.sleeping_habits);
        etFood_Habits.setText(About_Child.food_habits);

        /* Set the title of the edittext fields */
        TextView tvFoodTitle = (TextView)foodGroup.findViewById(R.id.tvTitle);
        TextView tvSleepTitle = (TextView)sleepGroup.findViewById(R.id.tvTitle);

        tvFoodTitle.setText(getResources().getString(R.string.food_habits));
        tvSleepTitle.setText(getResources().getString(R.string.sleeping_habits));

        Button btnNext = (Button)findViewById(R.id.btnabout_child_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Change the food and sleeping habits to whatever is inside the edittext fields */
                About_Child.food_habits = etFood_Habits.getText().toString();
                About_Child.sleeping_habits = etSleeping_Habits.getText().toString();

                /* Goto last page */
                Intent i = new Intent(getApplicationContext(),Activity_About_Child_3.class);
                startActivity(i);
            }
        });
        super.init();
    }

}
