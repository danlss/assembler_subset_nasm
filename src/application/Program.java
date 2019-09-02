package application;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import entities.Tabela;
import management.GravaArquivo;
import management.LeArquivo;

public class Program {
	public static int tam = 0;

	public static void main(String[] args) {
		/*
		 * OBS: alguns trechos comentados de codigo foram utilizados para exaustivos testes.
		 */
		
		List<Tabela> listTabel = new ArrayList<Tabela>();
		List<String> listNasm = new ArrayList<String>();
		List<String> list_Ilc = new ArrayList<String>();
		List<String> list_Head = new ArrayList<String>();
		List<String> list_Foot = new ArrayList<String>();
		List<Integer> ListTams = new ArrayList<Integer>();
		List<String> objs = new ArrayList<String>();
		List<String> hexas = new ArrayList<String>();
		List<String> last = new ArrayList<String>();

		String pathh = "in.txt"; //Entrada do arquivo tabela contendo os simbolos obtidos através do EDB
		String path = "trabalho_portao_final.asm"; //codigo assembly do projeto sem espaços ou tabulaçoes
		String path2 = "out.txt"; // Arquivo gerado contendo as label substituidas pelos ILCS (primeira passagem)
		String path3 = "trabalho_portao_final.txt"; //codigo final gerado a partir do _start até o final do codigo

		LeArquivo la = new LeArquivo();
		GravaArquivo ga = new GravaArquivo();
		// Integer tam = 0;

		la.le_Nasm(listNasm, path); // le codigo nasm
		la.le_Arquivo(listTabel, pathh); // le tabela de simbolos

		for (Tabela num : listTabel) {
			ListTams.add(num.getTamanho()); //Lista alocada do tamanho de cada instrução obtida pelo EDB
		}

		ILC(listNasm, list_Ilc, ListTams); //calculo e substituição dos ILCS
		ga.grava_Arquivo(list_Ilc, path2); //grava arquivo ILC

		geraObj(listTabel, list_Ilc, hexas); //lista auxiliar para formatação dos hexadecimais

		//String resultado = separaHexa(list_Ilc, objs);
		hex_Code(list_Ilc, objs);
		
		/*for(String obj : list_Ilc) {
			System.out.println(obj);
		}*/
		
		ga.grava_Arquivo(list_Ilc, "codigo_hexa.txt"); //gravação de arquivo contendo cada hexa gerado a partir de implementações, formatado segundo o hexdump e arquivo objeto.
		//System.out.println("codigo: "+resultado);
		//System.out.println();
		//System.out.println();

		ga.grava_Arquivo_Obj(list_Ilc, path3);
		la.le_Arquivo2(list_Head, "header.txt"); //arquivo cabeçalho com os hexas. Foi obtido atraves do EDB

		String results = separaHexa2(list_Head, objs);
		//System.out.println("header: "+results);
		
		la.le_Arquivo2(list_Foot, "footer.txt"); //arquivo de rodapé com os hexas. Foi obtido atraves do EDB
		String footer = separaHexa3(list_Foot, objs);
		//System.out.println("footer: "+footer);
		
		la.monta_Arquivo_Objeto(last);
		ga.grava_Arquivo_Obj2(last, "codigo_obj.txt"); 
		//gravação do codigo final obj
		
		
		
		/*String ultima = ""; 
		ultima += results + resultado + footer;;
		System.out.println("final: "+ ultima);*/
		
	}

	public static void ILC(List<String> list1, List<String> list2, List<Integer> tams) {
		tam = 0;
		int count = 0;
		int aux = 0;

		for (String s : list1) {
			int aux2;
			if (s.equals("_start:") || s.equals("fechado:") || s.equals("fechando:") || s.equals("aberto:")
					|| s.equals("abrindo:") || s.equals("mst_saida:") || s.equals("exit:")) {
				continue;
			}
			if (s.charAt(0) == 'c' || s.charAt(0) == 'j') {
				String[] sep = s.split(" ");
				String opcode = sep[0];
				String label = sep[1];

				if (opcode.equals("je") || opcode.equals("jmp") || opcode.equals("call")) {

					if (label.equals("fechado") || label.equals("fechando") || label.equals("aberto")
							|| label.equals("abrindo") || label.equals("mst_saida") || label.equals("exit")) {

						// int tama = tam;
						aux2 = aux;
						// tam = tam - 5;
						String ilc = Integer.toHexString(tam); // transforma em hexa
						// String aux = ilc;
						s = opcode + " 0x" + ilc;
						// tam = tam - 5;

					}
				}
			}
			// int temp = tams.size();
			// System.out.println(temp);

			if (!tams.get(count).equals("null")) {

				tam += tams.get(count);
				count++;
				aux = tam;
			}
			// int tamanho = tam;

			list2.add(s);

			int size = list2.size();
			/*
			 * if (list2.size() == 134) { return; }
			 */
		}

	}

	public static void geraObj(List<Tabela> tabelas, List<String> list, List<String> hexas) {

		// int c = 1;
		// String linha = "";
		list.clear();
		for (Tabela tab : tabelas) {
			// String temp = tab.getHexa();
			// int tamString = temp.length()
			// formar grupos de 4
			if (tab.getHexa() != null) {
				String[] sep = tab.getHexa().split(" ");
				switch (tab.getHexa().length()) {
				case 2:
					list.add(sep[0]);
					break;
				case 5:

					list.add(sep[0]);
					list.add(sep[1]);
					break;
				case 8:

					list.add(sep[0]);
					list.add(sep[1]);
					list.add(sep[2]);
					break;
				case 11:
					list.add(sep[0]);
					list.add(sep[1]);
					list.add(sep[2]);
					list.add(sep[3]);
					break;
				case 14:

					list.add(sep[0]);
					list.add(sep[1]);
					list.add(sep[2]);
					list.add(sep[3]);
					list.add(sep[4]);
					break;
				case 17:

					list.add(sep[0]);
					list.add(sep[1]);
					list.add(sep[2]);
					list.add(sep[3]);
					list.add(sep[4]);
					list.add(sep[5]);
					break;
				case 20:

					list.add(sep[0]);
					list.add(sep[1]);
					list.add(sep[2]);
					list.add(sep[3]);
					list.add(sep[4]);
					list.add(sep[5]);
					list.add(sep[6]);
					break;
				}
			}
		}
	}

	public static String separaHexa(List<String> hexas, List<String> objs) {
		String line = "";
		// int count = 0;
		// int aux = 2;
		// objs.clear();

		int c = 0;
		for (int i = 0; i <= 600; i += 2) {

			if (hexas.get(i) == null) {
				line = hexas.get(i);
				objs.add(line);
			}
			line = hexas.get(i) + hexas.get(i + 1);
			objs.add(line);
			//System.out.println("[" + c + "]= " + line);
			if (c == 287) {
				break;
			}

			c++;
		}
		hexas.clear();
		line = "";
		for (int i = 0; i <= 278; i += 8) {
			line += objs.get(i) + objs.get(i + 1) + objs.get(i + 2) + objs.get(i + 3) + objs.get(i + 4)
					+ objs.get(i + 5) + objs.get(i + 6) + objs.get(i + 7);
			// hexas.add(line);
			// System.out.println(line);
		}
		line += "ffffb801000000bb00000000cd800000";
		// hexas.add(line);
		return line;

	}
	
	public static void hex_Code(List<String> hexas, List<String> objs) {
		String line = "";
		// int count = 0;
		// int aux = 2;
		objs.clear();

		int c = 0;
		for (int i = 0; i <= 600; i += 2) {

			if (hexas.get(i) == null) {
				line = hexas.get(i);
				objs.add(line);
			}
			line = hexas.get(i) + hexas.get(i + 1);
			objs.add(line);
			//System.out.println("[" + c + "]= " + line);
			if (c == 287) {
				break;
			}

			c++;
		}
		hexas.clear();
		//line = "";
		for (int i = 0; i <= 286; i += 8) {
			line = objs.get(i) + " " + objs.get(i + 1) +" " + objs.get(i + 2) +" " + objs.get(i + 3) +" " + objs.get(i + 4)
					+" " + objs.get(i + 5) +" " + objs.get(i + 6) +" " + objs.get(i + 7);
			hexas.add(line);
			//System.out.println(line);
		}
		//line = "ffff b801 0000 00bb 0000 0000 cd80 0000";
		//hexas.add(line);
		//return line;

	}

	public static String separaHexa2(List<String> hexas, List<String> objs) {
		String line = "";
		// int count = 0;
		// int aux = 2;
		objs.clear();

		int c = 0;
		for (int i = 0; i <= 408; i++) {

			if (hexas.get(i) == null) {
				line = hexas.get(i);
				objs.add(line);
			}
			line = hexas.get(i);
			objs.add(line);
			//System.out.println("[" + c + "]= " + line);
			/*
			 * if (c == 287) { break; }
			 */

			c++;
		}
		// hexas.clear();
		line = "";
		for(String obj : objs) {
			String[] sep = obj.split(" ");
			line += sep[0] + sep[1] + sep[2] + sep[3] + sep[4] + sep[5] + sep[6] + sep[7];
		}
		

		/*
		 * for(int i = 0; i<=278; i+=8) { line += objs.get(i) + objs.get(i+1)+
		 * objs.get(i+2) + objs.get(i+3) + objs.get(i+4)+ objs.get(i+5)+ objs.get(i+6)+
		 * objs.get(i+7); //hexas.add(line); //System.out.println(line); }
		 */
		// line += "ffffb801000000bb00000000cd800000";
		// hexas.add(line);
		return line;

	}
	
	public static String separaHexa3(List<String> hexas, List<String> objs) {
		String line = "";
		// int count = 0;
		// int aux = 2;
		objs.clear();

		int c = 0;
		for (int i = 0; i <= 120; i++) {

			if (hexas.get(i) == null) {
				line = hexas.get(i);
				objs.add(line);
			}
			
			line = hexas.get(i);
			objs.add(line);
			//System.out.println("[" + c + "]= " + line);
			/*
			 * if (c == 287) { break; }
			 */


			c++;
		}
		// hexas.clear();
		line = "";
		for(String obj : objs) {
			String[] sep = obj.split(" ");
			line += sep[0] + sep[1] + sep[2] + sep[3] + sep[4] + sep[5] + sep[6] + sep[7];
		}
		
		/*
		 * for(int i = 0; i<=278; i+=8) { line += objs.get(i) + objs.get(i+1)+
		 * objs.get(i+2) + objs.get(i+3) + objs.get(i+4)+ objs.get(i+5)+ objs.get(i+6)+
		 * objs.get(i+7); //hexas.add(line); //System.out.println(line); }
		 */
		// line += "ffffb801000000bb00000000cd800000";
		// hexas.add(line);

		return line;

	}

}
