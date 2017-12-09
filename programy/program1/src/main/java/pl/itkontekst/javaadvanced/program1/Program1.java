/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.itkontekst.javaadvanced.program1;

/**
 *
 * @author Wojciech Oczkowski
 */
public class Program1 {

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if( args.length != 2){
            System.out.println("parametry: a - czas wykonania w sekundach, b - ilosc wątków");
        }
        int seconds = Integer.valueOf(args[0]);
        int threads = Integer.valueOf(args[1]);
        ClientManager clientManager = new ClientManager();
        
        System.out.println("Startuję na " + threads + " wątkach z czasem "+ seconds + " sekund " );
        for (int i = 0; i < threads; i++) {
            Worker worker = new Worker("Zadanie" + i, seconds, clientManager);
            worker.start();
        }
        
    }
    
}
