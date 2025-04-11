package empleados;

import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class ETests {
    
    private ESteps steps = new ESteps();
    
    @Test
    public void testCrearNuevoEmpleado() {
        steps.registrarEmpleado("rodolfo", "LT");
    }
    
    @Test
    public void testActualizarEmpleadoExistente() {
        steps.actualizarEmpleado("432", "rodolfo manuel", "LT");
    }
}
