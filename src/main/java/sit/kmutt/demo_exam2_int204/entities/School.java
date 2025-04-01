package sit.kmutt.demo_exam2_int204.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "school")
@Getter
@Setter
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int schoolId;

    @NotNull
    private String schoolName;

    private String schoolAddress;

    @JsonIgnore
    @OneToMany(mappedBy = "school")
    private List<Student> students;
}
