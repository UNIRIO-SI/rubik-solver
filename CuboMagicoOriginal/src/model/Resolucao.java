package model;

import java.util.List;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;


@DatabaseTable(tableName="Resolucoes")
public class Resolucao {
	
	@DatabaseField(generatedId = true)
	private int id;
	
	@DatabaseField(columnName = "passos")
	private String passos;

	public Resolucao(){
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassos() {
		return passos;
	}

	public void setPassos(String passos) {
		this.passos = passos;
	}
	
	public void setPassos(List<String> rotacoes){
		
		StringBuilder builder = new StringBuilder();		
		
		for(String rotacao: rotacoes){
			builder.append(rotacao);
			builder.append(" ");
		}
		
		passos = builder.toString().trim();
		
	}

}
