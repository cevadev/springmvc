package com.ceva.config.root;

import java.util.List;
import org.springframework.jdbc.core.JdbcOperations;

/**
 * Implementacion del
 */
public class JdbcRepository implements DataRepository {
    private final String INSERT_PERSON = "insert into person(name,address,phone) values (?,?,?)";
    private final String LIST_PERSON = "select id_person, name, address, phone from person order by id_person";
    private final String DELETE_PERSON = "delete from person where id_person=?";

    private JdbcOperations jdbcOperations;

    public JdbcRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void save(Person person) {
        jdbcOperations.update(INSERT_PERSON,
                person.getName(),
                person.getAddress(),
                person.getPhone()
        );
    }

    @Override
    public List<Person> list() {
        return jdbcOperations.query(LIST_PERSON, (rs, rowNum) ->
                // callback que se ejecuta para cada registro de la lista de personas
                new Person(rs.getInt("id_person"), rs.getString("name"), rs.getString("address"), rs.getString("phone"))
        );
    }

    @Override
    public void delete(int id_person) {
        jdbcOperations.update(DELETE_PERSON, id_person);
    }
}

