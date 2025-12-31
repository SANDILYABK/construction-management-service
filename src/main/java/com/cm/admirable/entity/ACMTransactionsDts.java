package com.cm.admirable.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@Table
@NoArgsConstructor
public class ACMTransactionsDts {
    @Id
    int tid ;
    String transaction_date;
    String customer_name;
    String tamount;
    String cust_address;
    String contact_details;

}
