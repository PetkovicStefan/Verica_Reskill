package data.provider;

import common.ValueChooser;
import data.model.CreateCrocodileRequest;

public class CrocodileProvider {

    public static CreateCrocodileRequest prepareCrocodileRequest(){
        CreateCrocodileRequest crocodileRequest = new CreateCrocodileRequest();
        crocodileRequest.setName(ValueChooser.getRandomName());
        crocodileRequest.setSex("M");
        crocodileRequest.setDateOfBirth(ValueChooser.getRandomBirthday());

        return crocodileRequest;
    }
}
