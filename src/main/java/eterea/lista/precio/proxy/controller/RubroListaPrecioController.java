package eterea.lista.precio.proxy.controller;

import eterea.lista.precio.proxy.domain.dto.RubroListaPrecioDto;
import eterea.lista.precio.proxy.service.RubroListaPrecioService;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/lista/precio/rubroListaPrecio")
@RequiredArgsConstructor
public class RubroListaPrecioController {

    private final RubroListaPrecioService service;

    @GetMapping("/")
    public ResponseEntity<CollectionModel<EntityModel<RubroListaPrecioDto>>> findAll() {
        List<EntityModel<RubroListaPrecioDto>> rubros = service.findAll().stream()
                .map(rubro -> EntityModel.of(rubro,
                        linkTo(methodOn(RubroListaPrecioController.class).findAll()).withRel("rubros"),
                        linkTo(methodOn(ArticuloListaPrecioController.class)
                                .findAllPublicadosPaginated(0, 30)).withRel("articulos")))
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                CollectionModel.of(rubros,
                        linkTo(methodOn(RubroListaPrecioController.class).findAll()).withSelfRel())
        );    }

    @GetMapping("/{rubroId}")
    public ResponseEntity<RubroListaPrecioDto> findByRubroId(@PathVariable Long rubroId) {
        try {
            return ResponseEntity.ok(service.findByRubroId(rubroId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<RubroListaPrecioDto> addOrUpdate(@RequestBody RubroListaPrecioDto rubroListaPrecio) {
        return ResponseEntity.ok(service.addOrUpdate(rubroListaPrecio));
    }

}
