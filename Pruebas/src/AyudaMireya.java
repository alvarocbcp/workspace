
public class AyudaMireya {

	public static void main(String[] args) {
		
		int contadorSuma = 0;
		int array[] = {23, 1, 34, 10, 3, 5};
		
		for(int i = 0; i<array.length; i++) {
			if(array[i]>10) {
				contadorSuma = contadorSuma + array[i];
			}
		}
		
		System.out.println("Suma total: " + contadorSuma);

	}

}
