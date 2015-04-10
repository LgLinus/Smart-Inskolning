package h.ghg.dstdsg.smartinskolning;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Class responsible of handling the connection with the
 * SQL database.
 * Created by Linus Granath on 2015-02-05.
 */
public class Database_SQL extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "datbase.db";

    public static final String TABLE_MESSAGES = "Messages";
    public static final String MESSAGES_ID = "_id";
    public static final String MESSAGES_MESSAGE = "_message";

    public static final String TABLE_ACCOUNTS = "Accounts";
    public static final String ACCOUNTS_ID = "_id";
    public static final String ACCOUNTS_PASSWORD = "_password";

    public static final String TABLE_ACCOUNT_DETAILS = "Account_Details";
    public static final String ACCOUNTS_USERNAME = "_username";
    public static final String ACCOUNTS_ALLERGY = "_allergy";
    public static final String ACCOUNTS_ALLERGY_DETAILS = "_allergy_details";
    public static final String ACCOUNTS_DISEASE = "_disease";
    public static final String ACCOUNTS_DISEASE_DETAILS = "_disease_details";
    public static final String ACCOUNTS_DISABILITY = "_disabilities";
    public static final String ACCOUNTS_DISABILITY_DETAILS = "_disability_details";
    public static final String ACCOUNTS_FOOD_HABITS = "_food_habits";
    public static final String ACCOUNTS_SLEEPING_HABITS = "_sleeping_habits";
    public static final String ACCOUNTS_FEARS = "_fears";
    public static final String ACCOUNTS_LIKES = "_likes";
    public static final String ACCOUNTS_REST = "_rest";


    public static final String TABLE_ACCOUNT_EVALUATION = "Evaluation";
    public static final String TABLE_CONTACT_INFORMATION = "Contact";
    public static final String ACCOUNTS_EV_EXPERIENCE_APP = "_ev_experience";
    public static final String ACCOUNTS_EV_EXPERIENCE_APP2 = "_ev_experience2";
    public static final String ACCOUNTS_EV_OTHER = "_ev_other";
    public static final String ACCOUNTS_EV_OTHER2 = "_ev_other2";
    public static final String ACCOUNTS_EV_HAS_INFO_CLEAR = "_ev_has_info";
    public static final String ACCOUNTS_EV_INFO_CLEAR = "_ev_info";
    public static final String ACCOUNTS_EV_FEATURES = "_ev_feaures";

    public static final String KEY_WELCOME_TITLE = "welcome_title";
    public static final  String KEY_WELCOME_MESSAGE = "welcome_message";
    public static final  String KEY_EQUIPMENT_TITLE = "equipment_title";
    public static final  String KEY_EQUIPMENT_MESSAGE = "equipment_message";
    public static final  String KEY_EVALUATION_TITLE = "evaluation_title";
    public static final  String KEY_EVALUATION_MESSAGE = "evaluation_message";
    public static final  String KEY_HERE_WE_ARE_TITLE = "here_we_are_title";
    public static final  String KEY_HERE_WE_ARE_MESSAGE = "here_we_are_message";
    public static final  String KEY_ROUTINE_TITLE ="routine_title";
    public static final  String KEY_ROUTINE_MESSAGE ="routine_message";
    public static final  String KEY_SCHEDULE_TITLE ="schedule_title";
    public static final  String KEY_SCHEDULE_MESSAGE ="schedule_message";
    public static final String KEY_SCHEDULE_DAY1_ACTIVITY ="day1_activity";
    public static final String KEY_SCHEDULE_DAY2_ACTIVITY ="day2_activity";
    public static final String KEY_SCHEDULE_DAY3_ACTIVITY ="day3_activity";
    public static final String KEY_SCHEDULE_DAY4_ACTIVITY ="day4_activity";
    public static final String KEY_SCHEDULE_DAY5_ACTIVITY ="day5_activity";
    public static final String KEY_SCHEDULE_DAY6_ACTIVITY ="day6_activity";
    public static final String KEY_SCHEDULE_DAY7_ACTIVITY ="day7_activity";
    public static final String KEY_SCHEDULE_DAY1_TIME = "day1_time";
    public static final String KEY_SCHEDULE_DAY2_TIME = "day2_time";
    public static final String KEY_SCHEDULE_DAY3_TIME = "day3_time";
    public static final String KEY_SCHEDULE_DAY4_TIME = "day4_time";
    public static final String KEY_SCHEDULE_DAY5_TIME = "day5_time";
    public static final String KEY_SCHEDULE_DAY6_TIME = "day6_time";
    public static final String KEY_SCHEDULE_DAY7_TIME = "day7_time";
    public static final String KEY_EQUIPMENT_LIST = "equipment_list";
    public static final String KEY_NUMBER = "number";
    public static final String KEY_MAIL = "mail";
    public static final String KEY_ADDRESS = "address";
    public static final String KEY_LOCATION = "location";
    public static final String KEY_OPEN = "open";
    public static final String KEY_ID = "_id";
    public static final String KEY_CONTACT_MAIL = "_mail";
    public static final String KEY_CONTACT_NUMBER = "_number";
    public static final String KEY_CONTACT_IMAGE = "_image";
    public static final String KEY_CONTACT_NAME = "_name";
    public static final String KEY_CONTACT_PROFESSION = "_profession";

    public static String welcome_Title = "";
    public static String welcomeMessage_Message = "";

    public static final String TABLE_ACCOUNT_DETAILS_LAYOUT = "(" + ACCOUNTS_USERNAME + " text primary key," + ACCOUNTS_ALLERGY + " integer, "
            + ACCOUNTS_ALLERGY_DETAILS + " text, " + ACCOUNTS_DISEASE + " integer, " + ACCOUNTS_DISEASE_DETAILS + " text, " + ACCOUNTS_DISABILITY
            + " integer, " + ACCOUNTS_DISABILITY_DETAILS + " text, " + ACCOUNTS_FOOD_HABITS + " text, " + ACCOUNTS_SLEEPING_HABITS + " text, "
            + ACCOUNTS_FEARS + " text, " + ACCOUNTS_LIKES + " text, " + ACCOUNTS_REST + " text);";

    public static final String TABLE_CONTACT_INFORMATION_LAYOUT = "(" + KEY_ID + " integer primary key," + KEY_CONTACT_NAME + " text, "
            + KEY_CONTACT_MAIL + " text, " + KEY_CONTACT_NUMBER + " text, " + KEY_CONTACT_IMAGE + " text, " + KEY_CONTACT_PROFESSION + " text);";

    public static final String TABLE_ACCOUNT_EVALUATION_LAYOUT = "(" + ACCOUNTS_USERNAME + " text primary key," + ACCOUNTS_EV_EXPERIENCE_APP + " text, "
            + ACCOUNTS_EV_HAS_INFO_CLEAR + " integer, " + ACCOUNTS_EV_INFO_CLEAR + " text, " + ACCOUNTS_EV_OTHER
            + " text, " + ACCOUNTS_EV_EXPERIENCE_APP2 + " text, " + ACCOUNTS_EV_FEATURES + " text, "
            + ACCOUNTS_EV_OTHER2 + " text);";

    private static final String DATABASE_CREATE="create table IF NOT EXISTS " + TABLE_MESSAGES + "(" + MESSAGES_ID
            + " text primary key, " + MESSAGES_MESSAGE + " text not null);";
    private static final String DATABASE_CREATE_ACCOUNTS="create table IF NOT EXISTS " + TABLE_ACCOUNTS + "(" + ACCOUNTS_ID
            + " text primary key, " + ACCOUNTS_PASSWORD + " text not null);";
    private static final String DATABASE_CREATE_ACCOUNT_DETAILS="create table IF NOT EXISTS " + TABLE_ACCOUNT_DETAILS + TABLE_ACCOUNT_DETAILS_LAYOUT;
    private static final String DATABASE_CREATE_ACCOUNT_EVALUATION="create table IF NOT EXISTS " + TABLE_ACCOUNT_EVALUATION + TABLE_ACCOUNT_EVALUATION_LAYOUT;
    private static final String DATABASE_CREATE_CONTACT_INFORMATION="create table IF NOT EXISTS " + TABLE_CONTACT_INFORMATION + TABLE_CONTACT_INFORMATION_LAYOUT;

    private static final String DATABASE_DROP_TABLE="drop table if exists  " + TABLE_MESSAGES;
    private static final String DATABASE_DROP_ACCOUNTS="drop table if exists  " + TABLE_ACCOUNTS;
    private static final String DATABASE_DROP_ACCOUNT_DETAILS="drop table if exists  " + TABLE_ACCOUNT_DETAILS;
    private static final String DATABASE_DROP_ACCOUNT_EVALUATION="drop table if exists  " + TABLE_ACCOUNT_EVALUATION;
    private static final String DATABASE_DROP_CONTACT_INFORMATION="drop table if exists  " + TABLE_CONTACT_INFORMATION;

    public static SQLiteDatabase database;

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 6;

    public Database_SQL(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_ACCOUNTS);
        db.execSQL(DATABASE_CREATE);
        db.execSQL(DATABASE_CREATE_ACCOUNT_DETAILS);
        db.execSQL(DATABASE_CREATE_ACCOUNT_EVALUATION);
        db.execSQL(DATABASE_CREATE_CONTACT_INFORMATION);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(DATABASE_DROP_TABLE);
        db.execSQL(DATABASE_DROP_ACCOUNTS);
        db.execSQL(DATABASE_DROP_ACCOUNT_DETAILS);
        db.execSQL(DATABASE_DROP_ACCOUNT_EVALUATION);
        db.execSQL(DATABASE_DROP_CONTACT_INFORMATION);
        onCreate(db);
    }

    /**
     * Adds a new row to the database
     * @param key, id for the message
     * @param message, message
     */
    public void addMessage(String key, String message){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(MESSAGES_ID,key);
        values.put(MESSAGES_MESSAGE,message);
        myDB.replace(TABLE_MESSAGES, null, values);
        Log.d("INSERT", "Inserted with key: " + key + " message: " + message );
    }


    /**
     * Add a new contact to the database
     * @param id unique id
     * @param name name of contact
     * @param mail mail of contact
     * @param number number of contact
     * @param image of contact
     */
    public void addContact(int id, String name, String mail,String number, String image, String profession){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID,id);
        values.put(KEY_CONTACT_NAME,name);
        values.put(KEY_CONTACT_MAIL,mail);
        values.put(KEY_CONTACT_NUMBER,number);
        values.put(KEY_CONTACT_IMAGE,image);
        values.put(KEY_CONTACT_PROFESSION,profession);
        myDB.replace(TABLE_CONTACT_INFORMATION, null, values);
    }

    /**
     * Adds a new account to the database
     * @param username, username
     * @param password, password
     */
    public void addAccount(String username, String password){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(ACCOUNTS_ID,username);
        values.put(ACCOUNTS_PASSWORD,password);
        myDB.insert(TABLE_ACCOUNTS, null, values);
        Log.d("INSERT", "Inserted with key: " + username + " message: " + password );
    }

    /* Retrieve a message from the database, if the matching key is found */
    public String getMessage(/*SQLiteDatabase db, */String key){
        SQLiteDatabase myDB = this.getReadableDatabase();
        String selectQuery = "SELECT *FROM " + TABLE_MESSAGES + " WHERE " + MESSAGES_ID + "=?";
        /* ? is replaced by the first element in the new String */
        Cursor cursor = myDB.rawQuery(selectQuery, new String[]{key});
        String res ="";

        if(!(cursor == null)&& cursor.getCount()>0){
            cursor.moveToFirst();
            res = cursor.getString(1);
            Log.d("DATABASE",res);
        }

        if(res==null)
            res = "---";
        return res;
    }

    /**
     * Retrieve an account and password from the database
     * @param account to retrieve
     * @return account and password
     */
    public String[] getAccount(String account){
        SQLiteDatabase myDB = this.getReadableDatabase();
        String selectQuery = "SELECT *FROM " + TABLE_ACCOUNTS + " WHERE " + ACCOUNTS_ID + "=?";

        Cursor cursor = myDB.rawQuery(selectQuery,new String[]{account});
        String[] res = {"",""};

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            res[0] = cursor.getString(0); // Account
            res[1] = cursor.getString(1); // Password
        }

        if(res[0] == null)
            res[0] = "Account not found";
        return res;
    }

    /**
     * Retrieve contact information
     * @return account and password
     */
    public String[] getContact_Information(){
        SQLiteDatabase myDB = this.getReadableDatabase();
        String selectQuery = "SELECT *FROM " + TABLE_CONTACT_INFORMATION;

        Cursor cursor = myDB.rawQuery(selectQuery,null);
        String[] res = {"",""};

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            do{
                Contact_Information.addContact(cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
                cursor.moveToNext();
            }
            while(!cursor.isAfterLast());



        }

        if(res[0] == null)
            res[0] = "Account not found";
        return res;
    }

    /*
    * Retrieve the values stored about the child from the database
     */
    public void getAboutChildValues(){
        SQLiteDatabase myDB = this.getReadableDatabase();
        String selectQuery = "SELECT *FROM " + TABLE_ACCOUNT_DETAILS + " WHERE " + ACCOUNTS_USERNAME + "=?";

        Cursor cursor = myDB.rawQuery(selectQuery,new String[]{About_Child.id});

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            About_Child.has_allergy = 0;
            About_Child.has_disease = 0;
            About_Child.has_disability =0;
            if(cursor.getInt(1)>-1)
                About_Child.has_allergy = 1;
            About_Child.allergy_details = cursor.getString(2);
            if((cursor.getInt(3))>0){
                About_Child.has_disease = 1;}
            About_Child.disease_details = cursor.getString(4);
            if(cursor.getInt(5)>0)
                About_Child.has_disability = 1;
            About_Child.disability_details = cursor.getString(6);
            About_Child.food_habits = cursor.getString(7);
            About_Child.sleeping_habits = cursor.getString(8);
            About_Child.fears = cursor.getString(9);
            About_Child.likes = cursor.getString(10);
            About_Child.other = cursor.getString(11);
        }
    }

    /*
* Retrieve the values stored from the evaluation from the database
 */
    public void getEvaluationValues(){
        SQLiteDatabase myDB = this.getReadableDatabase();
        String selectQuery = "SELECT *FROM " + TABLE_ACCOUNT_EVALUATION + " WHERE " + ACCOUNTS_USERNAME + "=?";

        Cursor cursor = myDB.rawQuery(selectQuery,new String[]{About_Child.id});

        if(cursor!=null && cursor.getCount()>0){
            cursor.moveToFirst();
            Evaluation_Values.has_Info_Clear = 0;
            if(cursor.getInt(2)>-1)
                Evaluation_Values.has_Info_Clear = 1;


            Evaluation_Values.experience_App = cursor.getString(1);
            Evaluation_Values.info_Clear = cursor.getString(3);
            Evaluation_Values.other = cursor.getString(4);
            Evaluation_Values.experience_App2 = cursor.getString(5);
            Evaluation_Values.features = cursor.getString(6);
            Evaluation_Values.other2 = cursor.getString(7);
        }
    }

    /**
     * Write the values stored about the child to the database
     */
    public void writeAboutChildValues(){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ACCOUNTS_USERNAME, About_Child.id);
        cv.put(ACCOUNTS_ALLERGY,About_Child.has_allergy);
        cv.put(ACCOUNTS_ALLERGY_DETAILS, About_Child.allergy_details);
        cv.put(ACCOUNTS_DISEASE,About_Child.has_disease);
        cv.put(ACCOUNTS_DISEASE_DETAILS, About_Child.disease_details);
        cv.put(ACCOUNTS_DISABILITY,About_Child.has_disability);
        cv.put(ACCOUNTS_DISABILITY_DETAILS, About_Child.disability_details);
        cv.put(ACCOUNTS_FOOD_HABITS, About_Child.food_habits);
        cv.put(ACCOUNTS_SLEEPING_HABITS, About_Child.sleeping_habits);
        cv.put(ACCOUNTS_FEARS, About_Child.fears);
        cv.put(ACCOUNTS_LIKES, About_Child.likes);
        cv.put(ACCOUNTS_REST, About_Child.other);
        myDB.replace(TABLE_ACCOUNT_DETAILS,null, cv);
    }

    /**
     * Write the values stored from the evaluation to the database
     */
    public void writeEvaluationValues(){
        SQLiteDatabase myDB = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(ACCOUNTS_USERNAME, About_Child.id);
        cv.put(ACCOUNTS_EV_EXPERIENCE_APP,Evaluation_Values.experience_App);
        cv.put(ACCOUNTS_EV_HAS_INFO_CLEAR, Evaluation_Values.has_Info_Clear);
        cv.put(ACCOUNTS_EV_INFO_CLEAR,Evaluation_Values.info_Clear);
        cv.put(ACCOUNTS_EV_OTHER, Evaluation_Values.other);
        cv.put(ACCOUNTS_EV_EXPERIENCE_APP2,Evaluation_Values.experience_App2);
        cv.put(ACCOUNTS_EV_FEATURES, Evaluation_Values.features);
        cv.put(ACCOUNTS_EV_OTHER2, Evaluation_Values.other2);
        myDB.replace(TABLE_ACCOUNT_EVALUATION,null, cv);
    }


}
