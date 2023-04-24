
/*import org.junit.Test;*/

import com.resultados.clases.Apuesta;
import com.resultados.clases.Equipo;
import com.resultados.clases.Partido;
import com.resultados.clases.Persona;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
 class testPronosticosDeportivos {

    @Test
    void testPronosticos() {

        Equipo Argentina = new Equipo("Argentina","Futbol");
        Equipo Colombia = new Equipo("Colombia","Futbol");
        Equipo Canada = new Equipo("Canada","Futbol");
        Equipo Mexico = new Equipo("Mexico","Futbol");

        Partido partido1 = new Partido(Argentina,Mexico,2,0);
        Partido partido2 = new Partido(Colombia,Canada,2,0);
        Partido[] vectorPartido = {partido1,partido2};

        Persona persona = new Persona();
        Apuesta pronostico1 = new Apuesta(partido1,Argentina);
        Apuesta pronostico2 = new Apuesta(partido2,Colombia);
        Apuesta[] vectorApuesta = {pronostico1,pronostico2};

        assertEquals(2,pronostico1.getGanaEquipo1());
        assertEquals(2,pronostico2.getGanaEquipo2());
        assertEquals(4, persona.getNombre());
    }

}





