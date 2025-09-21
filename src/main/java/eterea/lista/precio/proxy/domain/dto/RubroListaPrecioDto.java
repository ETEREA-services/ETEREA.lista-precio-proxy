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
public class RubroListaPrecioDto {

    private UUID rubroListaPrecioId;
    private Long rubroId;
    private String etiqueta;
    private Byte publicar;
    private RubroDto rubro;

}
