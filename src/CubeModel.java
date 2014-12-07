import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by php on 12/7/14.
 */
public class CubeModel extends JLabel {

    private String currentletter;
    private String[] letters;
    private String[] words;
    private String currentword;
    private JLabel cube;

    private static CubeModel instance = null;


    public CubeModel() {
    }

    public CubeModel(JLabel cube, String currentletter) {
        this.cube = cube;
        this.currentletter = currentletter;

        Border border = BorderFactory.createLineBorder(Color.BLUE, 5);
        cube.setText(currentletter);
        cube.setBorder(border);
     }

    public static CubeModel getInstance(JLabel cube, String currentletter) {
        if(instance == null) {
            instance = new CubeModel(cube,currentletter);
        }
        return instance;
    }

    public String getCurrentletter() {
        return currentletter;
    }

    public String[] getLetters() {
        return letters;
    }

    public String[] getWords() {
        return words;
    }

    public String getCurrentword() {
        return currentword;
    }

    public JLabel getCube() {
        return cube;
    }


    public void setCurrentletter(String currentletter) {
        currentletter = currentletter;
    }

    public void setLetters(String[] letters) {
        this.letters = letters;
    }

    public void setWords(String[] words) {
        this.words = words;
    }

    public void setCurrentword(String currentword) {
        this.currentword = currentword;
    }

    public void setCube(JLabel cube) {
        this.cube = cube;
    }
}
