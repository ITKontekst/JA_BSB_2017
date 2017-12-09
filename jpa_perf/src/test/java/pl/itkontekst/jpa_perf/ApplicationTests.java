package pl.itkontekst.jpa_perf;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import pl.itkontekst.jpa_perf.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import org.springframework.transaction.annotation.Transactional;
import pl.itkontekst.jpa_perf.ClientRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private ProductOrderRepository orderRepository;

    @PersistenceContext
    private EntityManager em;

    @Test
    @Transactional
    public void saveManyClients() {

        for (int i = 1; i < 100; i++) {
            clientRepository.save(new Client("Client" + i));
            orderRepository.save(new ProductOrder("Order" + i));
            if (i % 20 == 0) {
                em.flush();
            }
//            Client client = oneRepository.findOne(i+1000l);
        }
        em.flush();
    }

}
