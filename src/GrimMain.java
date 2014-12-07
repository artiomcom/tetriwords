///*
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.Graphics;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.*;
// 
//class GrimMain {
//static JFrame frame = new JFrame();
//      //final static List<Rect> rectangles = new ArrayList<Rect>();
//              //final static int count = 0;
//             
//              public static void main(String[] args) {
//            DrawingComponent fps = new DrawingComponent();
//            Rect r1 = new Rect(100, 100, 100, 100, Color.red);
//            Rect r2 = new Rect(300, 100, 100, 100, Color.blue);
//             
//            fps.addRect(r1);
//            fps.addRect(r2);
//             
//            fps.animate();
//         
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            fps.setPreferredSize(new Dimension(800, 600));
//            frame.getContentPane().add(fps);
//            frame.pack();
//            frame.setLocationRelativeTo(null);
//            frame.setVisible(true);
//          }
//}
// 
//class Rect {
//      int x;
//      int y;
//      int height;
//      int width;
//      Color color;
//      Rect(int x, int y, int width, int height, Color color) {
//            this.x = x;
//            this.y = y;
//            this.width = width;
//            this.height = height;
//            this.color = color;
//          }
//     
//              public void draw(Graphics g) {
//            g.setColor(color);
//            g.fillRect(x, y, width, height);
//          }
//     
//              public int getY() {
//            return y;
//          }
//       
//              public int getHeight() {
//            return height;
//          }
//       
//              public void setY(int y) {
//            this.y = y;
//          }
//}
// 
//class DrawingComponent extends JComponent {
//      private static final int ANIMATION_DELAY = 10;
//      private List<Rect> rectList = new ArrayList<Rect>();
//      private int deltaY = 2;
//       
//              DrawingComponent() {
//          }
//       
//              public void animate() {
//            new Timer(ANIMATION_DELAY, new ActionListener() {
//                  public void actionPerformed(ActionEvent arg0) {
//                        for (Rect rect : rectList) {
//                              int y = rect.getY();
//                              if (y + rect.getHeight() >= getHeight()) {
//                                    deltaY = -Math.abs(deltaY);
//                                  }
//                              else if (y <= 0) {
//                                    deltaY = Math.abs(deltaY);
//                                  }
//                               
//                              rect.setY(y + deltaY);
//                            }
//                        repaint();
//                      }
//                }).start();
//          }
//     
//              public void addRect(Rect rect) {
//            rectList.add(rect);
//          }
//     
//              @Override
//      public void paintComponent(Graphics g) {
//            super.paintComponent(g);
//            for (Rect rect : rectList) {
//                  rect.draw(g);
//                }
//          }
//}*/
