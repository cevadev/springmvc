package com.ceva.config.root;

import java.util.List;

/**
 * Componente DAO
 */
public interface DataRepository {
    public void save(Person person);
    public List<Person> list();
    public void delete(int id_person);
}