package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Materia {
    private String nombre_materia;
    private Integer ID_materia;
    private List<Materia> Correlativas;

    // Misma duda, aca si le paso los args
    public Materia(String nombre_materia, Integer Id_materia) {
        this.nombre_materia = nombre_materia;
        this.ID_materia = Id_materia;
        this.Correlativas = new ArrayList<Materia>();
    }

    public void addCorrelativa(Materia ... correlativas) {
        Collections.addAll(this.Correlativas, correlativas);
    }

}
