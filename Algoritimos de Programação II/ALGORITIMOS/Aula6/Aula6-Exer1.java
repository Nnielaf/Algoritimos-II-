import java.util.Random;

public class Main {
    public static void main(String[] args) {
        long[] valores = new long[1000];
        Random rd = new Random();

        for (int i = 0; i < valores.length; i++) {
            valores[i] = rd.nextLong(1000);
        }

        mergeSort(valores,0,valores.length -1);

        System.out.println("Primeiro 20 números ordenados :");

        for (int i = 0; i < 20; i++) {
            System.out.println(valores[i] + i + "++");
        }
    }

    public static void mergeSort(long[] valores, int inicio, int fim){
        if (inicio < fim){
            int meio = (inicio + fim) / 2;

            mergeSort(valores,inicio,meio);
            mergeSort(valores,meio + 1,fim);

            Intercalar(valores,inicio,meio,fim);
        }
    }

    public static void Intercalar(long[] valores,int inicio,int meio, int fim ){
        long[] temporario = new long[fim - inicio + 1];

        int esquerda = inicio;
        int direita = meio + 1;
        int posicao = 0;

        while (esquerda <= meio && direita <= fim){
            if (valores[esquerda] <= valores[direita]){
                temporario[posicao] = valores[esquerda];
                esquerda++;
            }
            else {
                temporario[posicao] = valores[direita];
                direita++;
            }
            posicao++;
        }

        while (esquerda <= meio){
            temporario[posicao] = valores[esquerda];
            esquerda++;
            posicao++;
        }
        while (direita <= fim){
            temporario[posicao] = valores[direita];
            direita++;
            posicao++;
        }

        for (int i = 0; i < temporario.length; i++) {
            valores[inicio + i] = temporario[i];

        }
    }
}

