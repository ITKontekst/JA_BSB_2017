/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.itkontekst.javaadvanced.program2;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @author Wojciech Oczkowski
 */
public class ClientManager {


	private final static Map<String, Client> clientsCache = new ConcurrentHashMap<>();

	public Client findClientByName(String name) {

        	Client client = clientsCache.get(name);
        	if (client == null) {
            	client = new Client(null,name,String.valueOf(new Random().nextInt()),"123456789");
            	clientsCache.put(name,client);
        	}
        	return client;
	}


}
