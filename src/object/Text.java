package object;

import java.awt.Font;
import java.awt.Graphics;

//Non solid class for displaying messages

public class Text extends NonSolidObject {
	private int width;
	private int height;
	private String text;
	private Font font;
	private boolean reCalculate;  //true if the sizes and positions need to be recalculate
	
	public Text(float a, float b, int width,String text) {
		super(a, b, false);
		this.width = width;
		height = 0;
		setText(text);
	}
	public Text(float a, float b, int width) {
		super(a, b, false);
		this.width = width;
		height = 0;
		setText("");
	}

	public void update() {
		
	}

	public void render(Graphics g) {
		String temp[] = text.split("\n");
		if(reCalculate)
		{
			int sizes[] = new int[temp.length];
			for(int i = 0; i<temp.length;i++)
			{
				g.setFont(new Font(font.getFontName(),font.getStyle(),300));
				int w1 = g.getFontMetrics().stringWidth(temp[i]);
				int fs1 = g.getFontMetrics().getFont().getSize();
				sizes[i] = calculateFontSize(w1,fs1);
			}
			int minSize= 300;
			for(int i = 0; i<sizes.length;i++)
				if(minSize > sizes[i])
					minSize= sizes[i];
			g.setFont(new Font(g.getFont().getFontName(),g.getFont().getStyle(),minSize));
		}
		int height2 = g.getFontMetrics().getHeight();
		int highest = g.getFontMetrics().getMaxAscent();
		
		height = height2*temp.length;
		
		g.drawRect((int)getX(), (int)getY(), width, height2*temp.length);
		
		for(int j = 0;j<temp.length;j++)  //Centers Text
			g.drawString(temp[j], (int)((width-g.getFontMetrics().stringWidth(temp[j]))/2+getX()), (int)getY()+highest*(j+1));
//			g.drawString(temp[j], (int)((width-g.getFontMetrics().stringWidth(temp[j]))/2+getX()), (int)(  getY()+(height*(j+1)/(temp.length+1) ) ) );
	}

	public void setText(String text)
	{
		this.text = text;
		reCalculate= true;
	}
	
	public void setFont(Font font)
	{
		this.font =font;
		reCalculate=true;
	}
	public int calculateFontSize(int w1,int fs1)
	{
		return (int) (0.0+fs1*.9365*width/w1);
	}
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
