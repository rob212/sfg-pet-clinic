package com.woita.sfgpetclinic.services;

import java.util.Set;

/**
 * @author mcbrydr on 12/08/19
 */
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);
}
