package Test_Task.Passport;

import Test_Task.PersonData.*;
import Test_Task.UniversalCard;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Passport extends PersonData {

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
    private String validity;
    private Calendar DateOfIssue = Calendar.getInstance();


//    String currentDir = helper.substring(0, helper.length() - currentDirFile.getCanonicalPath().length());

    public Passport(String name, String lastName, String birthdayDate, String unicId, String dateOfIssue){
        super(name, lastName, birthdayDate, unicId);

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            DateOfIssue.setTime(sdf.parse(dateOfIssue));
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Wrong date type: ", ex);
            throw new IllegalArgumentException("Wrong date type!");
        }
    }

    public Calendar getDateOfIssue(){
        return DateOfIssue;
    }

    @Override
    public String getString() {
        return "Name: " + getName() + ". Last name: "+ getLastName() +
            ". Birthday: "+getBirthdayDate().getTime() +". Date of Issue: " + DateOfIssue.getTime();
    }
}
