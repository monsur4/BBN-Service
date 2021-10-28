package com.mon.bbn;

import com.mon.bbn.model.Contestant;
import org.json.JSONArray;
import org.json.JSONException;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContestantControllerTests {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    private static Contestant testContestant;

    @BeforeAll
    public static void init(){
        testContestant = new Contestant("TestName4", 55, Contestant.Sex.MALE, 79, 43,
                Contestant.Status.PROBATION, "Testing bio4", false, "test_tag4", "test_state4",
                "https://cloudinary.test.image1");
    }

    @Test
    @Order(1)
    public void shouldPassIfNewContestantIsCreated(){
        ResponseEntity<Contestant> result
                = restTemplate.postForEntity(generateUrl("api/contestants"), testContestant, Contestant.class);
        System.out.println(result.getStatusCode());
        System.out.println(result.getStatusCodeValue());
        System.out.println(result.getHeaders().getDate());
        Contestant resultContestant = result.getBody();

        Assert.notNull(resultContestant, "Result of post method is empty");
        testContestant.setId(resultContestant.getId());
    }

    @Test
    @Order(2)
    public void shouldPassIfContestantNameExistsById(){
        Contestant resultContestant = restTemplate
                .getForObject(generateUrl("api/contestants/id/" + testContestant.getId()), Contestant.class);
        System.out.println(resultContestant.toString());
        assert(resultContestant.getName()).equals(testContestant.getName());
    }

    @Test
    @Order(3)
    public void shouldPassIfContestantNameExistsByTag(){
        Contestant resultContestant = restTemplate
                .getForObject(generateUrl("api/contestants/tag/" + testContestant.getTag()), Contestant.class);
        System.out.println(resultContestant.toString());
        assert(resultContestant.getName()).equals(testContestant.getName());
    }

    @Test
    @Order(4)
    public void shouldPassIfListOfContestantsIsReturned() throws JSONException {
        String allContestants = restTemplate.getForObject(generateUrl("api/contestants"), String.class);
        JSONArray jsonArray = new JSONArray(allContestants);
        Assert.notNull(jsonArray, "Array is null.");
    }

    @Test
    @Order(5)
    public void shouldPassIfContestantDetailsIsUpdate(){
        Contestant  test
                = restTemplate.getForObject(generateUrl("api/contestants/tag/" + testContestant.getTag()), Contestant.class);
        Contestant updatedContestantDetails = updateContestantDetails(test);
        restTemplate.put(generateUrl("api/contestants/id/" + testContestant.getId()), updatedContestantDetails);
        Contestant updatedContestant
                = restTemplate.getForObject(generateUrl("api/contestants/id/" + testContestant.getId()), Contestant.class);
        System.out.println(updatedContestant.toString());
        Assert.isTrue(!updatedContestant.getName().equals(testContestant.getName()), "Contestant Not Updated");
    }

    @Test
    @Order(6)
    public void shouldPassIfContestantIsDeleted(){
        Contestant contestantToDelete
                = restTemplate.getForObject(generateUrl("api/contestants/id/" + testContestant.getId()), Contestant.class);
        System.out.println(contestantToDelete.toString());
        restTemplate.delete(generateUrl("api/contestants/id/" + contestantToDelete.getId()));
        String response = restTemplate.getForObject(generateUrl("api/contestants"), String.class);
        Assert.doesNotContain(response, contestantToDelete.getId(), "Contestant not deleted");
    }

    private String generateUrl(String path){
        return "http://localhost:" + port + "/" +path;
    }

    private Contestant updateContestantDetails(Contestant contestant){
        contestant.setName("testNameUpdate");
        contestant.setTag("testTagUpdate");
        contestant.setState("testStateUpdate");
        contestant.setStatus(Contestant.Status.ACTIVE);
        return contestant;
    }
}
