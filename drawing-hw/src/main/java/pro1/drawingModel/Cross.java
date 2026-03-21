package pro1.drawingModel;

import java.awt.*;


public class Cross extends WidthHeight{
    private  String  color;

    public Cross(int x, int y, int Size, String color) {
        super(x,y,Size, Size);
        this.color = color;
    }
    @Override
    public void draw (Graphics2D g){
        g.setColor(Color.decode(this.color));
        g.drawLine(this.x, this.y + this.height / 2, this.x + this.width, this.y + this.height / 2);
        g.drawLine(this.x + this.width / 2, this.y, this.x + this.width / 2, this.y + this.height);
    }
}
