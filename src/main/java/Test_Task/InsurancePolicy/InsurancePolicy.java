package Test_Task.InsurancePolicy;

import Test_Task.DrivingLicense.DrivingLicense;
import Test_Task.PersonData.*;
import Test_Task.UniversalCard;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class InsurancePolicy extends PersonData {

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
    private Calendar DateOfIssue = Calendar.getInstance();;

    public InsurancePolicy(String name, String lastName, String birthdayDate, String unicId,
                           String category, String dateOfIssue) {
        super(name, lastName, birthdayDate, unicId);
        Category = category;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            DateOfIssue.setTime(sdf.parse(dateOfIssue));
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Exception: ", ex);
            throw new IllegalArgumentException("Wrong date type!");
        }
    }

    public String getCategory() {
        return Category;
    }

    public Calendar getDateOfIssue() {
        return DateOfIssue;
    }

    @Override
    public String getString() {
        return "Driving category: " + Category+". Date of issue: " + DateOfIssue.getTime();
    }
}
