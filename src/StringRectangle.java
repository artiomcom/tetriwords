import java.awt.*;

public class StringRectangle extends Rectangle {
    protected String label;

    public StringRectangle( String s, int x, int y, int w, int h ) {
        super( x, y, w, h );
        label = s;

    }

    public StringRectangle(String s, Dimension d) {
        super(0, 0, d.width, d.height);
        label = s;
    }


    public void setLabel( String s ) {
        label = s;
    }

    public String getLabel() {
        return label;
    }

    public void drawStringRect( Graphics g, boolean fill,
                                Color rectColor, Color stringColor ) {
        Color old = g.getColor();
        g.setColor( rectColor );
        if( fill ) {
            g.fillRect( x, y, width, height );
        }
        else {
            g.drawRect( x, y, width, height );
        }
        FontMetrics fm = g.getFontMetrics();
        g.setColor( Color.black );
        int stringWidth = fm.stringWidth( label );
        int startX = x + ( ( width - stringWidth ) / 2 );
        int startY = y + ( ( height + fm.getHeight() ) / 2 );
        g.drawString( label, startX, startY );
        g.setColor( old );
    }
}
