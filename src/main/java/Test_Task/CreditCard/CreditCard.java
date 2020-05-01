package Test_Task.CreditCard;

import Test_Task.PersonData.*;
import Test_Task.UniversalCard;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CreditCard extends PersonData {

    static File currentDirFile = new File("logging.properties");
    static String helper = currentDirFile.getAbsolutePath();

    private static Logger log = Logger.getLogger(CreditCard.class.getName());

    static {
        try(FileInputStream ins = new FileInputStream(helper)){ //полный путь до файла с конфигами
            LogManager.getLogManager().readConfiguration(ins);
            log = Logger.getLogger(UniversalCard.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    private Calendar ActionDate = Calendar.getInstance();
    private Calendar DateOfIssue = Calendar.getInstance();
    private int SecretCode;
    private double Balance = 0;

    public CreditCard(String name, String lastName, String birthdayDate, String unicId,
                      String actionDate, String dateOfIssue, int secretCode) throws IllegalArgumentException{
        super(name, lastName, birthdayDate, unicId);
        SecretCode = secretCode;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            ActionDate.setTime(sdf.parse(actionDate));
        } catch (Exception ex) {
            log.log(Level.SEVERE, "Exception: ", ex);
            throw new IllegalArgumentException("Wrong date type!");
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            DateOfIssue.setTime(sdf.parse(dateOfIssue));
        } catch (Exception e) {
            log.log(Level.SEVERE, "Exception: ", e);
            throw new IllegalArgumentException("Wrong date type!");
        }

    }

    public void addMoney(double money){
        Balance+=money;
    }

    public void withdrawMoney(double money){
        if (Balance - money >= 0) {
            Balance -= money;
            return;
        }
    }
    public double getBalance(){
        return Balance;
    }

    public Calendar getDateOfIssue() {
        return DateOfIssue;
    }

    public Calendar getActionDate() {
        return ActionDate;
    }

    @Override
    public String getString() {
        return "Date of issue: " + DateOfIssue + ". Date action: " + ActionDate + ". Balance: " + Balance;
    }

}
