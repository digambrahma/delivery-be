package delivery.deliverybe.service;

import delivery.deliverybe.model.Driver;
import delivery.deliverybe.repository.DriverRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverServiceImpl implements DriverService {

    private final DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver save(Driver driver) {
        return driverRepository.save(driver);
    }

    @Override
    public Driver getById(String id) {
        return null;
    }

    @Override
    public Driver getByEmail(String email) {
        return driverRepository.findByEmail(email);
    }

    @Override
    public Driver getByPhone(String phone) {
        return driverRepository.findByPhone(phone);
    }

    @Override
    public Driver update(String id, Driver driver) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteAll() {
        driverRepository.deleteAll();
    }
}
