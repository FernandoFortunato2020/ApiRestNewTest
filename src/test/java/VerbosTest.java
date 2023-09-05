import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;

@DisplayName("Testes de API Rest")
public class VerbosTest {

    private static final String BASE_URI = "https://jsonplaceholder.typicode.com";
    private static final String BASE_PATH = "/users/10";

    @BeforeEach
    public void beforeEach() {
        baseURI = BASE_URI;
        basePath = BASE_PATH;
    }

    @Test
    public void testGet() {
        given()
                .when()
                .get("/users?id=10")
                .then()
                .body("name", contains("Clementina DuBuque"))
                .body("email", contains("Rey.Padberg@karina.biz"))
                .body("username", contains("Moriah.Stanton"))
                .body("phone", contains("024-648-3804"))
                .body("website", contains("ambrose.net"))
                .statusCode(200);
    }

    @Test
    public void testPost() {
        given()
                .body("{\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"Fernando Fortunato\",\n" +
                        "        \"username\": \"FerFortunato\",\n" +
                        "        \"email\": \"fernandofortunato@hotmail.com\",\n" +
                        "        \"address\": {\n" +
                        "            \"street\": \"Frederico Maurer\",\n" +
                        "            \"suite\": \"Apt. 208\",\n" +
                        "            \"city\": \"Curitiba\",\n" +
                        "            \"zipcode\": \"81630-020\",\n" +
                        "            \"geo\": {\n" +
                        "                \"lat\": \"-40.7779\",\n" +
                        "                \"lng\": \"80.8886\"\n" +
                        "            }\n" +
                        "        },\n" +
                        "        \"phone\": \"5-123-876-1111 x56442\",\n" +
                        "        \"website\": \"teste.org\",\n" +
                        "        \"company\": {\n" +
                        "            \"name\": \"Parana\",\n" +
                        "            \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
                        "            \"bs\": \"harness real-time e-markets\"\n" +
                        "        }\n" +
                        "    }'")
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("id", equalTo(11));

    }

    @Test
    public void testPut() {
        given()
                .body("{\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"Fernando Fortunato Alterado\",\n" +
                        "        \"username\": \"FerFortunato Alterado\",\n" +
                        "        \"email\": \"fernandofortunatoalterado@hotmail.com\",\n" +
                        "        \"address\": {\n" +
                        "            \"street\": \"Frederico Maurer Alterado\",\n" +
                        "            \"suite\": \"Apt. 208 Alterado\",\n" +
                        "            \"city\": \"Curitiba Alterado\",\n" +
                        "            \"zipcode\": \"81630-020\",\n" +
                        "            \"geo\": {\n" +
                        "                \"lat\": \"-40.7779\",\n" +
                        "                \"lng\": \"80.8886\"\n" +
                        "            }\n" +
                        "        },\n" +
                        "        \"phone\": \"5-123-876-1111 x56442\",\n" +
                        "        \"website\": \"testealterado.org\",\n" +
                        "        \"company\": {\n" +
                        "            \"name\": \"Parana Alterado\",\n" +
                        "            \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
                        "            \"bs\": \"harness real-time e-markets\"\n" +
                        "        }\n" +
                        "    }'")
                .when()
                .put()
                .then()
                .statusCode(200)
                .body("id", equalTo(10));
    }

    @Test
    public void testDelete() {
        given()
                .when()
                .delete()
                .then()
                .statusCode(200);
    }

}
