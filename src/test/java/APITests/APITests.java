package APITests;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class APITests {

   

    @Test
    //ingresar empleado
    public void ingresarempleado() {
     String body = "{\n" +
     " \"name\": \"rodolfo\",\n" +
     " \"job\": \"LT\"\n" +
    "}";
     given()
     .baseUri("https://reqres.in/api").contentType(ContentType.JSON).body(body).when().post("/users").then()
     .statusCode(201).log().all(); 

    }

    @Test

    //actualizar empleado
    public void actualizarempleado() {

        String body = "{\n" +
        " \"name\": \"rodolfo manuel\",\n" +
        " \"job\": \"LT\"\n" +
       "}";
        given()
        .baseUri("https://reqres.in/api").contentType(ContentType.JSON).body(body).when().put("/users/432").then()
        .statusCode(200).log().all(); 

      
    }

     @Test
     //obtener lista de usuarios
     public void obtenerlistausuarios() {
         given()
                 .baseUri("https://reqres.in/api")
                 .when()
                 .get("/users?page=2")
                .then()
                 .statusCode(200).log().all();           
     }

     @Test
    //usuario no encontrado
     public void usuarionoencontrado() {
        given()
                .baseUri("https://reqres.in/api")
                .when()
                .get("/users/23")
                .then()
                 .statusCode(404).log().all();           
    }

     @Test
     //obtener recurso
     public void obtenerrecurso() {
         given()
                 .baseUri("https://reqres.in/api")
                 .when()
                 .get("/unknown/7")
                 .then()
                 .statusCode(200).log().all();           
     }

     @Test
    //actualizar recurso
     public void actualizarrecurso() {
         String body = "{\n" +
     " \"data\": {\n" +
     "   \"id\": 7,\n" +
     "   \"name\": \"negro oscuro\",\n" +
     "   \"year\": 2009,\n" +
     "   \"color\": \"#C0000\",\n" +
     "   \"pantone_value\": \"11-1131\"\n" +
     " },\n" +
     " \"support\": {\n" +
     "   \"url\": \"https://contentcaddy.io?utm_source=reqres&utm_medium=json&utm_campaign=referral\",\n" +
     "   \"text\": \"Tired of writing endless social media content? Let Content Caddy generate it for you.\"\n" +
     " }\n" +
 "}";
         given()
         .baseUri("https://reqres.in/api").contentType(ContentType.JSON).body(body).when().post("/unknown").then()
        .statusCode(201).log().all();   
    }


    @Test
     //eliminar usuario
     public void eliminarusuario() {
        given().baseUri("https://reqres.in").when().delete("/api/users/432").then()
        .statusCode(204).log().all(); 
   }
}



