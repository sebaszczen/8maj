package pl.b2bnetwork.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Engine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String name;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "engine")
    private List<Part> parts = new ArrayList<>();
    private int yearProduction;
    private EngineCat engineCat;
    @JoinColumn(name = "car_id")
    @OneToOne(mappedBy = "engine",cascade = CascadeType.ALL)
    private Car car;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(int yearProduction) {
        this.yearProduction = yearProduction;
    }

    public EngineCat getEngineCat() {
        return engineCat;
    }

    public void setEngineCat(EngineCat engineCat) {
        this.engineCat = engineCat;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
