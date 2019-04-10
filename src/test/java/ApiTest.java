import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class ApiTest {

    String host = "https://api.github.com/users/";
    ObjectMapper mapper = new ObjectMapper();
    String login = "DaryPopova";
    Response response = get(host + login);

    @BeforeSuite
    public void doRequest() throws Exception {
    }

    @Test(description = "GET")
    public void testGithubGetUser() throws Exception {
        JsonNode tree = mapper.readTree(response.asString());
        Assert.assertEquals(tree.get("login").asText(), login);
    }

    @Test(description = "GET")
    public void testGithubGetLocation() throws Exception {
        JsonNode tree = mapper.readTree(response.asString());
        Assert.assertFalse(tree.get("company").isNull());
    }
}