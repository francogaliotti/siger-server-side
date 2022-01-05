package com.SIGER.SIGER.BI;

import com.SIGER.SIGER.model.entities.BaseEntity;
import com.SIGER.SIGER.model.requests.BaseRequest;
import com.SIGER.SIGER.model.responses.BaseResponse;
import com.SIGER.SIGER.services.AbsBaseService;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public abstract class AbsBaseExpert<E extends BaseEntity,
    S extends AbsBaseService<E, Long>, Req extends BaseRequest, Res extends BaseResponse> implements
    BaseExpert<Req, Res, Long> {

  Res response;

  ModelMapper modelMapper = new ModelMapper();

  public ResponseEntity<List<Res>> findAll(int page, int size,
      UriComponentsBuilder uriBuilder, HttpServletResponse response) throws Exception {
    return new ResponseEntity(this.response, HttpStatus.OK);
  }


  public ResponseEntity<Res> findById(Long id) throws Exception {
    return new ResponseEntity(response, HttpStatus.OK);
  }


  public ResponseEntity<Res> save(Req request) throws Exception {
    return new ResponseEntity(response, HttpStatus.OK);
  }


  public ResponseEntity<Res> update(Long id, Req request)
      throws Exception {
    return new ResponseEntity(response, HttpStatus.OK);
  }


  public ResponseEntity<?> delete(Long id) throws Exception {
    return new ResponseEntity(HttpStatus.OK);
  }

}
