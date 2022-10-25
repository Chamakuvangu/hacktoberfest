package zw.ac.buse.buse_canteen.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zw.ac.buse.buse_canteen.Model.student;
import zw.ac.buse.buse_canteen.Repository.Student_Repository;

@RestController
public class Student_Controller {
    @Autowired

    Student_Repository student_repository;



    @RequestMapping(value = "/student checkout",method = RequestMethod.POST)
    public ResponseEntity<Object> studentCheckout(@RequestParam String barcode ,@RequestParam float total){
        float bal=0;
        float cbal=0;
        student student=student_repository.findByBarcode(barcode);
         bal+=student.getBalance();
         cbal+= bal-total;
         student.setBalance(cbal);
         student_repository.save(student);

        return new ResponseEntity<Object>("Transaction Successful", HttpStatus.OK);



    }
}

