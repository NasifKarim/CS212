import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FileMenuHandler implements ActionListener  {
    RomanNumeralGUI rnGUI;

    public FileMenuHandler (RomanNumeralGUI rn) {
        rnGUI = rn;
    }

    public void actionPerformed(ActionEvent event) {
        String menuName;
        menuName = event.getActionCommand ();
        if (menuName.equals ("Open"))
            openFile ();
        else if ( menuName.equals ("Quit"))
            System.exit (0);


    }

    private void openFile () {
        int status;
        JFileChooser chooser = new JFileChooser ();
        status = chooser.showOpenDialog(null);
        readSource(chooser.getSelectedFile());
    }

    private void readSource (File chosenFile) {
        String chosenFileName = chosenFile.getAbsolutePath();
        TextFileInput inFile = new TextFileInput (chosenFileName);
        String inputLine;
        int subscript = 0;
        Container myContentPane = rnGUI.getContentPane();
        JTextArea myTextArea = new JTextArea();
        JTextArea mySubscripts = new JTextArea();
        myContentPane.add (myTextArea, BorderLayout.EAST);
        myContentPane.add(mySubscripts, BorderLayout.WEST);
        inputLine = inFile.readLine();
        while (inputLine != null) {
            mySubscripts.append(Integer.toString(subscript++) + "\n");
            myTextArea.append (inputLine + "\n");
        }
        rnGUI.setVisible(true);
    }

}
