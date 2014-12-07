import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DraggableGraphic extends JFrame {

    private JPanel paintPanel;

    public DraggableGraphic() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(300, 300));

        paintPanel = new  PaintPanel();
        getContentPane().add(paintPanel, BorderLayout.CENTER);
        pack();
    }

    class PaintPanel extends JPanel implements MouseMotionListener,MouseListener {
        private List<Shape> shapes;
        private Shape mouseOverShape=null;

        public PaintPanel(){
            super();
            addMouseListener(this);
            addMouseMotionListener(this);

            shapes = new ArrayList<Shape>();

            shapes.add(new Rectangle2D.Float(25, 15, 60, 30));
            shapes.add(new Rectangle2D.Float(75, 35, 60, 30));
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D)g;
            for (Shape s : shapes){
                g2.draw(s);
            }
        }

        public void mouseDragged(MouseEvent e) {
            if (mouseOverShape!=null){
                if(mouseOverShape instanceof RectangularShape){
                    // Move the shape center to the mouse location
                    RectangularShape rShape = (RectangularShape)mouseOverShape;
                    float width = (float)rShape.getWidth();
                    float height = (float)rShape.getHeight();
                    rShape.setFrame(new Rectangle2D.Float(e.getX()-width/2, e.getY()-height/2, width, height));
                }
                repaint();
            }
        }

        public void mouseMoved(MouseEvent e) {}

        /** returns the first Shape that contains Point p or null if none contain p */
        private Shape hitTest(Point p){
            Shape hitShape = null;
            for (Shape testShape : shapes){
                if (testShape.contains(p)){
                    hitShape = testShape;
                    break;
                }
            }
            return hitShape;
        }


        public void mousePressed(MouseEvent e) {
            // figure out what shape, if any, that we are clicking on
            mouseOverShape = hitTest(e.getPoint());
        }

        public void mouseReleased(MouseEvent e) {
            mouseOverShape = null;
            repaint();
        }

        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }




    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DraggableGraphic().setVisible(true);
            }
        });
    }
}