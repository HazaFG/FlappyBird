package flappyBirdPac;

import java.awt.Font;
import java.awt.Graphics;
//import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class JuegoPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public static boolean ChoqueTubo = false;
	public static int score=0;
	
	public static int limiteTubo=0;
	
	public static final int WIDTH=600;
	public static final int HEIGHT=800;
	
	private int xCoor=0;
	private BufferedImage img;
	
	static BirdImage birdImage= new BirdImage();
	
	static TuboImagen ti= new TuboImagen(JuegoPanel.WIDTH);
	static TuboImagen ti2= new TuboImagen(JuegoPanel.WIDTH+(JuegoPanel.WIDTH/2));
	
	public JuegoPanel() {
		LoadImage();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				birdImage.irHaciaArriba();
				
			}
			
		});
		

	}

	private void LoadImage() {
		// TODO Auto-generated method stub
		try {
			img = ImageIO.read(new File("C:/Users/abdie/Downloads/FlappyBird/Images/JuegoPanel.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		g.drawImage(img, xCoor, 0, null);
		g.drawImage(img, xCoor+1200, 0, null);
		
		birdImage.drawBird(g);
		ti.drawTubo(g);
		ti2.drawTubo(g);
		
		g.setFont(new Font("Tahoma", Font.BOLD,35));
		g.drawString("PUNTOS: "+score+" / 30", WIDTH/2-20,100);
	}
	
	public static void stop() {
			BirdImage.stopPajaro();;
			ti.stopTubo();
			ti2.stopTubo();
	}
	
	public static void reaunudar() {
		birdImage.PajaroMovimiento();
		ti.tuboMovimiento();
		ti2.tuboMovimiento();
	}
	
	public static void contabilizarScore() {
		if(JuegoPanel.ti.X==BirdImage.x || JuegoPanel.ti2.X==BirdImage.x) {
			System.out.println("REAUNUDAR");
			JuegoPanel.score++;	
			JuegoPanel.limiteTubo++;
			System.out.println(limiteTubo);
		}
	}
	
	static int choqueP = 0;
	
	public static void contScore() {
		if(ti.X==BirdImage.x || ti2.X==BirdImage.x) {
			System.out.println("PUNTITO");
			score++;
			limiteTubo++;
			System.out.println(limiteTubo);
		}
	}
	
	public void Mover() {
		
		pregunta_1 cuestionario = new pregunta_1();
		reaunudar();
		
		if(ChoqueTubo) {
			cuestionario.setVisible(true);
			choqueP = 1;
			ti.X=JuegoPanel.WIDTH;
			ti2.X=JuegoPanel.WIDTH+(JuegoPanel.WIDTH/2);
			ChoqueTubo = false;
			limiteTubo++;
			stop();
		}
		
		xCoor+=TuboImagen.velocidad;
		if(xCoor==-2400) {
			xCoor = 0;
		}
		
		contScore();
		
		if(limiteTubo == 30 && score <=30) {
			ImageIcon icono = new ImageIcon("C:/Users/abdie/Downloads/FlappyBird/Images/congratulation.png");
			
	        JOptionPane.showMessageDialog(null, "¡Felicidades, conseguiste "+score+" puntos!",
	        "Flappy Bird", JOptionPane.INFORMATION_MESSAGE, icono);
	        
		    System.exit(0);
			
		}
	}
}
