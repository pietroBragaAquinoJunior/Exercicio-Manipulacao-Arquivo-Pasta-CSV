package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/* Programa em java para leitura, escrita, manipulação de arquivos csv */
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Digite o caminho do arquivo CSV a ser lido: ");
		String strPath = sc.nextLine();
		
		String parentOfStrPath = new File(strPath).getParentFile().getPath();
		
		boolean sucesso = new File(parentOfStrPath + "\\out").mkdir();
		System.out.println("Pasta out criada com sucesso." + sucesso);
		
		try(BufferedReader bf = new BufferedReader(new FileReader(strPath))){
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(parentOfStrPath+"\\out\\summary.csv"))){
				String linha = bf.readLine();
				while(linha != null) {
					String [] informacoes = linha.split(",");
					bw.write(informacoes[0]+","+informacoes[1]);
					bw.newLine();
					linha = bf.readLine();
				}
			}
			catch(IOException e) {
				e.printStackTrace();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		sc.close();

	}

}
