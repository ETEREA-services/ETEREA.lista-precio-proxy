package eterea.lista.precio.proxy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RubroDto {

    private Long rubroId;
    private Integer negocioId;
    private String descripcion;
    private Integer unidadNegocio;
    private Byte restaurant;
    private Long proveedorId;

}
