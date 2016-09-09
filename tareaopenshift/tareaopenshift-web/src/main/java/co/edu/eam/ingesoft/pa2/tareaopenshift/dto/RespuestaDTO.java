package co.edu.eam.ingesoft.pa2.tareaopenshift.dto;

public class RespuestaDTO {

	
	private Object obj;
	
	private String msj;
	
	private String codigo;
	
	public RespuestaDTO(){
		
	}
	
	public RespuestaDTO(Object obj){
		super();
		this.obj=obj;
		this.msj="Se ejeutó correctamente";
		this.codigo="00";
	}

	public RespuestaDTO(Object obj, String msj, String codigo) {
		super();
		this.obj = obj;
		this.msj = msj;
		this.codigo = codigo;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}

	public String getMsj() {
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	
	
	
}
