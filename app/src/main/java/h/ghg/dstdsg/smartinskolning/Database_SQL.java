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
    public static final String TABLE_ACCOUNT_DETAILS_LAYOUT = "(" + ACCOUNTS_USERNAME + " text primary key," + ACCOUNTS_ALLERGY + " integer, "
            + ACCOUNTS_ALLERGY_DETAILS + " text, " + ACCOUNTS_DISEASE + " integer, " + ACCOUNTS_DISEASE_DETAILS + " text, " + ACCOUNTS_DISABILITY
            + " integer, " + ACCOUNTS_DISABILITY_DETAILS + " text, " + ACCOUNTS_FOOD_HABITS + " text, " + ACCOUNTS_SLEEPING_HABITS + " text, "
            + ACCOUNTS_FEARS + " text, " + ACCOUNTS_LIKES + " text, " + ACCOUNTS_REST + " text);";

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

    public static String welcome_Title = "";
    public static String welcomeMessage_Message = "";


    private static final String DATABASE_CREATE="create table IF NOT EXISTS " + TABLE_MESSAGES + "(" + MESSAGES_ID
            + " text primary key, " + MESSAGES_MESSAGE + " text not null);";
    private static final String DATABASE_CREATE_ACCOUNTS="create table IF NOT EXISTS " + TABLE_ACCOUNTS + "(" + ACCOUNTS_ID
            + " text primary key, " + ACCOUNTS_PASSWORD + " text not null);";
    private static final String DATABASE_CREATE_ACCOUNT_DETAILS="create table IF NOT EXISTS " + TABLE_ACCOUNT_DETAILS_LAYOUT + TABLE_ACCOUNT_DETAILS_LAYOUT;

    private static final String DATABASE_DROP_TABLE="drop table if exists  " + TABLE_MESSAGES;
    private static final String DATABASE_DROP_ACCOUNTS="drop table if exists  " + TABLE_ACCOUNTS;

    public static SQLiteDatabase database;

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 2;

    public Database_SQL(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_ACCOUNTS);
        db.execSQL(DATABASE_CREATE);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(DATABASE_DROP_TABLE);
        db.execSQL(DATABASE_DROP_ACCOUNTS);
        db.execSQL(DATABASE_CREATE_ACCOUNT_DETAILS);
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
        myDB.insert(TABLE_MESSAGES, null, values);
        Log.d("INSERT", "Inserted with key: " + key + " message: " + message );
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

        if(!(cursor == null)){
            cursor.moveToFirst();
            res = cursor.getString(1);
            Log.d("DATABASE",res);
        }

        if(res==null)
            res = "message not found";
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
}
