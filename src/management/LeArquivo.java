package management;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Tabela;

public class LeArquivo {
	public String path;

	public void le_Nasm(List<String> list, String path) {
		// path = "trabalho_portao_final.asm";
		// String ilc = "0xcaf";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine(); // le primeira linha

			// pula para o _start
			while (!line.equals("_start:")) {
				line = br.readLine();
			}

			while (line != null) {
				if (line.charAt(0) == ';') { // ignora linha de comentarios
					line = br.readLine();
					continue;
				} else {

					list.add(line);
					line = br.readLine(); // le proxima linha
				}

			}
		} catch (

		IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

	public void le_Arquivo(List<Tabela> list, String path) {
		// path = "in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine(); // le primeira linha
			while (line != null) {
				// System.out.println(line);
				String[] sep = line.split(" / ");

				String opcode = sep[0];
				if (!line.equals("null")) {
					int tamanho = Integer.parseInt(sep[1]);
					String hexa = sep[2];
					list.add(new Tabela(opcode, tamanho, hexa));
				} else {
					list.add(new Tabela(opcode));
				}
				// Integer.parseInt(sep[2], 1);

				line = br.readLine(); // le proxima linha

			}
			/*for (Tabela tab : list) {
				System.out.println(tab.getHexa());
			}*/

			/*
			 * for (Tabela t : list) { System.out.println(t.getOpcode());
			 * System.out.println(t.getTamanho()); System.out.println(t.getHexa()); }
			 */

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

		}
	}

	public void le_Arquivo2(List<String> list, String path) {
		// path = "in.txt";

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine(); // le primeira linha
			while (line != null) {
				// System.out.println(line);
				list.add(line);
				// Integer.parseInt(sep[2], 1);
				line = br.readLine(); // le proxima linha

			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

		}
	}
	
	public void monta_Arquivo_Objeto(List<String> list) {
		list.clear();

		try (BufferedReader br = new BufferedReader(new FileReader("header.txt"))) {

			String line = br.readLine(); // le primeira linha
			while (line != null) {
				// System.out.println(line);
				list.add(line);
				// Integer.parseInt(sep[2], 1);
				line = br.readLine(); // le proxima linha

			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

		}
		
		try (BufferedReader br = new BufferedReader(new FileReader("codigo_hexa.txt"))) {

			String line = br.readLine(); // le primeira linha
			while (line != null) {
				// System.out.println(line);
				list.add(line);
				// Integer.parseInt(sep[2], 1);
				line = br.readLine(); // le proxima linha

			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

		}
		
		try (BufferedReader br = new BufferedReader(new FileReader("footer.txt"))) {

			String line = br.readLine(); // le primeira linha
			while (line != null) {
				// System.out.println(line);
				list.add(line);
				// Integer.parseInt(sep[2], 1);
				line = br.readLine(); // le proxima linha

			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());

		}
	}

}
