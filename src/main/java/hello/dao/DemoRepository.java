package hello.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import hello.po.DemoPO;

public interface DemoRepository extends MongoRepository<DemoPO, String> {

    List<DemoPO> findAll();
    DemoPO findByName(String name);
}
