package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InscripcionTest {

    @Test
    @DisplayName("Testing correlativa una unica materia")
    public void testInscripcionAprobada() {
        Alumno facu = new Alumno("Facu", "Hernandez", "125");

        Materia algoritmos = new Materia("Algoritmos", 1);
        Materia paradigmas = new Materia("Paradigmas", 2);

        paradigmas.addCorrelativa(algoritmos);

        facu.aprobarMateria(algoritmos); // Si comento esta linea y abajo uso False tambien deberia funcionar

        Inscripcion insc = new Inscripcion();
        insc.setAlumno(facu);
        insc.addMateria(paradigmas);

        assertTrue(insc.aprobada());
    }

    @Test
    @DisplayName("Testing correlativa 2 materias")
    public void testInscripcionNoAprobada() {
        Alumno juan = new Alumno("Juan", "Garrone", "121");

        Materia analisis_de_sistemas = new Materia("Analisis de sistemas", 3);
        Materia paradigmas = new Materia("Algoritmos", 1);
        Materia disenio = new Materia("Disenio", 2);

        disenio.addCorrelativa(paradigmas);
        disenio.addCorrelativa(analisis_de_sistemas);

        juan.aprobarMateria(paradigmas);
        // No aprueba Analisis de sistemas (no esta en la lista)

        Inscripcion insc = new Inscripcion();
        insc.setAlumno(juan);
        insc.addMateria(disenio);

        assertFalse(insc.aprobada());
    }
}

