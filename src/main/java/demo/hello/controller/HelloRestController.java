package demo.hello.controller;

import demo.hello.repository.DemoRepository;
import demo.hello.po.DemoPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloRestController {

    @Autowired
    private DemoRepository repository;

    @PostMapping("/create")
    public ResponseEntity createDemo(@RequestParam String name){
        if (name.isBlank()){
            String msg = "Name is blank.";
            System.out.println(msg);
            return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);
        }
        DemoPO po = new DemoPO(name);
        try {
            po = repository.insert(po);
        }catch(Exception e) {
            String msg = String.format("Insertion failed. po: %s, msg: %s", po, e.getMessage());
            System.out.println(msg);
            return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        System.out.println("Create Demo: " + po);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateDemo(@PathVariable String id, @RequestParam String name){
        try {
            DemoPO po = repository.findById(id).orElseThrow();
            po.setName(name);
            repository.save(po);
        }catch(Exception e){
            String msg = String.format("Update failed. id: %s, msg: %s", id, e.getMessage());
            System.out.println(msg);
            return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteDemo(@PathVariable String id){
        try {
            repository.deleteById(id);
        }catch(Exception e){
            String msg = String.format("Delete failed. id: %s, msg: %s", id, e.getMessage());
            System.out.println(msg);
            return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
