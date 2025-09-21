package eterea.lista.precio.proxy.configuration;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "eterea.lista.precio.proxy.client")
public class ListaPrecioConfig {

}
