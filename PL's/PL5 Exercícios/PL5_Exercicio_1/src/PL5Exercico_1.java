
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jordão
 */
public class PL5Exercico_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner tec = new Scanner (System.in);
        
        int digito,andar,n,a,digitoAnterior = 0,b=1;
        
        n= tec.nextInt();
        
        
        
        for (a=0;a<n;a++){
            andar = tec.nextInt();
            digito = digito(andar);
            if (digito!=digitoAnterior){
                b++;
            }
            digitoAnterior = digito;
        }
        System.out.println(b);
    }
        
        
     

        public static int digito (int codigo){
         int digito;
         
         digito= codigo/10;
         
         return digito;
     }
    
}
        
