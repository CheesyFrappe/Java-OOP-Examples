import javax.swing.*;
import java.awt.*;

public class ManageDraw {

    public static void main(String[] args) {

        Draw drawRectangle = new Draw(50, 100, "Hello Java");

        JFrame win;
        Container contentPane;
        Graphics g;

        win = new JFrame("Draw Rectangle");
        win.setSize(500, 200);
        win.setLocation(100, 100);
        win.setVisible(true);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = win.getContentPane();
        g = contentPane.getGraphics();

        drawRectangle.print(g, win.getContentPane());
    }

}
