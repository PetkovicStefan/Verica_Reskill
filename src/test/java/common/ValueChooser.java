package common;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;

public class ValueChooser {

    public static String getRandomName() {
        ArrayList<String> listOfNames = new ArrayList<>();
        listOfNames.add("Marija");
        listOfNames.add("Nenad");
        listOfNames.add("Milos");
        listOfNames.add("Sanja");

        return listOfNames.get(RandomUtils.nextInt(0, listOfNames.size()));
    }

    public static String getRandomBirthday(){
        ArrayList<String> listOfBirthdays = new ArrayList<>();
        listOfBirthdays.add("2020-12-10");
        listOfBirthdays.add("2020-08-11");
        listOfBirthdays.add("2020-06-12");
        listOfBirthdays.add("2020-05-13");
        listOfBirthdays.add("2020-02-14");
        listOfBirthdays.add("2020-03-15");
        listOfBirthdays.add("2020-11-16");

        return listOfBirthdays.get(RandomUtils.nextInt(0, listOfBirthdays.size()));
    }


}
