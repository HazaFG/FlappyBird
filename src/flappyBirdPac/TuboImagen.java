package flappyBirdPac;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class TuboImagen {
	//video 6
	private Random r = new Random();
	public int X;
	public int Y = r.nextInt(JuegoPanel.HEIGHT-400)+200;//max 600 min 200//video 6 min3 
	private int width_tubo = 45;
	private int height = JuegoPanel.HEIGHT-Y;
	private int gap=200;
	private boolean chocaTubo;
	
	public static int velocidad = -6;
	
	private BufferedImage img = null;
	
	public TuboImagen(int X) {
		this.X=X;
		chocaTubo=false;
		LoadImage();
	}

	private void LoadImage() {
		try {
			img= ImageIO.read(new File("C:/Users/abdie/Downloads/FlappyBird/Images/Tubo.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void drawTubo(Graphics g) {
		g.drawImage(img, X, Y, null);//abajooooooo
		g.drawImage(img, X, (-JuegoPanel.HEIGHT)+(Y-gap), null);//arriba
	}
	
	public void tuboMovimiento() {
		
		X+=velocidad;
		
		if(X<=-width_tubo) {
			X = JuegoPanel.WIDTH;
			Y = r.nextInt(JuegoPanel.HEIGHT-400)+200;
			height = JuegoPanel.HEIGHT-Y;
		}
		
		Rectangle lowerRect = new Rectangle(X,Y,width_tubo,height);
		Rectangle upperRect = new Rectangle(X,0,width_tubo,JuegoPanel.HEIGHT-(height+gap));
		
		if(lowerRect.intersects(BirdImage.getBirdRect())||upperRect.intersects(BirdImage.getBirdRect())) {
			try{
				AudioInputStream audio = AudioSystem.getAudioInputStream(new File("C:/Users/aluce/eclipse-workspace/FlappyBird/Sonidos/choque.wav").getAbsoluteFile());
				Clip fondo = AudioSystem.getClip();
				fondo.open(audio);
				fondo.start();
				
			}catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex){System.out.println("Error");}
			
			BirdImage.reset();
			tubo_Reset();
		}

	}
	
	/*
	public static void stop() {
		JuegoPanel.stopPajaro();;
		ti.stopTubo();
		ti2.stopTubo();
	}
	*/
	public void activarTubo() {
		velocidad = -6;
		//JuegoPanel.contScore();
	}
	
	
	public void stopTubo() {
		velocidad = 0;
		//JuegoPanel.contScore();
		//X = 0;
	}

	public boolean isChocaTubo() {
		return chocaTubo;
	}

	private void tubo_Reset() {
		Y = r.nextInt(JuegoPanel.HEIGHT-400)+200;
		height = JuegoPanel.HEIGHT-Y;
		JuegoPanel.ChoqueTubo = true;//acabar juego vide10 min1:50
		//JuegoPanel.score++;

	}

	
}
