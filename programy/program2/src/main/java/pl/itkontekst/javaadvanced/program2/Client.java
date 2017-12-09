/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.itkontekst.javaadvanced.program2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Random;

/**
 *
 * @author woczkowski
 */
public class Client {

    private Long id;
    private String name;
    private String pesel;
    private String phone;
    private BigDecimal riskFactor;

    public Client(Long id, String name, String pesel, String phone) {
        this.id = id;
        this.name = name;
        this.pesel = pesel;
        this.phone = phone;
        calculateRisk();
    }

    private void calculateRisk() {
        Random random = new Random();

        int rand = random.nextInt(100);
        BigDecimal riskFactor = new BigDecimal(rand);

        for (long i = 0; i < 20l; i++) {
            riskFactor = riskFactor.pow(2).divide(new BigDecimal(1 + random.nextInt(100)), RoundingMode.HALF_EVEN);

        }
        this.riskFactor = riskFactor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
