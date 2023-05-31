package flappyBirdPac;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;

public class MainBird {

	//Ventana
	//Menu primer panel
	
	//segundo panel cntiene todo el juego
	
	private JFrame window;
	private Timer timer;
	
	private MainBird() {
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(JuegoPanel.WIDTH,JuegoPanel.HEIGHT);
		window.setLocationRelativeTo(null);
		window.setTitle("Flappy Bird");
		
		/*Image iconoPropio = Toolkit.getDefaultToolkit().getImage(getClass().getResource("C:/Users/aluce/eclipse-workspace/FlappyBird/Images/Icon.png"));
		setIconImage(iconoPropio);*/
		
		//window.setResizable(false);
		window.setVisible(true);
	}


	private void rendering() {
		MenuPanel mp = new MenuPanel();
		JuegoPanel gp = new JuegoPanel();
		
		timer = new Timer(20, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				gp.repaint();
				gp.Mover();
				
			}
		});
		
		window.getContentPane().add(mp);
		window.setVisible(true);
		
		while(mp.StartingPoint==false) {
			try {
				Thread.sleep(10);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		
		window.remove(mp);
		window.getContentPane().add(gp);
		window.revalidate();
		timer.start();
		
		//BirdImage.contabilizarScore();
		
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainBird mb = new MainBird();
		mb.rendering();
		try{
			AudioInputStream audio = AudioSystem.getAudioInputStream(new File("C:/Users/abdie/Downloads/FlappyBird/Sonidos/musicaPou.wav").getAbsoluteFile());
			Clip fondo = AudioSystem.getClip();
			fondo.open(audio);
			fondo.start();
			fondo.loop(Clip.LOOP_CONTINUOUSLY);
		}catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex){System.out.println("Error");}
	}
}
