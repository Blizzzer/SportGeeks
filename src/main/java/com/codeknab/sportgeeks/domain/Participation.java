package com.codeknab.sportgeeks.domain;

import com.codeknab.sportgeeks.enums.ParticipationProbability;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "participation")
@Data
public class Participation {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Enumerated(STRING)
    private ParticipationProbability probability;

    @Column(name = "additional_info")
    private String additionalInfo;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
