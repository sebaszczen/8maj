package pl.b2bnetwork.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Part {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private int yearProducion;
    @ManyToOne
    @JoinColumn(name = "engine_id")
    private Engine engine;

    @Override
    public String toString() {
        return "Part{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", yearProducion=" + yearProducion +
                ", engine=" + engine +
                '}';
    }
}
