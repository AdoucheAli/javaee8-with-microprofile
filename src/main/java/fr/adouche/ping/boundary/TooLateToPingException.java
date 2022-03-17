package fr.adouche.ping.boundary;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

public class TooLateToPingException extends WebApplicationException {
    public TooLateToPingException(String message) {
        super(Response.status(404).header("info", "session is going to be too late " + message).build());
    }
}
