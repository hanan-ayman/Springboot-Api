package com.flairsteck.workshop.exception;

import lombok.Data;

/**
 *
 * @author hanan.ayman
 */

@Data
public class ErrorResponse{

  private String status;
  private String message;

  /**
   * Instantiates a new Error response.
   *
   * @param status the status
   * @param message the message
   */
  public ErrorResponse(String status, String message) {
    this.status = status;
    this.message = message;
  }
  
}
