package com.cm.admirable.repositary;

import com.cm.admirable.entity.ACMMainDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
//@EnableJpaRepositories
public interface ACMMainRepositary extends JpaRepository<ACMMainDetails, Long> {
    /* READ OPEARIONS */
    @Query("select 1 from ACMMainDetails")
    public List<ACMMainDetails> maindetails();
    @Query(value = "select distinct achivements from acmmaindetails where achivements='Bronze'", nativeQuery = true)
    public List<Object[]> certifiedDts();

    //    customized methods
    List<ACMMainDetails> findByAchivements(String achivements);
    List<ACMMainDetails> findBycompanydetails(String companydetails);
    /* READ BY UPDATE */


    /* DELETE OPERATION */
    @Modifying
    @Query("delete ACMMainDetails where id =8")
    void deleteMaindetails(long id);
    ACMMainDetails deleteById(long id);   //    void deleteById(Long id); we can request as this as well
}