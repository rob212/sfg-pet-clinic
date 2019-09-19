package com.woita.sfgpetclinic.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author mcbrydr on 06/09/19
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

}
