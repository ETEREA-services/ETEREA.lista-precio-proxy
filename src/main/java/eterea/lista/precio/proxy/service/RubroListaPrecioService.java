package eterea.lista.precio.proxy.service;

import eterea.lista.precio.proxy.client.core.RubroListaPrecioClient;
import eterea.lista.precio.proxy.domain.dto.RubroListaPrecioDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RubroListaPrecioService {

    private final RubroListaPrecioClient client;

    public List<RubroListaPrecioDto> findAll() {
        return client.findAll();
    }

    public RubroListaPrecioDto findByRubroId(Long rubroId) {
        return client.findByRubroId(rubroId);
    }

    public RubroListaPrecioDto addOrUpdate(RubroListaPrecioDto rubroListaPrecio) {
        return client.addOrUpdate(rubroListaPrecio);
    }

}
