package com.SIGER.SIGER.emailSender.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class EmailValuesDTO {

  private String mailFrom;

  private String mailTo;

  private String subject;

  private String username;

  private String password;

  private String tokenPassword;

}
