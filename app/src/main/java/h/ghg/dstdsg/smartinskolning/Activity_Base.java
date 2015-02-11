package h.ghg.dstdsg.smartinskolning;

import android.app.Activity;
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
        controller_menu = new Controller_Menu(this);
    }

    public ImageButton getMenu_Button(){
        return menu_button;
    }
}
