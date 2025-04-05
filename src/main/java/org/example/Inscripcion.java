package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
public class Inscripcion {
  private List<Materia> materias;
  private Alumno alumno;

  // Duda -> Conviene pasarle los args al constructor o no?
  public Inscripcion() {
      this.materias = new ArrayList<Materia>();
  }

  public void addMateria(Materia ... materias) {
      Collections.addAll(this.materias, materias);
  }

  public boolean aprobada() {
      return materias.stream().allMatch(m -> this.alumno.cumpleCorrelativasPara(m));
  }
}
