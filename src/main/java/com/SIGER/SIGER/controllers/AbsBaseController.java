package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.BI.AbsBaseExpert;
import com.SIGER.SIGER.common.PaginatedResultsHeaderUtils;
import com.SIGER.SIGER.model.entities.BaseEntity;
import com.SIGER.SIGER.model.requests.BaseRequest;
import com.SIGER.SIGER.model.responses.BaseResponse;
import com.SIGER.SIGER.services.AbsBaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class AbsBaseController
    <E extends BaseEntity, S extends AbsBaseService<E, Long>,
        Req extends BaseRequest, Res extends BaseResponse,
        Ex extends AbsBaseExpert<E, S, Req, Res>>
    implements BaseController<Req, Res, Long> {

  @Autowired
  protected Ex expert;

  E entity;

  @Operation(summary = "Este método devuelve una lista de objetos")
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200",
          description = "trae una lista de objetos del Controller correspondiente",
          content = {@Content}),
      @ApiResponse(responseCode = "404",
          description = "el controlador no se encuentra, o no es posible comunicarse con la base de datos",
          content = @Content)})
  @GetMapping("/")
  public ResponseEntity<List<Res>> getAll(@RequestParam("page") int page,
      UriComponentsBuilder uriBuilder,
      HttpServletResponse response) throws Exception {
    return expert.findAll(page, PaginatedResultsHeaderUtils.PAGE_SIZE,uriBuilder,response);
  }

  @Operation(summary = "Este método devuelve un objeto", parameters = @Parameter(name = "id", in = ParameterIn.PATH, required = true, schema = @Schema(type = "Long")))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200",
          description = "trae un objeto del Controller correspondiente",
          content = {@Content(mediaType = "application/json")}),
      @ApiResponse(responseCode = "404",
          description = "el controlador no se encuentra, o no es posible comunicarse con la base de datos",
          content = @Content)

  })
  @GetMapping("/{id}")
  public ResponseEntity<Res> getById(@PathVariable Long id) throws Exception {
    return expert.findById(id);

  }

  @Operation(summary = "Este método guarda un objeto", parameters = @Parameter(name = "entity", in = ParameterIn.PATH, required = true, schema = @Schema(type = "Object")))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200",
          description = "guarda un objeto en la base de datos",
          content = {@Content(mediaType = "application/json")}),
      @ApiResponse(responseCode = "404",
          description = "el controlador no se encuentra, o no es posible comunicarse con la base de datos",
          content = @Content)

  })
  @PostMapping("/")
  public ResponseEntity<Res> post(@RequestBody Req req) throws Exception {
    return expert.save(req);
  }

  @Operation(summary = "Este método recibe un id y actualiza el objeto asociado", parameters = @Parameter(name = "id", in = ParameterIn.PATH, required = true, schema = @Schema(type = "Long")))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200",
          description = "actualiza un objeto en la base de datos",
          content = {@Content(mediaType = "application/json")}),
      @ApiResponse(responseCode = "404",
          description = "el controlador no se encuentra, o no es posible comunicarse con la base de datos",
          content = @Content)

  })
  @PutMapping("/{id}")
  public ResponseEntity<Res> put(@PathVariable Long id, @RequestBody Req req) throws Exception {
    return expert.update(id, req);

  }

  @Operation(summary = "Este método recibe un id y actualiza el objeto asociado", parameters = @Parameter(name = "id", in = ParameterIn.PATH, required = true, schema = @Schema(type = "Long")))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200",
          description = "actualiza un objeto en la base de datos",
          content = {@Content(mediaType = "application/json")}),
      @ApiResponse(responseCode = "404",
          description = "el controlador no se encuentra, o no es posible comunicarse con la base de datos",
          content = @Content)

  })
  @PatchMapping("/{id}")
  public ResponseEntity<Res> patch(@PathVariable Long id, @RequestBody Req req) throws Exception {
    return expert.update(id, req);

  }

  @Operation(summary = "Este método recibe un id y elimina el objeto asociado", parameters = @Parameter(name = "id", in = ParameterIn.PATH, required = true, schema = @Schema(type = "Long")))
  @ApiResponses(value = {
      @ApiResponse(responseCode = "204",
          description = "elimina un objeto en la base de datos",
          content = {@Content(mediaType = "application/json")}),
      @ApiResponse(responseCode = "404",
          description = "el controlador no se encuentra, o no es posible comunicarse con la base de datos",
          content = @Content)

  })
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id) throws Exception {
    return expert.delete(id);
  }

}
