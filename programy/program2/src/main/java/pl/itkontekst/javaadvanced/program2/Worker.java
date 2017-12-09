/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.itkontekst.javaadvanced.program2;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wojciech Oczkowski
 */
public class Worker extends Thread {

    private int seconds;
    private ClientManager clientManager;

    public Worker(String name, int seconds, ClientManager clientManager) {
        super(name);
        this.seconds = seconds;
        this.clientManager = clientManager;
    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();
        Random random = new Random();
        while (System.currentTimeMillis() - start < seconds * 1000) {
            clientManager.findClientByName("name" + random.nextInt());
            sleepFor(5);
        }
        System.out.println(getName() + " zakonczono");
    }

    private void sleepFor(long milis) {
        try {
            sleep(milis);
        } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
        }
    }

}
