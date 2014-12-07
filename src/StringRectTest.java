import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.*;

public class StringRectTest extends Frame {

    public static void main( String[] arg ) {
        new StringRectTest();
    }

    public StringRectTest() {
        super( "Test StringRectangle" );
        add( new MyCanvas() );
        addWindowListener( new WindowAdapter() {
            public void windowClosing( WindowEvent e ) {
                System.exit( 0 );
            }
        } );
        setSize( 300, 300 );
        setVisible( true );
    }

    class MyCanvas extends Canvas implements MouseListener, MouseMotionListener {

        Graphics2D g2;
        StringRectangle rect;

        private java.util.List<StringRectangle> shapes;
        private StringRectangle mouseOverShape=null;

        int preX, preY;

        boolean isFirstTime = true;

        Rectangle area;

        boolean pressOut = false;

        public MyCanvas() {
            char ch;
            shapes = new ArrayList<StringRectangle>();
            int i = 10;
            for( ch = 'a' ; ch <= 'z' ; ch++ ) {
                String s = Character.toString(ch);
                shapes.add(new StringRectangle(s, 0, 0, 50, 50));
            }
            setBackground(Color.white);
            addMouseMotionListener(this);
            addMouseListener(this);
        }

        public void mousePressed(MouseEvent e) {
//            preX = rect.x - e.getX();
//            preY = rect.y - e.getY();
//
//            if (rect.contains(e.getX(), e.getY()))
//                updateLocation(e);
//            else {
//                ShapeMover.label.setText("Drag it.");
//                pressOut = true;
//            }

            mouseOverShape = hitTest(e.getPoint());
        }

        public void mouseDragged(MouseEvent e) {
//            if (!pressOut){
//                updateLocation(e);
//            else/
//                ShapeMover.label.setText("Drag it.");
            if (mouseOverShape!=null){
                if(mouseOverShape instanceof StringRectangle){
                    // Move the shape center to the mouse location
                    StringRectangle rShape = mouseOverShape;
                    float width = (float)rShape.getWidth();
                    float height = (float)rShape.getHeight();
//                    rShape.setLocation(preX + e.getX(), preY + e.getY());
                    rShape.setFrame(new StringRectangle.Float(e.getX()-width/2, e.getY()-height/2, width, height));
                    repaint();
                }

            }


        }

        public void mouseReleased(MouseEvent e) {
//            if (rect.contains(e.getX(), e.getY()))
//                updateLocation(e);
//            else {
//                ShapeMover.label.setText("Drag it.");
//                pressOut = false;
//            }
            mouseOverShape = null;
            repaint();
        }

        public void mouseMoved(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        /** returns the first Shape that contains Point p or null if none contain p */
        private StringRectangle hitTest(Point p){
            StringRectangle hitShape = null;
            for (StringRectangle testShape : shapes){
                if (testShape.contains(p)){
                    hitShape = testShape;
                    break;
                }
            }
            return hitShape;
        }

        public void updateLocation(MouseEvent e) {
            rect.setLocation(preX + e.getX(), preY + e.getY());

            if (checkRect()) {
                ShapeMover.label.setText(rect.getX() + ", " + rect.getY());
            } else {
                ShapeMover.label.setText("drag inside the area.");
            }

            repaint();
        }

        public void paint(Graphics g) {
            update(g);
        }

        public void update(Graphics g) {

            Graphics2D g2 = (Graphics2D) g;
            Dimension dim = getSize();
            int w = (int) dim.getWidth();
            int h = (int) dim.getHeight();
            g2.setStroke(new BasicStroke(8.0f));


            for (StringRectangle s : shapes){
//                if(s instanceof StringRectangle) {
                g2.setPaint(Color.white);
//                g2.fillRect(0, 0, w, h);
//                g2.setColor(Color.red);

                g2.draw(s);

//                    s.setLocation(w / 2 - 50, h / 2 - 25);


//                    g2.setColor(Color.green);
//                    g2.fill(s);
//                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
//                            RenderingHints.VALUE_ANTIALIAS_ON);
//                    Font font = new Font("Serif", Font.PLAIN, 45);
//                    g2.setFont(font);
                    s.drawStringRect(g, true, Color.red, Color.yellow);
//                }
            }

//            if (isFirstTime) {
//                area = new Rectangle(dim);
//
//                rect.setLocation(w / 2 - 50, h / 2 - 25);
//
//                isFirstTime = false;
//            }
        }

        boolean checkRect() {
            if (area == null) {
                return false;
            }

            if (area.contains(rect.x, rect.y, 100, 50)) {
                return true;
            }
            int new_x = rect.x;
            int new_y = rect.y;

            if ((rect.x + 100) > area.getWidth()) {
                new_x = (int) area.getWidth() - 99;
            }
            if (rect.x < 0) {
                new_x = -1;
            }
            if ((rect.y + 50) > area.getHeight()) {
                new_y = (int) area.getHeight() - 49;
            }
            if (rect.y < 0) {
                new_y = -1;
            }
            rect.setLocation(new_x, new_y);
            return false;
        }
    }
}
