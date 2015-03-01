package h.ghg.dstdsg.smartinskolning;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;


public class Activity_Login extends Activity {

    private Controller_Login controller;
    private Button btnLogin;
    private EditText etAccount;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity__login);
        init();
    }

    private void init(){
        btnLogin = (Button)findViewById(R.id.btnLogin);
        controller = new Controller_Login(this);
        etAccount = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
    }

    public EditText getEtAccount(){ return etAccount; }
    public EditText getEtPassword(){ return etPassword; }
    public Button getBtnLogin(){
        return btnLogin;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }


}
