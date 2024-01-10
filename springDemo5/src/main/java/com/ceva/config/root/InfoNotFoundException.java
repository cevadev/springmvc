package com.ceva.config.root;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Registro no encontrado.")
public class InfoNotFoundException extends Exception {

}

