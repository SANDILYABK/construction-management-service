package com.cm.admirable.controller;

import com.cm.admirable.entity.ACMMainDetails;
import com.cm.admirable.repositary.ACMMainRepositary;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admirablecm")
@RequiredArgsConstructor
public class ACMMainController {

    /*GET REQUEST FOR MAIN*/
@Autowired
    private ACMMainRepositary mainrepo;
//  http://localhost:7787/admirablecm/aboutus
    @GetMapping("/aboutus")
    public List<ACMMainDetails> AboutOrganization() {
        System.out.println("Validate");
//         return mainrepo.cmpDetails();
        return mainrepo.findAll();
     }
//    http://localhost:7787/admirablecm/achieves

    @GetMapping("/achieves")
     public List<Object[]> achievement(){

      return mainrepo.certifiedDts();
     }
    @GetMapping("/newachivers")
     public List<ACMMainDetails> achievedBatch(){
        return mainrepo.findByAchivements("Bronze");
     }

     @GetMapping("/cmpnydetails")
     public List<ACMMainDetails> companyDts(){
        return mainrepo.findBycompanydetails("SRK");
     }
    /*INSERT REQEUST FOR MAIN*/
    /*http://localhost:7787/admirablecm/acminsert*/
    @PostMapping("/acminsert")
    public ACMMainDetails insertData(@RequestBody ACMMainDetails details){
        return mainrepo.save(details);
    }
//Check this
    @PostMapping("/recordinsert")
    public ACMMainDetails loadData(@RequestBody  ACMMainDetails record){
        ACMMainDetails saved = mainrepo.save(record);
        return mainrepo.save(saved);
//        return ACMMainDetails.ok(saved);
    }
     /*DELETE REQUEST FOR MAIN*/
    @DeleteMapping("/deletemenurecord")
    public void deleteMenuData(){
        mainrepo.delete(mainrepo.getReferenceById(Long.valueOf("8")));
    }

    @DeleteMapping("/deletes/{id}")
    public String deleteById(@PathVariable long id) {
        mainrepo.deleteById(id);
        return "Deleted successfully";
    }

}