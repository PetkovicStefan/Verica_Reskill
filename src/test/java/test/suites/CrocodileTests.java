package test.suites;

import calls.CrocodilesAPI;
import common.ValueChooser;
import data.model.CreateCrocodileRequest;
import data.model.CreateCrocodileResponse;
import data.model.GetPublicCrocodileResponse;
import data.provider.CrocodileProvider;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;

public class CrocodileTests extends TestBase {


    CreateCrocodileRequest crocodileRequest;
    Integer crocodileId;
    CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @BeforeMethod
    public void prepareTestData() {
        crocodileRequest = CrocodileProvider.prepareCrocodileRequest();
        crocodileId = CrocodilesAPI.createNewCrocodile(accessToken,crocodileRequest).getId();
    }


    @Test
    public void loginTest() {
        Assert.assertFalse(accessToken.isEmpty(), "Access token is empty");
    }

    @Test
    @Description("verify crocodile is created")
    public void createCrocodileTest() {

        CreateCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken,crocodileRequest);

        crocodileAsserts.assertCreateNewCrocodile(createCrocodileResponse, crocodileRequest);
    }

    @Test
    @Description("Get list of all crocodiles")
    public void getListOfPublicCrocodiles() {
        GetPublicCrocodileResponse[] getPublicCrocodileResponse = CrocodilesAPI.getPublicCrocodileResponse();
        crocodileAsserts.assertListOfPublicCrocodiles(getPublicCrocodileResponse);
    }

    @Test
    @Description("Verify getting one crocodile")
    public void getOneCrocodileTest(){
        CreateCrocodileResponse createCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, crocodileRequest);
        Integer id= createCrocodileResponse.getId();
        CreateCrocodileResponse actualCrocodile = CrocodilesAPI.getOneCrocodile(accessToken, id);
        //Prepare expected
        CreateCrocodileResponse expectedCrocodileResponse = new CreateCrocodileResponse(id, crocodileRequest.getName(), crocodileRequest.getSex(),
                crocodileRequest.getDateOfBirth(), createCrocodileResponse.getAge());
        //Verify expected and actual
        CrocodileAsserts crocodileAsserts1 = new CrocodileAsserts();
        crocodileAsserts1.assertCrocodileData(actualCrocodile,expectedCrocodileResponse);
    }


    @Test
    @Description("Update crocodile test")
    public void updateCrocodileTest(){

        CreateCrocodileResponse createdCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, crocodileRequest);
        Integer crocodileId= createdCrocodileResponse.getId();
        //Update crocodile
        CreateCrocodileRequest updatedCrocodileRequest = CrocodileProvider.prepareCrocodileRequest();
        CreateCrocodileResponse updatedCrocodile = CrocodilesAPI.updateCrocodile(accessToken, updatedCrocodileRequest, crocodileId);

        //prepare expected data
        CreateCrocodileResponse expectedCrocodile = new CreateCrocodileResponse(createdCrocodileResponse.getId(), updatedCrocodile.getName(),
                updatedCrocodile.getSex(), updatedCrocodile.getDateOfBirth(), 2);

        //verify actual and expected
        CrocodileAsserts crocodileAsserts2 = new CrocodileAsserts();
        crocodileAsserts2.assertCrocodileData(expectedCrocodile,updatedCrocodile);
    }

    @Test
    @Description("Update selected filed test")
    public void updateSelectedFiledTest(){

        CreateCrocodileResponse createdCrocodileResponse = CrocodilesAPI.createNewCrocodile(accessToken, crocodileRequest);
        Integer crocodileId= createdCrocodileResponse.getId();

        //Update filed
        String name1 = ValueChooser.getRandomName();
        crocodileRequest.setName(name1);
        CreateCrocodileResponse updateCrocodile = CrocodilesAPI.updateSelectedFiled(accessToken, crocodileRequest, crocodileId);

        //prepare expected
        CreateCrocodileResponse expectedCrocodile = new CreateCrocodileResponse(crocodileId, name1, crocodileRequest.getSex(),
                crocodileRequest.getDateOfBirth(), createdCrocodileResponse.getAge());

        //verify actual and expected
        CrocodileAsserts crocodileAsserts3 = new CrocodileAsserts();
        crocodileAsserts3.assertCrocodileData(expectedCrocodile, updateCrocodile);
    }

    @Test
    @Description("Verify delete crocodile")
    public void verifyDeleteCrocodileTest(){
        CreateCrocodileResponse deleteCrocodile = CrocodilesAPI.deleteCrocodile(accessToken, crocodileId);
        GetPublicCrocodileResponse[] restCrocodiles = CrocodilesAPI.getAllCrocodiles(accessToken);
        for (int i=0; i<restCrocodiles.length; i++){
            if(restCrocodiles[i].getId()==crocodileId){
                System.out.println("Crocodile with " + crocodileId + "is not deleted");
            }
        }
    }
}
