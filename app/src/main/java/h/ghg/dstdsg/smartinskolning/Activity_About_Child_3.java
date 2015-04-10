package h.ghg.dstdsg.smartinskolning;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Activity_About_Child_3 extends Activity_Base {

    private EditText etLikes, etFears, etOther;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__about__child_3);
        init();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /**
     * Initialize the activity components
     */
    public void init(){

        /* Retrieve the complicated layout ids in the xml file (<include> elements) */
        View groupFears = findViewById(R.id.fearGroup);
        View groupLikes = findViewById(R.id.likesGroup);
        View groupOther = findViewById(R.id.otherGroup);

        /* Then retrieve the references to the elements inside the complicated layouts */
        etLikes = (EditText) groupLikes.findViewById(R.id.etInfo);
        etFears = (EditText) groupFears.findViewById(R.id.etInfo);
        etOther = (EditText) groupOther.findViewById(R.id.etInfo);

        TextView tvLikes = (TextView) groupLikes.findViewById(R.id.tvTitle);
        TextView tvFears = (TextView) groupFears.findViewById(R.id.tvTitle);
        TextView tvOther = (TextView) groupOther.findViewById(R.id.tvTitle);

        /* Set the title of the edittext fields */
        tvLikes.setText(getResources().getString(R.string.likes));
        tvFears.setText(getResources().getString(R.string.fears));
        tvOther.setText(getResources().getString(R.string.other));

        Button btnNext = (Button)findViewById(R.id.btnabout_child_finish);

        /* Set the text for the edittext fields to whatever is stored already */
        etLikes.setText(About_Child.likes);
        etFears.setText(About_Child.fears);
        etOther.setText(About_Child.other);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                /* Change the likes,fears and other values to whatever is inside the edittext fields */
                About_Child.likes = etLikes.getText().toString();
                About_Child.fears = etFears.getText().toString();
                About_Child.other = etOther.getText().toString();

                controller_menu.writeAboutChild();

                Toast.makeText(getApplicationContext(), getResources().getString(R.string.saved), Toast.LENGTH_LONG).show();

                //Intent i = new Intent(getApplicationContext(),Activity_About_Child_2.class);
                //startActivity(i);
            }
        });
        super.init();
    }

}
