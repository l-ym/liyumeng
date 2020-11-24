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

	Image heroImg[][] = new Image[4][3];
	Image currentimg,bossimg;
	int heroy=140,herox=120,i,j£¬bossx=0,bossy=0;
	public MainCanvas(){
		try
		{
			/*
			0:left 1:right 2:down 3:up
			*/
			for(i=0;i<heroImg.length;i++){
				for(j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			
				}	
			}
			currentimg=Image.createImage("/sayo20.png");
			bossimg=Image.createImage("")
			thread=new Thread(this);
			thread.start();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void run(){
		while(true){
			repaint();
			try{
				Thread.sleep(200);//FPS:ÆÁÄ»Ë¢ÐÂÂÊ
			}
			catch(InterruptedException e){
				e.printStackTrace();
			}
			if(bossx<herox){
				bossx++;
				
			}
			else{
				bossx--;
			}
			if(bossy<hero){
				bossy++;
			}
			else{
				bossy--;
			}
	}

	public void paint(Graphics g){
		g.setColor(0,255,255);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentimg,herox,heroy,0);
	}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);

		if(action==LEFT)
		{
			herox=herox-1;
			if(herox%2==0){
				currentimg=heroImg[0][1];
				
			}
			else{
				
				currentimg=heroImg[0][2];
				
			}
			
		}

		if(action==UP){
			heroy=heroy-1;
			if(heroy%2==0){
				currentimg=heroImg[3][1];
				
			}
			else{
				currentimg=heroImg[3][2];
				
			}
		}

		if(action==RIGHT){
			herox=herox+1;
			if(herox%2==0){
				currentimg=heroImg[1][1];
				
			}
			else{
				currentimg=heroImg[1][2];
				
			}
		}

		if(action==DOWN){
			heroy=heroy+1;
			if(heroy%2==0){
				currentimg=heroImg[2][1];
				
			}
			else{
				currentimg=heroImg[2][2];
				
			}
			
		}
	}
}