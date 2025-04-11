package empleados;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class ESteps {
    private String baseUri = "https://reqres.in/api/users";

    @Step("Crear empleado con nombre {0} y trabajo {1}")
    public void registrarEmpleado(String nombre, String trabajo) {
        String body = String.format("{\n" +
            " \"name\": \"%s\",\n" +
            " \"job\": \"%s\"\n" +
            "}", nombre, trabajo);

        SerenityRest.given()
            .contentType(ContentType.JSON)
            .body(body)
        .when()
            .post(baseUri);
    }

    @Step("Actualizar datos del empleado con ID {0}, nuevo nombre {1} y nuevo trabajo {2}")
    public void actualizarEmpleado(String id, String nombre, String trabajo) {
        String body = String.format("{\n" +
            " \"name\": \"%s\",\n" +
            " \"job\": \"%s\"\n" +
            "}", nombre, trabajo);

        SerenityRest.given()
            .contentType(ContentType.JSON)
            .body(body)
        .when()
            .put(baseUri + "/" + id);
    }
}
