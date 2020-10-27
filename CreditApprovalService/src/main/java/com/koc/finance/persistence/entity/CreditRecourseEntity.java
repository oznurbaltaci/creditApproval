package com.koc.finance.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CREDIT_RECOURSE")
public class CreditRecourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    @NotNull
    @Column(name = "identity_number", length = 11)
    private Long identityNumber;
    @NotNull
    @Column(name = "name", length = 30)
    private String name;
    @NotNull
    @Column(name = "surname", length = 30)
    private String surname;
    @NotNull
    @Column(name = "monthly_income")
    private Integer monthlyIncome;
    @NotNull
    @Column(name = "phone_number", length = 14)
    private String phoneNumber;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "credit_status", length = 3)
    private Integer creditStatus;
    @Nullable
    @Column(name = "credit_amount")
    private Integer creditAmount;
}