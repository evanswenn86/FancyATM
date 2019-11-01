package GUI;
import javax.swing.*;
import backend.ATMShell;

public class guiATM extends JFrame {
    public guiATM(){
        if(!ATMShell.CurrentUser.equals("")){
            new guiQuery();
        }
        else{

            new guiLogin();
        }
    }
}
