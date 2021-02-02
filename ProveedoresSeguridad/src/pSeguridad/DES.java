//SIMETRICA CON DO FINAL
package pSeguridad;

import java.security.*;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DES {
	private static String ENCRYPT_KEY = "clave-co";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String encriptado = encript("Pues vamos a hacer una prueba");
			System.out.println("encriptado " + encriptado);

			String desencriptado = decrypt(encriptado);
			System.out.println("desencriptado " + desencriptado);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String encript(String text) throws Exception {
		Key desKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "DES");

		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, desKey);

		byte[] encrypted = cipher.doFinal(text.getBytes());

		// return Base64.getEncoder().encode(encrypted);
		return Base64.getEncoder().encodeToString(encrypted);
	}

	private static String decrypt(String encrypted) throws Exception {

		byte[] encryptedBytes = Base64.getDecoder().decode(encrypted.replace("\n", ""));

		Key desKey = new SecretKeySpec(ENCRYPT_KEY.getBytes(), "DES");

		Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, desKey);

		String decrypted = new String(cipher.doFinal(encryptedBytes));

		return decrypted;
	}

}
