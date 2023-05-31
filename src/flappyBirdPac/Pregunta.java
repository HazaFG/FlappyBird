package flappyBirdPac;

public class Pregunta {
	
	private String pregunta;
	private int respuesta;
	/*private int resDos;
	private int resTres;*/
	
	private String resUno;
	public String getResUno() {
		return resUno;
	}

	public void setResUno(String resUno) {
		this.resUno = resUno;
	}

	public int getRespuesta() {
		return respuesta;
	}

	private String resDos;
	private String resTres;
	
	public Pregunta(String pregunta, String resUno, String resDos, String resTres,int respCorrecta) {
		this.pregunta = pregunta;
		this.resUno = resUno;
		this.resDos = resDos;
		this.resTres = resTres;
		
	}
	
	public Pregunta(String pregunta, String resUno, String resDos, String resTres) {
		this.pregunta = pregunta;
		this.resUno = resUno;
		this.resDos = resDos;
		this.resTres = resTres;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	public String getRespuesta(int i)
	{
		if(i==0)
			return resUno;
		else
			if(i==1)
				return resDos;
		return resTres;
	}

	//@Override
	/*public String toString() {
		return "Pregunta [pregunta=" + pregunta + ", resUno=" + resUno + ", resDos=" + resDos + ", resTres=" + resTres
				+ ", _resUno=" + _resUno + ", _resDos=" + _resDos + ", _resTres=" + _resTres + "]";
	}*/
}