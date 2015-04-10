package h.ghg.dstdsg.smartinskolning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Activity displaying information on how the parents can reach the school.
 */
public class Activity_Here_We_Are extends Activity_Base {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__here__we_are);
        init();
    }

    /**
     * Initialize the activity
     */
    public void init(){
        layout = (LinearLayout) findViewById(R.id.llHere_We_Are);
        addInfo();
        super.init();
    }

    private void addInfo(){
        for(int i = 0; i < Contact_Information.contact_name.size();i+=2){
            LayoutInflater factory = LayoutInflater.from(this);
            View myView = factory.inflate(R.layout.contact_information,null);
            layout.addView(myView);

            TextView tvLeft = (TextView)myView.findViewById(R.id.tvContact_Left);

            ImageView ivLeft = (ImageView)myView.findViewById(R.id.ivContact_Left);
            ImageView ivRight = (ImageView) myView.findViewById(R.id.ivcontact_Right);
            TextView tvRight = (TextView) myView.findViewById(R.id.tvContact_Right);
            if((i+1) < Contact_Information.contact_name.size()) {
                tvRight.setText(Contact_Information.contact_name.get(i + 1));
                ivRight.setImageResource(getResources().getIdentifier(Contact_Information.contact_image.get(i+1), "drawable", "h.ghg.dstdsg.smartinskolning"));
            }
            else{
                tvRight.setText("");
            }
            tvLeft.setText(Contact_Information.contact_name.get(i));

            ivLeft.setImageResource(getResources().getIdentifier(Contact_Information.contact_image.get(i), "drawable", "h.ghg.dstdsg.smartinskolning"));
        }
    }
}
