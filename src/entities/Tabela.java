package entities;

public class Tabela {
	private String opcode;
	private int tamanho;
	private String hexa;
	
	
	public Tabela() {
		
	}


	public Tabela(String opcode, int tamanho, String hexa) {
		super();
		this.opcode = opcode;
		this.tamanho = tamanho;
		this.hexa = hexa;
	}
	
	


	public Tabela(String opcode) {
		super();
		this.opcode = opcode;
	}


	public String getOpcode() {
		return opcode;
	}


	public void setOpcode(String opcode) {
		this.opcode = opcode;
	}

	public int getTamanho() {
		return tamanho;
	}


	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}


	public String getHexa() {
		return hexa;
	}


	public void setHexa(String hexa) {
		this.hexa = hexa;
	}


	
	
	
	
	
	
}
