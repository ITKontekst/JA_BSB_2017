package pl.itkontekst.jpa_perf;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.SequenceGenerator;

@Entity
class Client {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "CLIENT_IDX_SEQ")
//    @SequenceGenerator(allocationSize = 1,name = "CLIENT_IDX_SEQ",sequenceName = "CLIENT_IDX_SEQ")
    @SequenceGenerator(allocationSize = 20,name = "CLIENT_IDX_SEQ",sequenceName = "CLIENT_IDX_SEQ")
    private Long id;
    
    private String name;

    public Client() {
    }
    
    public Client(String name) {
        this.name = name;
    }

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
}
