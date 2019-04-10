import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.URL;

public class ApiTest {

    String host = "https://api.github.com/users/";
    ObjectMapper mapper = new ObjectMapper();
    String login = "DaryPopova";

    @BeforeSuite
    public void doRequest() throws Exception {
        RequestSender.sendGetRequest(host + login);
    }

    @Test(description = "GET")
    public void testGithubGetUser() throws Exception {
        JsonNode tree = mapper.readTree(new URL("https://api.github.com/users/" + login));
        Assert.assertEquals(tree.get("login").asText(), login);
    }

    @Test(description = "GET")
    public void testGithubGetLocation() throws Exception {
        JsonNode tree = mapper.readTree(new URL("https://api.github.com/users/" + login));
        Assert.assertFalse(tree.has("locat"));
    }
}