package arquitectura.software.mssale.Api;

import arquitectura.software.mssale.config.SaleConfig;
import arquitectura.software.mssale.entity.Sale;
import arquitectura.software.mssale.repository.SaleRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/sale")

public class SaleController{

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private SaleConfig saleConfig;
    
    @RequestMapping(path = "/test",
                    method = RequestMethod.GET)
    public String testAccount(){
        return "Ms-sale";
    }

    @RequestMapping(path = "/save",
                     method = RequestMethod.POST)
    public Sale saveSale(@RequestBody Sale sale){
        System.out.println("Registrando al cliente -->: " + saleConfig.showConfiguration());
       return saleRepository.save(sale);
    }

    @RequestMapping(path = "/all",
                    method = RequestMethod.GET)
    public List<Sale> getAllSale(){
        List<Sale> sale = saleRepository.findAll();
        return sale;
    }

    @RequestMapping(
                    method = RequestMethod.GET)
    public Sale getSale(@RequestParam Integer saleId) throws Exception{
        Optional<Sale> saleOptional = saleRepository.findById(saleId);
        if(saleOptional.isPresent()){
            Sale sale = saleOptional.get();
            return sale;
        }else{
            throw new Exception("No se encuentra la venta");
        } 
    }

}
