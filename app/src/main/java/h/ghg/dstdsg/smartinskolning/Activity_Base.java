package h.ghg.dstdsg.smartinskolning;

import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.ImageButton;

/**
 * Simple class used as base for all the activities
 * containing the menu button.
 * Created by Linus Granath on 2015-02-01.
 */
public class Activity_Base extends Activity {

    protected ImageButton menu_button;
    protected Controller_Menu controller_menu;
    public void init(){

        /* Retrieve the id of the header layout (menu layout), so we can reach menu_button id*/
        View v = findViewById(R.id.inlHeader);

        /* Retrieve the id of the menu button */
        this.menu_button = (ImageButton)v.findViewById(R.id.ibMenu);

        controller_menu = new Controller_Menu(this);
    }

    public ImageButton getMenu_Button(){
        return menu_button;
    }


    /* Display our custom menu when options is pressed */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        controller_menu.showMenu();
        return true;
    }
}
