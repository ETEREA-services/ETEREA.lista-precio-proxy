package eterea.lista.precio.proxy.service;

import eterea.lista.precio.proxy.client.core.ArticuloListaPrecioClient;
import eterea.lista.precio.proxy.domain.dto.ArticuloListaPrecioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticuloListaPrecioService {

    private final ArticuloListaPrecioClient client;

    public ArticuloListaPrecioDto findByArticuloId(String articuloId) {
        return client.findByArticuloId(articuloId);
    }

    public Page<ArticuloListaPrecioDto> findAllPublicadosPaginated(int page, int size) {
        return client.findAllPublicadosPaginated(page, size);
    }

    public Page<ArticuloListaPrecioDto> findAllByRubroIdPaginated(Integer rubroId, int page, int size) {
        return client.findAllByRubroIdPaginated(rubroId, page, size);
    }
}
