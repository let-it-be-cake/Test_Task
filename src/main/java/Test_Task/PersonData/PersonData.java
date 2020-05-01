package Test_Task.PersonData;

import Test_Task.UniversalCard;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public abstract class PersonData {

    static File currentDirFile = new File("logging.properties");
    static String helper = currentDirFile.getAbsolutePath();

    private static Logger log = Logger.getLogger(UniversalCard.class.getName());

    static {
        try(FileInputStream ins = new FileInputStream(helper)){ //полный путь до файла с конфигами
            LogManager.getLogManager().readConfiguration(ins);
            log = Logger.getLogger(UniversalCard.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    private Calendar BirthdayDate = Calendar.getInstance();
    private String Name;
    private String LastName;

    private String UnicId;

    protected PersonData(){};
    protected PersonData(String name, String lastName, String birthdayDate, String unicId)  {
        IllegalArgumentException e = new IllegalArgumentException();
        if (name.length() != 0) Name = name;
        else {
            e = new IllegalArgumentException("Wrong name!");
            log.log(Level.SEVERE, "Exception: ", e);
            throw e;
        }

        if (lastName.length() !=0) LastName = lastName;
        else {
            e = new IllegalArgumentException("Wrong last name!");
            log.log(Level.SEVERE, "Exception: ", e);
            throw e;
        }

        if (unicId.length() !=0) UnicId = unicId;
        else {

            e = new IllegalArgumentException("Wrong unical id!");
            log.log(Level.SEVERE, "Exception: ", e);
            throw e;
        }


        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            BirthdayDate.setTime(sdf.parse(birthdayDate));
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Wrong date type: ", ex);
            throw new IllegalArgumentException("Wrong date type!");
        }

    };

    public String getName() {
        return Name;
    };

    public String getLastName() {
        return LastName;
    };

    public Calendar getBirthdayDate() {
        return BirthdayDate;
    };

    public String getUnicId(){return UnicId;};
    public abstract String getString();
}
