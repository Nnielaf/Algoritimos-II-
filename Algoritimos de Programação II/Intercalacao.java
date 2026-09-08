
import java.util.Arrays;

public class ExemploIntercalacao {
    public static void main(String[] args) {
        int[] a = {2,4,7,9,11,16,18};
        int[] b = {3,10,12,22,34};

        intercalar(a, b);
    }

    public static void intercalar(int[]a , int[] b){
        
        int[] c = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while( i < a.length && j < b.length){
            if(a[i] < b[j]){
                c[k] = a[i];
                k++;
                i++;
            }

            else{
                c[k] = b[j];
                k++;
                j++;
            }
        }

        while(i < a.length){
            c[k] = a[i];
            i++;
            j++;
        }

        while( j < b.length){
            c[k] = b[j];
            k++;
            j++;
        }

        System.out.println(Arrays.toString(c));
}}
