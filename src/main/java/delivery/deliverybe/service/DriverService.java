package delivery.deliverybe.service;

import delivery.deliverybe.model.Driver;

public interface DriverService {

    Driver save(Driver driver);

    Driver getById(String id);

    Driver getByEmail(String email);

    Driver getByPhone(String phone);

    Driver update(String id, Driver driver);

    void delete(String id);

    void deleteAll();

}
