package jogo.adivinhação;

import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhação {

    public static void main(String[] args) {
        Random gerador = new Random();
        int numero_secreto = gerador.nextInt(100)+1;
        int total_tentativas = 0;
        int i = 1;
        int pontos = 1000;
        
        System.out.println("*-------------------------------*");
        System.out.println("Bem vindo ao jogo da adivinhação");
        System.out.println("*-------------------------------*");
        System.out.println("Escolha o nivel da dificuldade\n[1]Fácil\n[2]Normal\n[3]Difícil");
        Scanner sc1 = new Scanner(System.in);
        int escolha = Integer.parseInt(sc1.next());
        
        switch(escolha){
            case 1:
                total_tentativas = 20;
                break;
            case 2:
                total_tentativas = 10;
                break;
            case 3: 
                total_tentativas = 5;
                break;
        }
        
        while(i <= total_tentativas){
            System.out.println("Tentativa "+i+" De "+ total_tentativas);
            Scanner sc2 = new Scanner(System.in);
            System.out.println("Dê o seu chute");
            int chute = Integer.parseInt(sc2.next());
            
            if(chute < 1){
                System.out.println("Chute algo acima de 1 ou abaixo de 100"); 
                continue;} 
            else if(chute > 100){
                System.out.println("Chute algo acima de 1 ou abaixo de 100"); 
                continue;}
            
            if(chute == numero_secreto){
                System.out.println("Você acertou o número!");
                System.out.println("Sua pontuação foi: "+ pontos);
                break;
            }
            if(chute < numero_secreto){                
                System.out.println("O número secreto é maior");
                int pontos_perdidos = Math.abs(numero_secreto - chute);
                pontos = pontos - pontos_perdidos;
                i++;
            }
            if (chute > numero_secreto){
                System  .out.println("O número secreto é menor");
                int pontos_perdidos = Math.abs(numero_secreto - chute);
                pontos = pontos - pontos_perdidos;
                i++;
            }
            
        }
        System.out.println("Fim de Jogo.");
    }
    
}
