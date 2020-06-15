
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
public class PL5_Exercicio_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner tec = new Scanner (System.in);
        
        int x,y,raio,xCentro,yCentro,a=0,distancia;
        
        System.out.println("Insira as coordenadas do centro do círculo:");
        System.out.print("x=");
        xCentro= tec.nextInt();
        System.out.print("y=");
        yCentro = tec.nextInt();
        System.out.println("Insira o raio do círculo:");
        raio = tec.nextInt();
        
        if (raio>0){
            System.out.println("Insira as coordenadas de um ponto:");
            System.out.print("x=");
            x= tec.nextInt();
            System.out.print("y=");
            y= tec.nextInt();
            while (x!=xCentro || y!=yCentro){
                if (Math.pow(x-xCentro,2) + Math.pow(y-yCentro,2) <= Math.pow(raio,2)){
                    a++;
                    System.out.println("O ponto está dentro do circulo!");
                }else{
                    System.out.println("O ponto não está dentro do círculo!");
                }
                System.out.println("Insira as coordenadas de outro ponto:");
                System.out.print("x=");
                x= tec.nextInt();
                System.out.print("y=");
                y= tec.nextInt();
            }
            System.out.println("Dos pontos que inseriu "+  a  +" percentem ao círculo!");
            
        }
}}   

    
    
        
   