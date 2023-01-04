package com.neki.projeto.nekiproject.handler;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.neki.projeto.nekiproject.exception.ResourceBadRequestException;
import com.neki.projeto.nekiproject.exception.ResourceNotFoundException;
import com.neki.projeto.nekiproject.model.error.MensagemError;
import com.neki.projeto.nekiproject.utils.ConversorDeData;

@ControllerAdvice
public class RestExceptionHandler {
	@Valid
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<MensagemError> handlerResourceNotFoundException(ResourceNotFoundException ex) {
		String dataHora = ConversorDeData.converterDateParaDataEHora(new Date());
		MensagemError erro = new MensagemError(dataHora, 404, "Not Found", ex.getMessage());
		return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
	}

	@Valid
	@ExceptionHandler(ResourceBadRequestException.class)
	public ResponseEntity<MensagemError> handlerBadRequestException(ResourceBadRequestException ex) {
		String dataHora = ConversorDeData.converterDateParaDataEHora(new Date());
		MensagemError erro = new MensagemError(dataHora, 400, "Bad Request", ex.getMessage());
		return new ResponseEntity<>(erro, HttpStatus.BAD_REQUEST);
	}

	@Valid
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MensagemError> handlerBadRequestException(Exception ex) {
		String dataHora = ConversorDeData.converterDateParaDataEHora(new Date());
		MensagemError erro = new MensagemError(dataHora, 500, "Internal Server Error", ex.getMessage());
		return new ResponseEntity<>(erro, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}