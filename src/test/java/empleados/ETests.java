package empleados;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ETests {
    
    private ESteps steps = new ESteps();
    
    @Test
    public void testCrearNuevoEmpleado() {
        steps.registrarEmpleado("rodolfo", "LT", 201);
    }
    
    @Test
    public void testActualizarEmpleadoExistente() {
        steps.actualizarEmpleado("432", "leonardo", "QA", 200);
    }

    @Test
    public void testObtenerListaUsuarios() {
        steps.obtenerListaUsuarios("2", 200);
    }

    @Test
    public void testUsuarioNoEncontrado() {
        steps.buscarUsuario("23", 404);
    }

    @Test
    public void testObtenerRecurso() {
        steps.obtenerRecurso("20",404);
    }

    @Test
    public void testRegistrarRecurso() {
        steps.registrarRecurso("20", "negro oscuro", "2009", "#C0000", "11-1131" , 201);
    }

    @Test
    public void testEliminarUsuario() {
        steps.eliminarUsuario("432",204);
    }
}
