package com.scpfoundation.psybotic.server.services;

import com.scpfoundation.psybotic.server.custom.GeneralResponse;
import com.scpfoundation.psybotic.server.models.BasicModel;
import com.scpfoundation.psybotic.server.models.EmergencyContact;
import com.scpfoundation.psybotic.server.serviceInterfaces.ICRUDService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * This class does some basic CRUD operations
 * All other Service classes should extend this class and pass basic crud operations
 * to its super class.
 * Any specific implementations can be done separately
 *
 * @param <T> : Model repository (e.g. UserRepository, ...)
 * @param <E> : Entity model (e.g. User, ...)
 */
public class CRUDService<T extends MongoRepository<E, String>,
        E extends BasicModel> implements ICRUDService<E, String> {

    private final T repository;

    public CRUDService(T repository) {
        this.repository = repository;
    }

    @Override
    public E findById(String id) {
        Optional<E> entity = repository.findById(id);
        return entity.orElse(null);
    }

    @Override
    @Transactional
    public ResponseEntity<GeneralResponse> insert(E entity) {
        GeneralResponse res = new GeneralResponse();
        try {
            repository.save(entity);
            res.setMessage("Entity saved successfully");
            res.setStatus(HttpStatus.OK.value());
        } catch (Exception e) {
            res.setError(e.getMessage());
            res.setMessage("Encountered en error while inserting new entity");
            res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        HttpStatus status = HttpStatus.resolve(res.getStatus());
        if (status != null) {
            return new ResponseEntity<>(res, status);
        } else {
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<GeneralResponse> deleteById(String id) {
        GeneralResponse res = new GeneralResponse();
        try {
            Optional<E> entity = repository.findById(id);
            if (entity.isPresent()) {
                repository.delete(entity.get());
                res.setStatus(HttpStatus.OK.value());
                res.setMessage("Entity deleted successfully");
            } else {
                res.setMessage("Entity is not deleted");
                res.setWarning("The entity with the provided id cannot be found");
                res.setStatus(HttpStatus.OK.value());
            }
        } catch (Exception e) {
            res.setMessage("Encountered an error while deleting entity");
            res.setError(e.getMessage());
            res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
        HttpStatus status = HttpStatus.resolve(res.getStatus());
        if (status != null) {
            return new ResponseEntity<>(res, status);
        } else {
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Transactional
    public ResponseEntity<GeneralResponse> delete(E entity) {
        GeneralResponse res = new GeneralResponse();
        try {
            if (entity.getId() != null && repository.findById((String) entity.getId()).isPresent()) {
                repository.delete(entity);
                res.setMessage("Entity deleted successfully");
                res.setStatus(HttpStatus.OK.value());
            } else {
                res.setStatus(HttpStatus.BAD_REQUEST.value());
                if (entity.getId() == null) {
                    res.setWarning("Be sure you provided an id field");
                } else {
                    res.setWarning("Entity cannot be found");
                }
                res.setMessage("Deleting entity is not done!");
            }
        } catch (Exception e) {
            res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
            res.setMessage("Encountered an error while deleting entity");
            res.setError(e.getMessage());
        }
        HttpStatus status = HttpStatus.resolve(res.getStatus());
        if (status != null) {
            return new ResponseEntity<>(res, status);
        } else {
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @Transactional
    @Override
    public ResponseEntity<GeneralResponse> update(E updatedEntity) {
        GeneralResponse res = new GeneralResponse();
        try {
            if (updatedEntity.getId() != null && repository.findById((String) updatedEntity.getId()).isPresent()) {
                repository.save(updatedEntity);
                res.setStatus(HttpStatus.OK.value());
                res.setMessage("Entity updated successfully");
            } else {
                res.setMessage("Entity cannot be updated");
                res.setStatus(HttpStatus.BAD_REQUEST.value()); // Bad request, this operation requires an id field
                if (updatedEntity.getId() == null) {
                    res.setWarning("Be sure you provided an id field");
                } else {
                    res.setWarning("Entity cannot be found by the provided id");
                }
            }
        } catch (Exception e) {
            res.setMessage("Encountered an error while updating entity");
            res.setError(e.getMessage());
            res.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value()); // Internal server error
        }
        HttpStatus status = HttpStatus.resolve(res.getStatus());
        if (status != null) {
            return new ResponseEntity<>(res, status);
        } else {
            return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<EmergencyContact> findBySuperId(String id) {
        return null;
    }
}
