package Test_Task.DrivingLicense;

import Test_Task.PersonData.*;
import Test_Task.UniversalCard;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class DrivingLicense extends PersonData{

    static File currentDirFile = new File("logging.properties");
    static String helper = currentDirFile.getAbsolutePath();
    private static Logger log = Logger.getLogger(DrivingLicense.class.getName());

    static {
        try(FileInputStream ins = new FileInputStream(helper)){ //полный путь до файла с конфигами
            LogManager.getLogManager().readConfiguration(ins);
            log = Logger.getLogger(UniversalCard.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    private String Category;
    private Calendar TimeOfAction = Calendar.getInstance();;

    public DrivingLicense(String name, String lastName, String birthdayDate, String unicId,
                          String timeOfAction, String category)
            throws IllegalArgumentException{
        super(name, lastName, birthdayDate, unicId);
        Category = category;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            TimeOfAction.setTime(sdf.parse(timeOfAction));
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Exception: ", ex);
            throw new IllegalArgumentException("Wrong time of action type!");
        }
    }

    public String getCategory() {
        return Category;
    }

    @Override
    public String getString() {
        return "Action date: "+ TimeOfAction.getTime() + ". Category " + Category + ".";
    }
}
