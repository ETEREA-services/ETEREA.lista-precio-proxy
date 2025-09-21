package eterea.lista.precio.proxy.client.core;

import eterea.lista.precio.proxy.domain.dto.RubroListaPrecioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "core-service", contextId = "rubroListaPrecioClient", path = "/api/core/rubroListaPrecio")
public interface RubroListaPrecioClient {

    @GetMapping("/")
    List<RubroListaPrecioDto> findAll();

    @GetMapping("/{rubroId}")
    RubroListaPrecioDto findByRubroId(@PathVariable Long rubroId);

    @PostMapping("/")
    RubroListaPrecioDto addOrUpdate(@RequestBody RubroListaPrecioDto rubroListaPrecio);

}
