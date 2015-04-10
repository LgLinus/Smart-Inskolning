package h.ghg.dstdsg.smartinskolning;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

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

    /* Login method */
    private void login(){

        /// Retrieve the username and password that has been entered, ignore spaces
        String username = activity.getEtAccount().getText().toString();
        username=username.replace(" ","");

        String password = activity.getEtPassword().getText().toString();
        password=password.replace(" ","");
        String[] loginInfo = {"",""};

        // Retrieve login details for the given username
        if(!username.matches("")&& !password.matches("")) {
            loginInfo = db.getAccount(username);

            // Compare the passwords
            if (username.equals(loginInfo[0]) && (password.equals(loginInfo[1]))) {

                // Successfull login, goto welcome activity/
                About_Child.id = loginInfo[0];
                db.getAboutChildValues();
                db.getEvaluationValues();
                db.getContact_Information();
                Intent i = new Intent(activity.getApplicationContext(), Activity_Welcome.class);
                activity.finish();
                activity.startActivity(i);
                db.close();
            } else {
                Toast.makeText(activity.getApplicationContext(), activity.getApplicationContext().getResources().getString(R.string.wrong_login_details), Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(activity.getApplicationContext(), activity.getApplicationContext().getResources().getString(R.string.no_input), Toast.LENGTH_LONG).show();
        }
    }

    // Initializes the database
    private void initdb(){
        db.addContact(1,"Linus Granath","Libuz94@gmail.com","0760-321362","linus","developer");
        db.addContact(2,"Amanda Oaksson","amanda313@gmail.com","076-135168","profile","teacher");
        db.addContact(3,"Göran göransson","GÖ21@gmail.com","076-28714","profile","teacher");
        db.addMessage(Database_SQL.KEY_SCHEDULE_DAY1_TIME,"9.00-10.00");
        db.addMessage(Database_SQL.KEY_EQUIPMENT_LIST,"<u>Clothes</u><br/>\u2022 Regnjacka med galonbyxor<br/>\u2022 Strumpor<br/>\u2022 Kalsonger/Trosor<br/>\u2022 Byxor, shorts<br/>\u2022 Tröjor: långärmade, kortärmade<br/> (tunna och tjocka)" +
                "<br/>\u2022 Vantar, mössa(vid säsong)<br/><u>Blöjor</u><br/>\u2022 Ett paket blöjor till att börja med" +
                "<br/><u>Sova</u><br/>\u2022 Napp<br/>\u2022 Sov tillbehör(Gosedjur, filt)<br/> ");
        db.addMessage(Database_SQL.KEY_MAIL,"solappen@appisförskola.se");
        db.addMessage(Database_SQL.KEY_NUMBER,"073-505 90 33");
        db.addMessage(Database_SQL.KEY_ADDRESS,"Applikationsgatan 13 123 45 Apptuna");
        db.addMessage(Database_SQL.KEY_LOCATION,"location");
        db.addMessage(Database_SQL.KEY_OPEN,"Måndag-torsdag\n7.00-17.30\nFredag\n7.00-16.00");
        db.addMessage(Database_SQL.KEY_SCHEDULE_DAY1_ACTIVITY,"Introduktion");
        db.addMessage(Database_SQL.KEY_SCHEDULE_DAY2_TIME,"9.00-11.00");
        db.addMessage(Database_SQL.KEY_SCHEDULE_DAY2_ACTIVITY,"Samling, lek");
        db.addMessage(Database_SQL.KEY_SCHEDULE_DAY3_TIME,"9.00-11.30");
        db.addMessage(Database_SQL.KEY_SCHEDULE_DAY3_ACTIVITY,"Samling, lek, lunch");
        db.addMessage(Database_SQL.KEY_SCHEDULE_DAY4_TIME,"9.00-14.00");
        db.addMessage(Database_SQL.KEY_SCHEDULE_DAY4_ACTIVITY,"Samling, lek,lunch,vila");
        db.addMessage(Database_SQL.KEY_SCHEDULE_DAY5_TIME,"9.00-14.00");
        db.addMessage(Database_SQL.KEY_SCHEDULE_DAY5_ACTIVITY,"Samling, lek,lunch,vila");
        db.addMessage(Database_SQL.KEY_SCHEDULE_DAY6_TIME,"10.00-14.00");
        db.addMessage(Database_SQL.KEY_SCHEDULE_DAY6_ACTIVITY,"Heldag utan vård.hav");
        db.addMessage(Database_SQL.KEY_SCHEDULE_DAY7_TIME,"9.00-15.00");
        db.addMessage(Database_SQL.KEY_SCHEDULE_DAY7_ACTIVITY,"Heldag utan vård.hav");

        /* Användarkonton skapas */
        db.addAccount("test","pass");
        db.addAccount("linus","granath");
        db.addAccount("pär","pass");
        db.addAccount("ida","losen");


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
