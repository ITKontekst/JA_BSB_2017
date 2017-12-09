/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.itkontekst.javaadvanced.program1;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Wojciech Oczkowski
 */
public class ClientManager {

    private final static Map<String, Client> clientsCache = new HashMap<>();

    public Client findClientByName( String name) {
        synchronized (clientsCache) {
            Client client = clientsCache.get(name);
            if (client == null) {
                client = new Client(null, name, String.valueOf(new Random().nextInt()), "123456789");
                clientsCache.put(name, client);
            }
            return client;
        }
    }

}
