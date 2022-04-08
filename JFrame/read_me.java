/*
    Write two Java classes named Draw and ManageDraw.
    Draw class has two integer variables x, y and a string variable text.
    Draw class has a constructor:
    The constructor takes x- y coordinates and a text as parameters

    Draw class has also a method named print() which moves the text variable right,down,left and up respectively.
        public void print(Graphics g, Dimension size);
 */

/*
    Preliminaries

    • Import java.awt.* and javax.swing.* packages into both classes.
    • Create an object of type Draw Class
    • JFrame win;
    • Container contentPane;
    • Graphics g;
    • win = new JFrame("My First Rectangle");
    • win.setSize(300, 200);
    • win.setLocation(100,100);
    • win.setVisible(true);
    • win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    • contentPane = win.getContentPane();
    • g = contentPane.getGraphics();
    • Call print method
 */

/*
    Preliminaries

    + to put a delay before drawing the text.
    • try {Thread.sleep(200);} catch (Exception e) {}

    + To get the width and height of text variable.
    • Rectangle2D r = g.getFontMetrics().getStringBounds(text, g);
    • int text_width=(int)r.getWidth();
    • int text_height=(int)r.getHeight();

    • g.clearRect(0, 0, size.width, size.height); to clear the frame
 */
