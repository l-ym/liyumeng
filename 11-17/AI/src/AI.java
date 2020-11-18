import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;
public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	Image currentImg,img1,img2,img3,img4,img02,img22;
	int y=140,x=120;
	public MainCanvas(){
		try
		{
			img1=Image.createImage("/sayo10.png");/*正*/
			img2=Image.createImage("/sayo12.png");/*左*/
			img3=Image.createImage("/sayo14.png");/*上*/
			img4=Image.createImage("/sayo16.png");/*右*/
			img02=Image.createImage("/sayo02.png");/*左走1*/
			img22=Image.createImage("/sayo22.png");/*左走2*/
			currentImg=img1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,255,255);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		if(action==LEFT)
		{
			currentImg=img2;
			x=x-3;
			if(x%2==0){		
				currentImg=img22;
			}
			else{
				currentImg=img02;
			}
			repaint();
		}

		if(action==UP){
			if(currentImg==img3&y!=0){
				y=y-3;
			}

			else{
				currentImg=img3;
			}
			repaint();
		}

		if(action==RIGHT){
			if(currentImg==img4){
				x=x+3;
			}

			else{
				currentImg=img4;
			}
			repaint();
		}

		if(action==DOWN){
			if(currentImg==img1){
				y=y+3;
			}

			else{
				currentImg=img1;
			}
			repaint();
		}
	}
}