package com.SIGER.SIGER.controllers;

import com.SIGER.SIGER.model.requests.BaseRequest;
import com.SIGER.SIGER.model.responses.BaseResponse;
import java.io.Serializable;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;


public interface BaseController <Req extends BaseRequest, Res extends BaseResponse,
    ID extends Serializable>{

    ResponseEntity<List<Res>> getAll(@RequestParam("page") int page,
        UriComponentsBuilder uriBuilder,
        HttpServletResponse response) throws Exception;

    ResponseEntity<Res> getById(@PathVariable ID id) throws Exception;

    ResponseEntity<Res> post(@RequestBody Req req) throws Exception;

    ResponseEntity<Res> put(@PathVariable ID id, @RequestBody Req req)
        throws Exception;

    ResponseEntity<Res> patch(@PathVariable ID id, @RequestBody Req dto)
        throws Exception;

    ResponseEntity<?> delete(@PathVariable ID id) throws Exception;

}
