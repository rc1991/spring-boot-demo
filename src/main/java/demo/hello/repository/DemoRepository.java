package demo.hello.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import demo.hello.po.DemoPO;

public interface DemoRepository extends MongoRepository<DemoPO, String> {

    List<DemoPO> findAll();
    DemoPO findByName(String name);
}
