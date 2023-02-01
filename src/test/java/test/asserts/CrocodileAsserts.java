package test.asserts;

import data.model.CreateCrocodileRequest;
import data.model.CreateCrocodileResponse;
import data.model.GetPublicCrocodileResponse;
import org.testng.asserts.SoftAssert;

public class CrocodileAsserts {

    public SoftAssert softAssert = new SoftAssert();

    public void assertCreateNewCrocodile(CreateCrocodileResponse createCrocodileResponse, CreateCrocodileRequest createCrocodileRequest) {
        softAssert.assertEquals(createCrocodileResponse.getName(), createCrocodileRequest.getName(), "Name didn't match");
        softAssert.assertEquals(createCrocodileResponse.getDateOfBirth(), createCrocodileRequest.getDateOfBirth(), "date of birth didn't match");
        softAssert.assertEquals(createCrocodileResponse.getSex(), createCrocodileRequest.getSex(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertListOfPublicCrocodiles(GetPublicCrocodileResponse[] getPublicCrocodileResponse) {
        for(int i = 0; i < getPublicCrocodileResponse.length; i++) {
            softAssert.assertFalse(getPublicCrocodileResponse[i].getName().isEmpty(), "Name is not empty");
        }
        softAssert.assertAll();
    }

    public void assertCrocodileData(CreateCrocodileResponse actualCrocodile, CreateCrocodileResponse expectedCrocodileResponse){
        softAssert.assertEquals(actualCrocodile.getId(), expectedCrocodileResponse.getId());
        softAssert.assertEquals(actualCrocodile.getName(), expectedCrocodileResponse.getName());
        softAssert.assertEquals(actualCrocodile.getSex(), expectedCrocodileResponse.getSex());
        softAssert.assertEquals(actualCrocodile.getDateOfBirth(), expectedCrocodileResponse.getDateOfBirth());
        softAssert.assertEquals(actualCrocodile.getAge(), expectedCrocodileResponse.getAge());
        softAssert.assertAll();
}
}
