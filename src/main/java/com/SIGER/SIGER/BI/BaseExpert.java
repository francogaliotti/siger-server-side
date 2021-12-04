package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.model.requests.BaseRequest;
import com.SIGER.SIGER.model.responses.BaseResponse;
import java.io.Serializable;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

public interface BaseExpert<Req extends BaseRequest, Res extends BaseResponse, ID extends Serializable> {

  ResponseEntity<List<Res>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception;

  ResponseEntity<Res> findById(ID id) throws Exception;

  ResponseEntity<Res> save(Req request) throws Exception;

  ResponseEntity<Res> update(ID id, @RequestBody Req dto)
      throws Exception;

  ResponseEntity<?> delete(ID id) throws Exception;

}
