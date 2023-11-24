package com.orderservice.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalHandlerException {

	// @ExceptionHandler(InvalidRoomException.class)
	
//	@ExceptionHandler()
//		public ResponseEntity<String> InvalidStaffException(Exception e){
//			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
//		}
}
