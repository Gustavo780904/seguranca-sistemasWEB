package criptografia1;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Criptografia1 {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner s = new Scanner(System.in);
		
		char[] senha = {10, 8, 4, 11, 2};

		String mensagem = s.nextLine();
		
		char[] caracteres = mensagem.toCharArray();

		
		ArrayList<String> alfabeto = new ArrayList<String>();
		
		alfabeto.add(" ");
		for (int i = 65; i < 90; i++) {
			char a = (char) i;
			alfabeto.add(String.valueOf(a));
		}
		for (int i = 97; i < 123; i++) {
			char a = (char) i;
			alfabeto.add(String.valueOf(a));
		}
		
		for (int i=0; i<mensagem.length();i++) {
			for (int j=0; j<5; j++) {
				caracteres[i]+=senha[j];
				i++;
			}
		}
				

		System.out.println(mensagem);
		System.out.println(caracteres);
		System.out.println(alfabeto);

		s.close();
	}

}
