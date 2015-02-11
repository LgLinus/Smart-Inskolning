package h.ghg.dstdsg.smartinskolning;

import android.content.Intent;
import android.view.View;

/**
 * Class responsible of handling the logic in the
 * login menu
 * Created by Linus Granath on 2015-02-01.
 */
public class Controller_Login {

    private Activity_Login activity;
    private Database_SQL db;
    /**
     *
     * @param activity to control
     */
    public Controller_Login(Activity_Login activity){
        this.activity = activity;
        init();
    }

    /**
     * Initialize the components
     */
    public void init(){
        activity.getBtnLogin().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        db = new Database_SQL(activity.getApplicationContext());
        initdb();
    }

    // TODO unfinished method to handle login
    private void login(){

        /*// Retrieve the username and password that has been entered
        String username = activity.getEtAccount().getText().toString();
        String password = activity.getEtPassword().getText().toString();
        String[] loginInfo = {"",""};

        // Retrieve login details for the given username
        if(!username.matches("")&& !password.matches("")) {
            loginInfo = db.getAccount(username);

            // Compare the passwords
            if (username.equals(loginInfo[0]) && (password.equals(loginInfo[1]))) {

                // Successfull login, goto welcome activity*/
                Intent i = new Intent(activity.getApplicationContext(), Activity_Welcome.class);
                activity.finish();
                activity.startActivity(i);
                db.close();/*
            } else {
                Toast.makeText(activity.getApplicationContext(), activity.getApplicationContext().getResources().getString(R.string.wrong_login_details), Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(activity.getApplicationContext(), activity.getApplicationContext().getResources().getString(R.string.no_input), Toast.LENGTH_LONG).show();
        }*/
    }

    // Initializes the database
    private void initdb(){
        db.addAccount("test","pass");
        db.addAccount("linus","granath");
        db.addMessage(Database_SQL.KEY_WELCOME_TITLE,"Varmt välkomna till Appis förskola!");
        db.addMessage(Database_SQL.KEY_WELCOME_MESSAGE,"Vi är glada att få lära känner er och ert barn och hoppas att ni kommer trivas hos oss.\n\n" +
                "Vi har öppet hus vecka 28, måndag-torsdag kl. 0900-14.00, kom gärna förbi och titta runt. Själva inskolningen börjar vecka 30.");

        db.addMessage(Database_SQL.KEY_EQUIPMENT_TITLE,"Detta medtages till förskolan första dagen:");

        db.addMessage(Database_SQL.KEY_SCHEDULE_TITLE,"Shema under inskolningen:");

        db.addMessage(Database_SQL.KEY_ROUTINE_TITLE,"Information om rutiner:");
        db.addMessage(Database_SQL.KEY_ROUTINE_MESSAGE,"Dag 1-5 på Inskolningen är vårdnadshavare " +
                "med barnet större delen av dagarna för att hjälpa barnet att känna sig tryggt.\n\n" +
                "Dag 6-7 är det dags att vårdnadshavare lämnar sitt banr på förskolan för en heldag." +
                "Det är viktigt att vårdnadshavare går att kontakta på telefone och kan hämta vid behov.\n\n" +
                "Ytterligare information får ni första dagen ni kommer till förskolan. Se även schemat.");


    }

}
