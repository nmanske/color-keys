import java.awt.event.*;

public class ColorKeys {

    public static void main(String[] args) {
	
        displayLoop();
		
    }
	
	static void displayLoop() {
	
		EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ColorKeysGUI().setVisible(true);
            }
        });

	}

}
