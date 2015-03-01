package h.ghg.dstdsg.smartinskolning;

import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

/**
 * Class responsible fr handling the navigation of the application
 * Created by Linus Granath on 2015-02-01.
 */
public class Controller_Menu {

    private Activity_Base activity;
    private Database_SQL db;
    protected ImageButton menu_button;

    public Controller_Menu(Activity_Base activity){
        this.activity = activity;
        init();
    }

    /**
     * Initialize the components
     */
    public void init(){


        /* Initialize the listener for the button */
        activity.getMenu_Button().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu();
                Toast.makeText(activity.getApplicationContext(), "Options pressed", Toast.LENGTH_SHORT).show();
            }
        });
        db = new Database_SQL(activity.getApplicationContext());
    }

    public Database_SQL getDB(){
        return db;
    }

    /* Display the popup menu */
    public void showMenu(){
        PopupMenu popup = new PopupMenu(activity, activity.getMenu_Button());

        popup.getMenuInflater().inflate(R.menu.menu,popup.getMenu());

        /* Create listener for the menu, for each item */
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
            public boolean onMenuItemClick(MenuItem item){
                Intent i;

                /* Checks for which item is pressed and starts the corresponding activity */
                switch(item.getItemId()){
                    case R.id.menu_start_page:
                        if(!(activity instanceof Activity_Welcome)){
                            i = new Intent(activity.getApplicationContext(),Activity_Welcome.class);
                            activity.startActivity(i);}
                        else{
                            Toast.makeText(activity.getApplicationContext(),activity.getResources()
                                    .getString(R.string.already_in_screen),Toast.LENGTH_SHORT).show();
                        }
                        break;
                    case R.id.menu_contact:
                        if(!(activity instanceof Activity_Contacts)){
                            i = new Intent(activity.getApplicationContext(),Activity_Contacts.class);
                            activity.startActivity(i);}
                        else{
                            Toast.makeText(activity.getApplicationContext(),activity.getResources()
                                    .getString(R.string.already_in_screen),Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.menu_equipment:
                        if(!(activity instanceof Activity_Equipment)){
                            i = new Intent(activity.getApplicationContext(),Activity_Equipment.class);
                            activity.startActivity(i);}
                        else{
                            Toast.makeText(activity.getApplicationContext(),activity.getResources()
                                    .getString(R.string.already_in_screen),Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.menu_evaluation:
                        if(!(activity instanceof Activity_Evaluation)){
                            i = new Intent(activity.getApplicationContext(),Activity_Evaluation.class);
                            activity.startActivity(i);}
                        else{
                            Toast.makeText(activity.getApplicationContext(),activity.getResources()
                                    .getString(R.string.already_in_screen),Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.menu_here_we_are:
                        if(!(activity instanceof Activity_Here_We_Are)){
                            i = new Intent(activity.getApplicationContext(),Activity_Here_We_Are.class);
                            activity.startActivity(i);}
                        else{
                            Toast.makeText(activity.getApplicationContext(),activity.getResources()
                                    .getString(R.string.already_in_screen),Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.menu_routine:
                        if(!(activity instanceof Activity_Routine)){
                            i = new Intent(activity.getApplicationContext(),Activity_Routine.class);
                            activity.startActivity(i);}
                        else{
                            Toast.makeText(activity.getApplicationContext(),activity.getResources()
                                    .getString(R.string.already_in_screen),Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.menu_schedule:
                        if(!(activity instanceof Activity_Schedule)){
                            i = new Intent(activity.getApplicationContext(),Activity_Schedule.class);
                            activity.startActivity(i);}
                        else{
                            Toast.makeText(activity.getApplicationContext(),activity.getResources()
                                    .getString(R.string.already_in_screen),Toast.LENGTH_SHORT).show();
                        }
                        break;

                    case R.id.menu_about_child:
                        if(!(activity instanceof Activity_About_Child_1)){
                            i = new Intent(activity.getApplicationContext(),Activity_About_Child_1.class);
                            activity.startActivity(i);}
                        else{
                            Toast.makeText(activity.getApplicationContext(),activity.getResources()
                                    .getString(R.string.already_in_screen),Toast.LENGTH_SHORT).show();
                        }
                        break;
                }
                return true;
            }
        });
        popup.show();
    }

    /**
     * Write the about child values to the database
     */
    public void writeAboutChild(){
        db = new Database_SQL(activity.getApplicationContext());
        db.writeAboutChildValues();
        db.close();
    }

    /**
     * Write the evaluation values to the database
     */
    public void writeEvaluationValues(){
        db = new Database_SQL(activity.getApplicationContext());
        db.writeEvaluationValues();
        db.close();
    }

    /**
     * Get the about child values to the database
     */
    public void getAboutChild(){
        db = new Database_SQL(activity.getApplicationContext());
        db.getAboutChildValues();
        db.close();
    }

    /**
     * Retrieves the corresponding value with the given key from the SQL database
     * @param key to search for
     * @return value to return
     */
    public String getValueFromDB(String key){
        String res="";
        db = new Database_SQL(activity.getApplicationContext());
        res = db.getMessage(key);
        return res;
    }
}
