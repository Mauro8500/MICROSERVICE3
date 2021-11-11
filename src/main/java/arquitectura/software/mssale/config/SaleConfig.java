package arquitectura.software.mssale.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class SaleConfig{
    @Value("${aquitectura.software}")
    private String arquitecturaSoftware;

    public String showConfiguration(){
        return String.format("Los datos yml:  arquitecturaSoftware: %s", arquitecturaSoftware);
    }

    
}
