package com.kmd.eatmoji.exception;

import com.kmd.eatmoji.common.exception.BaseRuntimeException;
import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends BaseRuntimeException {

    public ResourceNotFoundException(Long id) {
        super("Resource with " + id + " not found", HttpStatus.NOT_FOUND);
    }
}
