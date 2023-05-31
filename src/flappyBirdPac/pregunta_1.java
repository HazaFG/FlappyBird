package flappyBirdPac;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

public class pregunta_1 extends JDialog {

	
	private JPanel contentPane;
	
	public static int getValidar() {
		return validar;
	}
	
	static BirdImage birdImage= new BirdImage();
	static TuboImagen ti= new TuboImagen(JuegoPanel.WIDTH);
	static TuboImagen ti2= new TuboImagen(JuegoPanel.WIDTH+(JuegoPanel.WIDTH/2));

	public static void setValidar(int validar) {
		pregunta_1.validar = validar;
	}



	int iPregunta,iRespuesta;
	JLabel holaLbl = new JLabel();
	
	static int validar = 1;
	
	
	JuegoPanel juegoso = new JuegoPanel();



	Pregunta[] preguntas = { 	new Pregunta ("¿Qué significa soberanía?", "Es el poder político supremo de un estado independiente."," Permite elegir la forma de organización política, económica y social más adecuada con base a los intereses y características de cada nación"," Es la facultad de las personas en conjunto para ejercer autoridad o poder político", 2),
								new Pregunta ("Ante la intervención, el segundo imperio y república restaurada Santa Anna estableció una dictadura que fue…","Aceptada por el pueblo.","Rápidamente rechazada","Rápidamente rechazada por ser de carácter despótico.",2),
								new Pregunta ("¿Cuál era el principal motivo del porfiriato?","Mejorar la agricultura y ganadería"," Mejorar la calidad educativa","Resolver los problemas económicos",2),
								new Pregunta ("¿Cuáles son las causas internas del movimiento independista?","El pensamiento ilustrado, La independencia de las trece colonias Norteamérica y la revolución francesa"," La invención francesa a España y la crisis económica del imperio español","Los borbones en España, La crisis económica del imperio español, Las reformas Borbónicas, La invasión francesa a España, La constitución de Cádiz, el conflicto de Nueva España.",2),
								new Pregunta ("¿Cuáles son las causas externas del movimiento independista?","Los borbones en España, La crisis económica del imperio español, Las reformas Borbónicas, La invasión francesa a España, La constitución de Cádiz, el conflicto de Nueva España.","La revolución francesa","El pensamiento ilustrado, La independencia de las trece colonias Norteamérica y la revolución francesa.",2),
								new Pregunta ("¿Cuántas etapas del movimiento independista hubo?","6","8","4",2),
								new Pregunta ("“Agustín de Iturbide destacó en el ejército y fue bien recibido por la nobleza.”","Falso","Verdadero","Por sus ideas conciliadoras",2),
								new Pregunta ("¿Cuáles fueron los conflictos internacionales de Mexico?","La independencia de México, la constitución de 1814 y la república en 1824","Intervenciones extranjeras y problemas internos","La independencia Texas, primera intervención francesa y la guerra de 1847",2),
								new Pregunta ("La Guerra de reforma, ¿cuánto tiempo duró?","Cinco Dias","Seis años","Tres años",2),
								new Pregunta ("¿Qué cambios hubo en el país después del gobierno de Porfirio Díaz?","Las haciendas se habían visto perjudicadas.","Mejorías en los ferrocarriles."," Modernización y nuevas infraestructuras.",2),
								new Pregunta ("¿Qué grupo indígena mexicano fue quiénes se vieron más afectados en el Porfiriato?","Ninguno"," Los mixtecos","Los Yaquis.",2),
								new Pregunta ("¿Por qué se llevó a cabo la huelga de Cananea y Río Blanco?"," Se manifestaron por las condiciones de su trabajo","Solicitaban aumentos en los salarios"," Su ambiente laboral era inferior a la de los empleados estadounidenses de la misma compañía y solicitaban las mismas condiciones",2),
								new Pregunta ("¿Cuáles son los principales problemas en nuestro país?","Falta de tecnología, Problemas en los salarios y problemas geográficos","Feminicidios y homicidios, problemas educativos y problemas sociales","Problemas sociales, problemas económicos y problemas culturales.",2),
								new Pregunta ("¿Cuáles son los artículos que han sido cambiados para el bien de nuestra sociedad?"," El artículo de la educación, el artículo de las tierras, las aguas y subsuelos y el artículo sobre los derechos y obligaciones de los trabajadores"," Ningún artículo ha sido modificado nunca","Artículos 3ro, artículo 27 y artículo 123",2),
								new Pregunta ("¿Qué significa la guerra sucia?","Acciones ilegales con ayuda del ejército","Las huelgas en dónde terminaban con actos de violencia","Los mecanismos de tortura y desaparición de personas promovidas por el gobierno contra sus adversarios",2),
								new Pregunta ("¿Por qué el país no mejoró económicamente durante el gobierno de José López Portillo con la venta del petróleo?","No había suficientes pozos para la extracción","Se confió en la venta del petróleo","Por la mal inversión que se tuvo con la venta del petróleo, pues se llegaron a solicitar préstamos para mejorar otras áreas con menor importancia para el país",2),
								new Pregunta ("¿En qué año México llegó a su máxima expresión de “crisis económica”?","En 1976","Durante el sexenio de Luis Echeverría Álvarez","1976 en las elecciones de candidato José López Portillo",2),
								new Pregunta ("¿En qué año fue fundado el Instituto Federal Electoral (IFE), actualmente Instituto Nacional Electoral (INE)?","1988","1970","1993",2),
								new Pregunta ("¿Qué medio de comunicación han causado mayor impacto en el siglo XX?","Televisiones, internet y radios","Revistas, periódicos y radios","La radio, la televisión y el internet y la globalización de las telecomunicaciones.",2),
								new Pregunta ("¿Cuál es el principal reto en la educación y en la salud?","Malas infraestructuras","Falta de recursos económico","El crecimiento de población.",2),
								};
	
	JButton[] botones = new JButton[3];
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pregunta_1 frame = new pregunta_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	

	/**
	 * Create the frame.
	 */
	public pregunta_1() {
		
		Random aleatorio = new Random();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 1500, 1050);
		contentPane = new JPanel();
		FlowLayout flowLayout = (FlowLayout) contentPane.getLayout();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		holaLbl.setHorizontalAlignment(SwingConstants.CENTER);
		holaLbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		holaLbl.setBounds(161, 117, 193, 14);
		
		// proceso de validacion para que o se repita la pregunta
		iPregunta= Math.abs(aleatorio.nextInt())% preguntas.length;
		//System.out.println(iPregunta);
		
		holaLbl.setText(preguntas[iPregunta].getPregunta());
		
		contentPane.add(holaLbl);
		
		int i;
		i = Math.abs(aleatorio.nextInt()%botones.length);
		//System.out.println("HOLA: " +i);
		
		boolean auxCero = true;
		boolean auxUno = true;
		boolean auxDos = true;
			
		switch(i) {
		
			case 0:
				//BOTON UNO
				botones[0] = new JButton(preguntas[iPregunta].getRespuesta(0));
				botones[0].setBounds(10, 258, 400, 200);
			
				agregarAccion(botones[0], 0);
			
				contentPane.add(botones[0]);
				
				//BOTON DOS
				botones[1] = new JButton(preguntas[iPregunta].getRespuesta(1));
				botones[1].setBounds(10, 258, 400, 200);
			
				agregarAccion(botones[1], 1);
			
				contentPane.add(botones[1]);
				
				//BOTON TRES
				botones[2] = new JButton(preguntas[iPregunta].getRespuesta(2));
				botones[2].setBounds(10, 258, 400, 200);
			
				agregarAccion(botones[2], 2);
			
				contentPane.add(botones[2]);
			break;
		
			case 1:
				botones[1] = new JButton(preguntas[iPregunta].getRespuesta(1));
				botones[1].setBounds(10, 258, 400, 200);
			
				agregarAccion(botones[1], 1);
			
				contentPane.add(botones[1]);
				
				//BOTON DOS
				botones[0] = new JButton(preguntas[iPregunta].getRespuesta(0));
				botones[0].setBounds(10, 258, 400, 200);
			
				agregarAccion(botones[0], 0);
			
				contentPane.add(botones[0]);
				
				//BOTON TRES
				botones[2] = new JButton(preguntas[iPregunta].getRespuesta(2));
				botones[2].setBounds(10, 258, 400, 200);
			
				agregarAccion(botones[2], 2);
			
				contentPane.add(botones[2]);
				break;
		
			case 2:
				//BOTON UNO
				botones[1] = new JButton(preguntas[iPregunta].getRespuesta(1));
				botones[1].setBounds(10, 258, 400, 200);
			
				agregarAccion(botones[1], 1);
			
				contentPane.add(botones[1]);
				
				//BOTON DOS
				botones[2] = new JButton(preguntas[iPregunta].getRespuesta(2));
				botones[2].setBounds(10, 258, 400, 200);
			
				agregarAccion(botones[2], 2);
			
				contentPane.add(botones[2]);
				
				//BOTON TRES
				botones[0] = new JButton(preguntas[iPregunta].getRespuesta(0));
				botones[0].setBounds(10, 258, 400, 200);
			
				agregarAccion(botones[0], 0);
			
				contentPane.add(botones[0]);
				
				break;
		}
	}
		
	public void dispose() {
		super.dispose();
	}
	
	
	void agregarAccion(final JButton boton, final int i){
		boton.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent evento){
					
					birdImage.activarPajaro();
					ti.activarTubo();
					ti2.activarTubo();
					
					
					iRespuesta=i;
					System.out.println(iRespuesta);
					
					if(i==2) {
						//JuegoPanel.choqueP = 0;
						
						try{
							AudioInputStream audio = AudioSystem.getAudioInputStream(new File("C:/Users/abdie/Downloads/FlappyBird/Sonidos/correcto.wav").getAbsoluteFile());
							Clip fondo = AudioSystem.getClip();
							fondo.open(audio);
							fondo.start();
							//fondo.loop(Clip.LOOP_CONTINUOUSLY);
						}catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex){System.out.println("Error");}
						
						JuegoPanel.score = JuegoPanel.score+2;
						holaLbl.setText("RESPUESTA CORRECTA!");
						System.out.println("TIENES UN PUNTO EXTRA!");
						
					}else if(i==1){
						try{
							AudioInputStream audio = AudioSystem.getAudioInputStream(new File("C:/Users/abdie/Downloads/FlappyBird/Sonidos/correcto.wav").getAbsoluteFile());
							Clip fondo = AudioSystem.getClip();
							fondo.open(audio);
							fondo.start();
							//fondo.loop(Clip.LOOP_CONTINUOUSLY);
						}catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex){System.out.println("Error");}
						
						JuegoPanel.score++;
						System.out.println("RESPUESTA INCORRECTA!");
						holaLbl.setText("RESPUESTA INCORRECTA!");
					}else {
						try{
							AudioInputStream audio = AudioSystem.getAudioInputStream(new File("C:/Users/abdie/Downloads/FlappyBird/Sonidos/incorrecto.wav").getAbsoluteFile());
							Clip fondo = AudioSystem.getClip();
							fondo.open(audio);
							fondo.start();
					
						}catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex){System.out.println("Error");}
						
						JuegoPanel.score--;
					}
					
					dispose();
				}
			});
	}
}

