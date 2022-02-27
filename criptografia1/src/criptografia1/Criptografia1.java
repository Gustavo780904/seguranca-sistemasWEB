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

		//converte a mensagem (string) em caracteres
		char[] caracteres = mensagem.toCharArray();

		int tamanhoMsg = mensagem.length();
		int diferenca = tamanhoMsg % 5;
		if (diferenca != 0 || diferenca != 5) {
			tamanhoMsg =+ tamanhoMsg - diferenca;
		}
			
		for (int i = 0; i < tamanhoMsg; i++) {

			for (int j = 0; j < 5; j++) {
				caracteres[i] += senha[j];
				i++;
			}
			i++;
		}


		System.out.println(caracteres);

		s.close();
	}

}
