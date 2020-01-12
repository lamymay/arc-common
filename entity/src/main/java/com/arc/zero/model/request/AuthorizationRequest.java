package com.arc.zero.model.request;

import lombok.Data;
import org.springframework.http.HttpHeaders;

import java.io.Serializable;

/**
 * @author May
 * @since 2020/1/8 13:05
 */
@Data
public class AuthorizationRequest implements Serializable {

    //header
    private HttpHeaders headers;

    public AuthorizationRequest() {

    }

    public AuthorizationRequest(HttpHeaders headers) {
        this.headers = headers;
    }

}
