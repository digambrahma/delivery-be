package delivery.deliverybe.repository;

import delivery.deliverybe.model.Driver;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DriverRepository extends MongoRepository<Driver, String> {

    Driver findByEmail(String email);

    Driver findByPhone(String phone);

}
