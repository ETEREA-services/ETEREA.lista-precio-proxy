package eterea.lista.precio.proxy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloListaPrecioDto {

    private UUID articuloListaPrecioId;
    private String articuloId;
    private Byte publicar;
    private ArticuloDto articulo;

}
