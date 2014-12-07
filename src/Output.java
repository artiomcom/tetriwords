import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Output extends JFrame
{
    public static String newline1 = System.getProperty("line.separator");

    /**
     *
     */
    public Output()
    {
        //Set JFrame title
        setTitle("Draw A Rectangle In JFrame");

        //Set default close operation for JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Set JFrame size
        setSize(1500,1500);

        //Make JFrame visible
        setVisible(true);
    }
    @Override
    public void paint(Graphics g)
    {
        ArrayList<String> classlist=new ArrayList<String>();
        classlist.add("library");
        classlist.add("customer");
        classlist.add("member");
        classlist.add("card");
        classlist.add("yes");
        classlist.add("aaa");
        super.paint(g) ;
        int b=classlist.size();
        int a=(classlist.size())/2;
        for(int i=0;i<a;i++)
        {
            int x=i*200+50;
            int y=50;
            int w=x+25;
            int z=y+25;
            String thisclass= classlist.get(i);
            //draw rectangle outline
            System.out.println(thisclass);
            g.drawRect(x,y,150,100);
            g.drawString(thisclass,w ,z);
        }
        for(int j=b-1;j>=a;j--)
        {
            int x=j*200+50;
            int y=250;
            int w=x+25;
            int z=y+25;
            String thisclass= classlist.get(j);
            //draw rectangle outline
            System.out.println(thisclass);
            g.drawRect(x,y,150,100);
            g.drawString(thisclass,w ,z);
        }
        //System.out.println(newline1);
    }

    public static void main(String[]args)
    {

        Output dlijf;
        dlijf = new Output();
    }
} 