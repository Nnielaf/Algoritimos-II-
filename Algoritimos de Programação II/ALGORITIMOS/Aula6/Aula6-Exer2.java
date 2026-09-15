public class Exer2 {

    public static void main(String[] args) {
        String[] nomes = {
                "ana",
                "Bruno",
                "carla",
                "Diego",
                "eduarda",
                "Felipe",
                "gabriela",
                "Henrique",
                "isabela",
                "João"
        };

        mergeSort(nomes, 0, nomes.length - 1);

        System.out.println("Nomes ordenados:");

        for (String nome : nomes) {
            System.out.println(nome);
        }
    }

    public static void mergeSort(
            String[] nomes, int inicio, int fim) {

        if (inicio < fim) {
            int meio = (inicio + fim) / 2;

            mergeSort(nomes, inicio, meio);
            mergeSort(nomes, meio + 1, fim);

            intercalar(nomes, inicio, meio, fim);
        }
    }

    public static void intercalar(
            String[] nomes, int inicio, int meio, int fim) {

        String[] temporario = new String[fim - inicio + 1];

        int esquerda = inicio;
        int direita = meio + 1;
        int posicao = 0;

        while (esquerda <= meio && direita <= fim) {

            if (nomes[esquerda].compareToIgnoreCase(
                    nomes[direita]) <= 0) {

                temporario[posicao] = nomes[esquerda];
                esquerda++;

            } else {
                temporario[posicao] = nomes[direita];
                direita++;
            }

            posicao++;
        }

        while (esquerda <= meio) {
            temporario[posicao] = nomes[esquerda];
            esquerda++;
            posicao++;
        }

        while (direita <= fim) {
            temporario[posicao] = nomes[direita];
            direita++;
            posicao++;
        }

        for (int i = 0; i < temporario.length; i++) {
            nomes[inicio + i] = temporario[i];
        }
    }
}
