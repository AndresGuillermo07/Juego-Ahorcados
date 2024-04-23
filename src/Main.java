import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String palabra = "smart";
        int intentosMax = palabra.length();
        int intentosHechos = 0;
        boolean adivinado = false;

        //arreglos
        char[] letrasAdivinadas = new char[palabra.length()];
        limpiarPantalla();

        System.out.printf("tienes %d intentos para adivinar la palabra",palabra.length());

            System.out.println();

        for (int i = 0; i < palabra.length(); i++) {
            letrasAdivinadas[i] = '_';

        }
        System.out.println("\n");
        System.out.print("Listo para jugar?: ");
        String respuesta1 = sc.nextLine();

        if (respuesta1.toLowerCase().equals("si")) {
            while( adivinado == false && intentosHechos < intentosMax) {
                System.out.println("Palabra a adivinar: " + String.valueOf(letrasAdivinadas));
                System.out.print("Introduce una letra, por favor: ");
                char letra = Character.toLowerCase(sc.nextLine().charAt(0));

                boolean letraCorrecta = false;

                for (int i = 0; i < palabra.length(); i++) {

                    if(palabra.charAt(i) == letra){
                        letrasAdivinadas[i] = letra;
                        letraCorrecta = true;
                        limpiarPantalla();
                    }
                }
                if(letraCorrecta == false){
                    intentosHechos++;
                    System.out.println("\n");
                    System.out.println("¡Letra incorrecta! Te quedan " + (intentosMax - intentosHechos) + " intentos");
                }
                if(String.valueOf(letrasAdivinadas).equals(palabra)){
                    adivinado = true;
                    System.out.println("Felicidades, haz adivinado el palabra secreta: " + palabra);
                }
            }
            if (!adivinado) {
                System.out.println("¡TE HAS QUEDADO SIN INTENTOS!");
            }
            sc.close();
        }
    }
    public static void limpiarPantalla(){
        for (int j = 0; j < 50 ; j++) {
            System.out.println();
        }
    }
}