package arquitectura.software.mssale.Api;

import arquitectura.software.mssale.config.SaleConfig;
import arquitectura.software.mssale.entity.Sale;
import arquitectura.software.mssale.repository.SaleRepository;
import arquitectura.software.mssale.service.AccountService;
import feign.Logger;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
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

    private static Logger LOGGER = LoggerFactory.logger(SaleController.class);

    @Autowired
    private SaleRepository saleRepository;
    @Autowired
    private SaleConfig saleConfig;
    @Autowired
    private AccountService accountService;
    
    @RequestMapping(path = "/test",
                    method = RequestMethod.GET)
    public String testAccount(){
        LOGGER.info("Probando endpoint ms-saler");
        String result = accountService.testAccount();
        LOGGER.info("Probando endpoint ms-sale", result);
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
