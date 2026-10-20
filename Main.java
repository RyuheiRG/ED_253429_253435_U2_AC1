package ED_253429_253414_U2_AC1;

class ListaRandom {

    private int[] numeros;

    public ListaRandom() {
        numeros = new int[20];
        generarNumerosAleatorios();
    }

    private void generarNumerosAleatorios() {
        for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * 50 + 1);
        }
    }

    public int[] getNumeros() {
        return numeros;
    }

    public void mostrarNumeros() {
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }
}

class Busqueda {

    public static String buscarNumero(int[] arreglo, int numero) {
        int posicion = buscarBinario(arreglo, numero, 0, arreglo.length - 1);
        if (posicion == -1) {
            return "Número no encontrado en el arreglo.";
        }

        String lado = posicion < arreglo.length / 2
                ? "lado izquierdo (primera mitad)"
                : "lado derecho (segunda mitad)";
        return "Número encontrado en la posición " + (posicion + 1) + ", en el " + lado + ".";
    }

    private static int buscarBinario(int[] arreglo, int numero, int izquierda, int derecha) {
        if (izquierda > derecha) {
            return -1;
        }

        int medio = izquierda + (derecha - izquierda) / 2;
        if (arreglo[medio] == numero) {
            return medio;
        }
        if (numero < arreglo[medio]) {
            return buscarBinario(arreglo, numero, izquierda, medio - 1);
        }
        return buscarBinario(arreglo, numero, medio + 1, derecha);
    }
}

class Ordenamiento {

    public static void quickSort(int[] arreglo, int izquierda, int derecha) {
        if (izquierda >= derecha) {
            return;
        }

        int indicePivote = particionar(arreglo, izquierda, derecha);
        quickSort(arreglo, izquierda, indicePivote - 1);
        quickSort(arreglo, indicePivote + 1, derecha);
    }

    private static int particionar(int[] arreglo, int izquierda, int derecha) {
        int pivote = arreglo[derecha];
        int indiceMenores = izquierda;

        for (int i = izquierda; i < derecha; i++) {
            if (arreglo[i] <= pivote) {
                intercambiar(arreglo, i, indiceMenores);
                indiceMenores++;
            }
        }

        intercambiar(arreglo, indiceMenores, derecha);
        return indiceMenores;
    }

    private static void intercambiar(int[] arreglo, int primero, int segundo) {
        int temporal = arreglo[primero];
        arreglo[primero] = arreglo[segundo];
        arreglo[segundo] = temporal;
    }
}

public class Main {
    public static void main(String[] args) {
        ListaRandom listaRandom = new ListaRandom();
        System.out.println("Números generados:");
        listaRandom.mostrarNumeros();

        int[] numeros = listaRandom.getNumeros();
        Ordenamiento.quickSort(numeros, 0, numeros.length - 1);
        System.out.println("Números ordenados:");
        listaRandom.mostrarNumeros();

        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            System.out.print("Ingresa el número entero que deseas buscar: ");
            while (!scanner.hasNextInt()) {
                if (!scanner.hasNext()) {
                    System.out.println("\nNo se recibió un número para buscar.");
                    return;
                }
                System.out.print("Entrada no válida. Ingresa un número entero: ");
                scanner.next();
            }

            int numeroBuscado = scanner.nextInt();
            System.out.println(Busqueda.buscarNumero(numeros, numeroBuscado));
        }
    }
}
