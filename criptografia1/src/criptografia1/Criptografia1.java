package criptografia1;

import java.util.Locale;
import java.util.Scanner;

public class Criptografia1 {

	static char[] senha = { 10, 8, 4, 11, 2 };

	public static char[] alfabeto() {

		char[] alfabeto = new char[28];
		alfabeto[0] = ' ';
		for (int i = 0; i < 26; i++) {
			alfabeto[i + 1] = (char) (i + 97);
		}
		alfabeto[27] = 'ç';

		return alfabeto;
	}

	private static int findIndex(char alfabeto[], char elemento) {
		int tamanho = alfabeto.length;
		for (int i = 0; i < tamanho; i++) {
			if (alfabeto[i] == elemento) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner s = new Scanner(System.in);

		 String mensagem = s.nextLine();
//		String mensagem = "que a força esteja com voce";

		// tamanho da mensagem
		int tamanho = mensagem.length();
		// calcular o resto da divisão por 5
		int resto = tamanho % 5;
		// se não for exato, calcula quanto somar para adicionar 0
		int somar = 0;
		if (resto != 0) {
			somar = 5 - resto;
		}
		char[] alfabeto = alfabeto();

		int charTamanho = tamanho + somar;
		char[] msgConvertida = new char[charTamanho];

		mensagem.getChars(0, mensagem.length(), msgConvertida, 0);

		for (int i = mensagem.length(); i < charTamanho; i++) {
			msgConvertida[i] = 48;
		}

		for (int i = 0; i < msgConvertida.length; i++) {
			int index = findIndex(alfabeto, msgConvertida[i]) + senha[i % 5];
			//soma a partir da primeira posição quando exceder as posições do alfabeto
			index = index % 28;
			msgConvertida[i] = alfabeto[index];
		}

		System.out.println(msgConvertida);

		s.close();
	}

}
