package data.model;

import java.io.Serializable;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateCrocodileRequest implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("date_of_birth")
    @Expose
    private String dateOfBirth;
    private final static long serialVersionUID = -976650914674967403L;

    public CreateCrocodileRequest() {
    }

    public CreateCrocodileRequest(String name, String sex, String dateOfBirth) {
        super();
        this.name = name;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
    return this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String setDateOfBirth(String dateOfBirth) {
       return this.dateOfBirth = dateOfBirth;
    }

}
