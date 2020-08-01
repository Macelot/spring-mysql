import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

public class UsuarioTest {

    private String urllocal = "http://localhost:8088";


    @Test
    public void postUserTestLocal(){
        given().
                queryParam("nome", "Marcelo Telles").
                queryParam("email", "marcelo@server.com").
                queryParam("salario", "18000.00f").
                queryParam("senha", "123").
                queryParam("sexo", 'M').
                when().
                post(urllocal+"/add").
                then().
                body(containsString("Novo usuário adicionado"));
    }


}
