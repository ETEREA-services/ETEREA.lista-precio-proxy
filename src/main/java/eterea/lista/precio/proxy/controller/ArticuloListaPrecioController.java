package eterea.lista.precio.proxy.controller;

import eterea.lista.precio.proxy.domain.dto.ArticuloListaPrecioDto;
import eterea.lista.precio.proxy.service.ArticuloListaPrecioService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/lista/precio/articuloListaPrecio")
@RequiredArgsConstructor
public class ArticuloListaPrecioController {

    private final ArticuloListaPrecioService service;

    @GetMapping("/page")
    public ResponseEntity<CollectionModel<EntityModel<ArticuloListaPrecioDto>>> findAllPublicadosPaginated(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size) {
            
        Page<ArticuloListaPrecioDto> pageResult = service.findAllPublicadosPaginated(page, size);
        
        List<EntityModel<ArticuloListaPrecioDto>> articulos = pageResult.getContent().stream()
            .map(articulo -> EntityModel.of(articulo,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ArticuloListaPrecioController.class)
                    .findByArticuloId(articulo.getArticuloId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ArticuloListaPrecioController.class)
                    .findAllPublicadosPaginated(page, size)).withRel("articulos")))
            .collect(Collectors.toList());

        CollectionModel<EntityModel<ArticuloListaPrecioDto>> result = CollectionModel.of(articulos);
        
        if (pageResult.hasNext()) {
            result.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ArticuloListaPrecioController.class)
                .findAllPublicadosPaginated(page + 1, size)).withRel("next"));
        }
        if (pageResult.hasPrevious()) {
            result.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ArticuloListaPrecioController.class)
                .findAllPublicadosPaginated(page - 1, size)).withRel("prev"));
        }

        return ResponseEntity.ok(result);
    }

    @GetMapping("/{articuloId}")
    public ResponseEntity<ArticuloListaPrecioDto> findByArticuloId(@PathVariable String articuloId) {
        try {
            return ResponseEntity.ok(service.findByArticuloId(articuloId));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/rubro/{rubroId}/page")
    public ResponseEntity<CollectionModel<EntityModel<ArticuloListaPrecioDto>>> findAllByRubroIdPaginated(
            @PathVariable Integer rubroId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "30") int size) {
            
        Page<ArticuloListaPrecioDto> pageResult = service.findAllByRubroIdPaginated(rubroId, page, size);
        
        List<EntityModel<ArticuloListaPrecioDto>> articulos = pageResult.getContent().stream()
            .map(articulo -> EntityModel.of(articulo,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ArticuloListaPrecioController.class)
                    .findByArticuloId(articulo.getArticuloId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ArticuloListaPrecioController.class)
                    .findAllByRubroIdPaginated(rubroId, page, size)).withRel("articulos"),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RubroListaPrecioController.class)
                    .findAll()).withRel("rubros")))
            .collect(Collectors.toList());

        CollectionModel<EntityModel<ArticuloListaPrecioDto>> result = CollectionModel.of(articulos);
        
        if (pageResult.hasNext()) {
            result.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ArticuloListaPrecioController.class)
                .findAllByRubroIdPaginated(rubroId, page + 1, size)).withRel("next"));
        }
        if (pageResult.hasPrevious()) {
            result.add(WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ArticuloListaPrecioController.class)
                .findAllByRubroIdPaginated(rubroId, page - 1, size)).withRel("prev"));
        }

        return ResponseEntity.ok(result);
    }

}
