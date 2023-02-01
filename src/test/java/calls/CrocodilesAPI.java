package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndPoints;
import data.model.*;


public class CrocodilesAPI {

    public static LoginResponse login(LoginRequest loginRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndPoints.LOGIN, loginRequest), LoginResponse.class);
    }

    public static CreateCrocodileResponse createNewCrocodile(String accessToken, CreateCrocodileRequest createCrocodileRequest) {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(accessToken, ApiEndPoints.CROCODILES, createCrocodileRequest), CreateCrocodileResponse.class);
    }

    public static GetPublicCrocodileResponse[] getPublicCrocodileResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndPoints.PUBLIC_CROCODILE), GetPublicCrocodileResponse[].class);
    }
    public static CreateCrocodileResponse getOneCrocodile(String accessToken, Integer id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(accessToken, ApiEndPoints.SINGLE_CROCODILE(String.valueOf(id))),CreateCrocodileResponse.class );
    }

    public static CreateCrocodileResponse updateCrocodile(String accessToken, CreateCrocodileRequest request, Integer id ){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(accessToken, request, ApiEndPoints.SINGLE_CROCODILE(String.valueOf(id))), CreateCrocodileResponse.class);

    }
    public static CreateCrocodileResponse updateSelectedFiled(String accessToken, CreateCrocodileRequest request, Integer id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch(accessToken, request, ApiEndPoints.SINGLE_CROCODILE(String.valueOf(id))), CreateCrocodileResponse.class);
    }

    public static CreateCrocodileResponse deleteCrocodile(String accessToken,Integer id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(accessToken, ApiEndPoints.SINGLE_CROCODILE(String.valueOf(id))), CreateCrocodileResponse.class);
    }

    public static GetPublicCrocodileResponse[] getAllCrocodiles(String accessToken){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.getAll(accessToken, ApiEndPoints.CROCODILES), GetPublicCrocodileResponse[].class);
    }
}
