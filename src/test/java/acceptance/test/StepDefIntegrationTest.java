package acceptance.test;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import java.io.IOException;

public class StepDefIntegrationTest extends SpringIntegrationTest {
    private ResponseEntity<Object> latestResponse = null;

    @When("the client calls \\/comment")
    public void the_client_post_comment() {

            String json = "{\n" +
                    "\t\"firstname\": \"Bet\",\n" +
                    "\t\"lastname\": \"Agui\",\n" +
                    "\t\"phone\": \"+584147123022\",\n" +
                    "\t\"email\": \"email@email.com\",\n" +
                    "\t\"comment\": \"comment\"\n" +
                    "}";
        try {
            this.latestResponse = this.executePost(json);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Then("the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of_200(int statusCode) {
        final HttpStatus currentStatusCode = latestResponse.getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @When("the client post a comment with invalid phone")
    public void post_comment_invalid_phone() {
        try {
            String json = "{\n" +
                    "\t\"firstname\": \"Bet\",\n" +
                    "\t\"lastname\": \"Agui\",\n" +
                    "\t\"phone\": \"+9123456789\",\n" +
                    "\t\"email\": \"email@email.com\",\n" +
                    "\t\"comment\": \"comment\"\n" +
                    "}";
            this.latestResponse = this.executePost(json);
        } catch (IOException e) {
            System.out.println("error posting a comment");;
        }
    }

    @And("the client receives an error {string}")
    public void invalid_number(String error) {
        final Object body = latestResponse.getBody();
        assertThat("status code is incorrect : " + latestResponse.getBody(), body, is(error));
    }
}
