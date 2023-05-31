package flappyBirdPac;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MenuPanel extends JPanel {

	
	private static final long serialVersionUID=1L;
	
	private BufferedImage img=null;
	public boolean StartingPoint = false;//quitar panel del menu
	
	public MenuPanel() {
		LoadImage();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				StartingPoint=true;//se quita el panel del menu
			}
		});
	}
	
	private void LoadImage() {//imagen panel
		// TODO Auto-generated method stub
		try {
			img= ImageIO.read(new File("C:/Users/abdie/Downloads/FlappyBird/Images/MenuPanel.png"));
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		g.drawImage(img, 0, 0, JuegoPanel.WIDTH, JuegoPanel.HEIGHT, null);
	}
}
