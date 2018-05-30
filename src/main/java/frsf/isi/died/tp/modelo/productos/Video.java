package frsf.isi.died.tp.modelo.productos;
/**
 * Video es una clase que especializa la clase MAterialCapacitacion
 * @author Agustin, Milton
 *
 */
public class Video extends MaterialCapacitacion {
	
	/**
	 * Duracion del video en segundos
	 */
	private Integer duracion;
	
	/**
	 *costo Por Segundo constante que se cobra por la reproduccion del video 
	 */
	private static final Double costoPorSegundo = 0.15;
	
	/**
	 * Constructor por defecto del Video
	 */
	public Video() {
	}
	
	/**
	 * permite crear un Video solo con su titulo e identificador
	 * @param id es el identificador del Video
	 * @param titulo es el titulo del Video
	 */
	public Video(Integer id,String titulo) {
		this(id, titulo, 0.0, 0);
	}
	
	/**
	 * permite crear un Video con todos sus parametros
	 * @param id es el identificador del Video
	 * @param titulo es el titulo del Video
	 * @param costo es el costo de ofrecerlo online
	 */
	public Video(Integer id,String titulo, Double costo, Integer duracion) {
		super(id, titulo, costo);
		this.duracion = duracion;
	}
    
	/**
	 *Retorna FALSO si el Material de Capacitacion es del 
	 *tipo Video, de lo contrario retorna VERDADERO
	 *@return 
	 */
	@Override
	public Boolean esLibro() {
		Boolean bool = this instanceof Video;
		if(bool)bool = false;
		else bool = true;
		return bool;
	}
    
	/**
	 *Retorna VERDADERO si el Material de Capacitacion es del 
	 *tipo Video, de lo contrario retorna FALSO
	 *@return 
	 */
	@Override
	public Boolean esVideo() {
		Boolean bool = this instanceof Video;       
		return bool;
	}
	
	/**El precio de un video se calcula simplemente como la suma de A + B donde :
	 * A: costo del material de capacitación (valor heredado de la clase MaterialCapacitacion)
	 * B: cantidad de segundos que dura el video multiplicado por el costo por segundo.
	 */
	@Override
	public Double precio() {
		Double precio = this.costo + this.duracion*Video.costoPorSegundo;
		return precio;
	}
	
	  /**
     * Evalua si dos objetos son de la clase Video y si poseen el mismo titulo
     * sin importar si estos estan en minuscula o mayuscula
     */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean bool = false;
		if(obj instanceof Video) {
			if(this.titulo.equalsIgnoreCase(((Video)obj).titulo)) {
			  bool = true;
			}
		}	
		return bool;
	}
}
