package com.scpfoundation.psybotic.server.serviceInterfaces;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.BasicModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @param <E>: Entity (e.g. User, ...)
 * @param <T>: The id data type for the entry provided (e.g. String for User.class)
 */
public interface ICRUDService<E extends BasicModel, T> {
    E findById(T id);

    ResponseEntity<GeneralResponse> insert(E entity);

    ResponseEntity<GeneralResponse> deleteById(T id);

    ResponseEntity<GeneralResponse> delete(E entity);

    ResponseEntity<GeneralResponse> update(E entity);
}
