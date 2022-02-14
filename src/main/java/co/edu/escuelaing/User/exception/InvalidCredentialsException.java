package co.edu.escuelaing.User.exception;


import co.edu.escuelaing.User.data.ErrorCodeEnum;
import co.edu.escuelaing.User.dto.ServerErrorResponseDto;
import org.springframework.http.HttpStatus;

import javax.ws.rs.InternalServerErrorException;

public class InvalidCredentialsException extends InternalServerErrorException {

    public InvalidCredentialsException() {
        super();
    }
}
