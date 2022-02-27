package criptografia1;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Criptografia1 {

	static char[] senha = { 10, 8, 4, 11, 2 };

	// alfabeto
	public static ArrayList<String> alfabeto() {
		ArrayList<String> alfabeto = new ArrayList<String>();

		alfabeto.add(" ");
		for (int i = 65; i < 91; i++) {

			char a = (char) i;
			alfabeto.add(String.valueOf(a));
		}
		for (int i = 97; i < 123; i++) {

			char a = (char) i;
			alfabeto.add(String.valueOf(a));
		}

		return alfabeto;

	}

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner s = new Scanner(System.in);

		String mensagem = s.nextLine();

		//tamanho da mensagem
		int tamanho = mensagem.length();
		//calcular o resto da divisão por 5
		int resto = tamanho%5;
		//se não for exato, calcula quanto somar para adicionar 0
		int somar = 0;
		if (resto !=0) {
			somar = 5 - resto;			
		}
		
		int charTamanho = tamanho + somar;
		char [] msgConvertida =  new char [ charTamanho ];
		msgConvertida = mensagem.toCharArray();
		
		for (int i= tamanho+somar; i< charTamanho; i++) {
			msgConvertida[i]=0;
		}
		
		for (int i = 0; i < msgConvertida.length; i++) {

			for (int j = 0; j < 5; j++) {
				msgConvertida[i] += senha[j];
			i++;
			}
			i++;
		}
		
		
		System.out.println(resto);
		System.out.println(somar);
		System.out.println(msgConvertida);
		System.out.println(msgConvertida.length);
		System.out.println(charTamanho);
//		System.out.println(msgConvertida[15]);

		s.close();
	}

}
