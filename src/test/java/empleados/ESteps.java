package empleados;

import io.restassured.http.ContentType;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;

public class ESteps {
    private String baseUri = "https://reqres.in/api/users";

    @Step("Crear empleado con nombre {0} y trabajo {1}")
    public void registrarEmpleado(String nombre, String trabajo , int codeStatus) {
        String body = String.format("{\n" +
            " \"name\": \"%s\",\n" +
            " \"job\": \"%s\"\n" +
            "}", nombre, trabajo);

        SerenityRest.given()
            .contentType(ContentType.JSON)
            .body(body)
        .when()
            .post(baseUri).then()
            .statusCode(codeStatus).log().all();
    }

    @Step("Actualizar datos del empleado con ID {0}, nuevo nombre {1} y nuevo trabajo {2}")
    public void actualizarEmpleado(String id, String nombre, String trabajo , int codeStatus) {
        String body = String.format("{\n" +
            " \"name\": \"%s\",\n" +
            " \"job\": \"%s\"\n" +
            "}", nombre, trabajo);

        SerenityRest.given()
            .contentType(ContentType.JSON)
            .body(body)
        .when()
            .put(baseUri + "/" + id).then()
            .statusCode(codeStatus).log().all();
    }

    @Step("Obtener lista de usuarios de la página {0}")
    public void obtenerListaUsuarios(String numeroPagina, int codeStatus) {
        SerenityRest.given()
            .baseUri(baseUri)
        .when()
            .get("?page=" + numeroPagina).then()
            .statusCode(codeStatus).log().all();
    }

    @Step("Buscar usuario con ID {0}")
    public void buscarUsuario(String userId , int codeStatus) {
        SerenityRest.given()
            .baseUri(baseUri)
        .when()
            .get("/" + userId).then()
            .statusCode(codeStatus).log().all();
    }

    @Step("Obtener recurso con ID {0}")
    public void obtenerRecurso(String resourceId, int codeStatus) {
        SerenityRest.given()
            .baseUri("https://reqres.in/api/unknown")
        .when()
            .get("/" + resourceId).then()
            .statusCode(codeStatus).log().all();
    }

    @Step("Actualizar recurso")
    public void registrarRecurso(String id, String nombre, String year, String color, String pantoneValue , int codeStatus) {
        String body = String.format("{\n" +
            " \"data\": {\n" +
            "   \"id\": %s,\n" +
            "   \"name\": \"%s\",\n" +
            "   \"year\": %s,\n" +
            "   \"color\": \"%s\",\n" +
            "   \"pantone_value\": \"%s\"\n" +
            " }\n" +
            "}", id, nombre, year, color, pantoneValue);

        SerenityRest.given()
            .contentType(ContentType.JSON)
            .body(body)
        .when()
            .post("https://reqres.in/api/unknown").then()
            .statusCode(codeStatus).log().all();
    }

    @Step("Eliminar usuario con ID {0}")
    public void eliminarUsuario(String userId , int codeStatus) {
        SerenityRest.given()
            .baseUri("https://reqres.in")
        .when()
            .delete("/api/users/" + userId).then()
            .statusCode(codeStatus).log().all();
    }
}
