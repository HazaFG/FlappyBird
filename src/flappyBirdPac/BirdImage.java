package flappyBirdPac;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class BirdImage {

	private BufferedImage img = null;
	private static int bird_dia = 36;
	public static int x=(JuegoPanel.WIDTH/2)-bird_dia/2;
	public static int y =JuegoPanel.HEIGHT/2;
	
	private static int velocidad = 2;
	private static int aceleracion =1;
	
	public BirdImage() {
		LoadImage();
	}


	private void LoadImage() {
		try {
			img= ImageIO.read(new File("C:/Users/abdie/Downloads/FlappyBird/Images/Pajaro.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	public void drawBird(Graphics g) {
		g.drawImage(img, x, y, null);
	}
	
	public void PajaroMovimiento() {
		if(y>=0 && y<=JuegoPanel.HEIGHT) {
			velocidad += aceleracion;
			y += velocidad;
	
		}else {
			reset();
		}
	}
	
	static int senuelo = 0;
	public static void stopPajaro() {
		while(senuelo == 0) {
			senuelo = 1;
			velocidad = 0;
			aceleracion = 0;
			x=200;
			y=200;
		}
		velocidad = 0;
		aceleracion = 0;
	}

	public void activarPajaro() {
		aceleracion =1;
		velocidad = 2;
		x=(JuegoPanel.WIDTH/2)-bird_dia/2;
		y =JuegoPanel.HEIGHT/2;
	}

	public void reaunudar() {
		velocidad=2;
		
		//y = JuegoPanel.HEIGHT/2;
	}
	
	/*
	public static void stopPajaro() {
		velocidad = 0;
		velocidad -= aceleracion;
		JuegoPanel.ChoqueTubo = false;
		y -= velocidad;
	}
	*/
	
	public void irHaciaArriba() {
		velocidad = -17;
	
	}

	public static void reset() {
		
		velocidad=2;
		y = JuegoPanel.HEIGHT/2;
		JuegoPanel.ChoqueTubo = true;
		//contabilizarScore();
		//JuegoPanel.contScore();
		//JuegoPanel.score++;
		
	}
	
	public static void contabilizarScore() {
		if(JuegoPanel.ti.X==BirdImage.x || JuegoPanel.ti2.X==BirdImage.x) {
			JuegoPanel.score++;	
			JuegoPanel.limiteTubo++;
			System.out.println(JuegoPanel.limiteTubo);
		}
	}
	
	public static Rectangle getBirdRect() {
		Rectangle birdRect = new Rectangle(x,y,bird_dia,35);
		return birdRect;
		
	}
}
