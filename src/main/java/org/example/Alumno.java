package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Alumno {
    private String nombre;
    private String apellido;
    private String legajo;

    private List<Materia> materiasAprobadas;

    // Misma duda, aca si le paso los args
    public Alumno(String nombre, String apellido, String legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.materiasAprobadas = new ArrayList<Materia>();
    }

    public void aprobarMateria(Materia ... materias) {
        Collections.addAll(this.materiasAprobadas, materias);
    }

    public boolean aprobo(Materia m) {
        return this.materiasAprobadas.contains(m);
    }

    public boolean cumpleCorrelativasPara(Materia materia) {
        return materia.getCorrelativas().stream().allMatch(this::aprobo);
    }
}
