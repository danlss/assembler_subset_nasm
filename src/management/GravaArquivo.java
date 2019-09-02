package management;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class GravaArquivo {
	
	
	
	public void grava_Arquivo(List<String> list, String path) {
		//String path = "out.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){ // FileWriter(path, true) = não recria e continua a escrita
			//for cada linha do vetor de linhas
			for (String s : list) {
				//bw.write(t.getOpcode() + " | "  + t.getTamanho() + " | " + t.getHexa());
				bw.write(s);
				bw.newLine(); // quebra de linha
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void grava_Arquivo_Obj(List<String> list, String path) {
		//String path = "out.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){ // FileWriter(path, true) = não recria e continua a escrita
			//for cada linha do vetor de linhas
			for (String s : list) {
				//bw.write(t.getOpcode() + " | "  + t.getTamanho() + " | " + t.getHexa());
				bw.write(s);
				bw.newLine(); // quebra de linha
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void grava_Arquivo_Obj2(List<String> list, String path) {
		//String path = "out.txt";
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){ // FileWriter(path, true) = não recria e continua a escrita
			//for cada linha do vetor de linhas
			for (String s : list) {
				//bw.write(t.getOpcode() + " | "  + t.getTamanho() + " | " + t.getHexa());
				bw.write(s);
				bw.newLine(); // quebra de linha
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
