package eterea.lista.precio.proxy.client.core;

import eterea.lista.precio.proxy.domain.dto.ArticuloListaPrecioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;

@FeignClient(name = "core-service", contextId = "articuloListaPrecioClient", path = "/api/core/articuloListaPrecio")
public interface ArticuloListaPrecioClient {

    @GetMapping("/page")
    Page<ArticuloListaPrecioDto> findAllPublicadosPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size);

    @GetMapping("/{articuloId}")
    ArticuloListaPrecioDto findByArticuloId(@PathVariable String articuloId);

    @GetMapping("/rubro/{rubroId}/page")
    Page<ArticuloListaPrecioDto> findAllByRubroIdPaginated(
            @PathVariable Integer rubroId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size);


}
