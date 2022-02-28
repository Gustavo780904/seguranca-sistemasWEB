package criptografia1;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class Criptografia1 {

	static char[] senha = { 10, 8, 4, 11, 2 };

	public static Map<Character, Integer> alfabeto() {
		Map<Character, Integer> alfabeto = new HashMap<>();
		alfabeto.put(' ', 0);
		for (int i = 0; i < 26; i++) {

			char a = (char) ((char) i + 97);
			alfabeto.put(a, i + 1);
		}
		alfabeto.put('ç', 27);

		return alfabeto;
	}

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner s = new Scanner(System.in);
		
		
		//String mensagem = s.nextLine();
		String mensagem = "que a força esteja com voce";
		
		// tamanho da mensagem
		int tamanho = mensagem.length();
		// calcular o resto da divisão por 5
		int resto = tamanho % 5;
		// se não for exato, calcula quanto somar para adicionar 0
		int somar = 0;
		if (resto != 0) {
			somar = 5 - resto;
		}
		Map<Character, Integer> alfabeto = alfabeto();

		int charTamanho = tamanho + somar;
		char[] msgConvertida = new char[charTamanho];

		mensagem.getChars(0, mensagem.length(), msgConvertida, 0);
		

		for (int i = mensagem.length(); i < charTamanho; i++) {
			msgConvertida[i] = 48;
		}

		for (int i = 0; i < msgConvertida.length; i++) {
			var index = alfabeto.get(msgConvertida[i]);
			msgConvertida[i] += senha[i % 5];
		}

		System.out.println(resto);
		System.out.println(somar);
		System.out.println(msgConvertida);
		System.out.println(msgConvertida.length);
		System.out.println(alfabeto());
		System.out.println(charTamanho);
		System.out.println(msgConvertida[14]);

		s.close();
	}

}
