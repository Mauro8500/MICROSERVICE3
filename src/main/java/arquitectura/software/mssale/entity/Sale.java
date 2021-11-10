package arquitectura.software.mssale.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer saleId;
    private String name;

    public Sale(){

    }
    public Sale(Integer saleId, String name){
        this.saleId = saleId;
        this.name = name;
    }

    public Integer getSaleId() {
        return saleId;
    }
    public String getName() {
        return name;
    }
        public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString(){
        return "Sale{"+
        "saleId=" + saleId + 
        "name='" + name + '\'' +    
        '}';
    }

}

