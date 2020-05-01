package Test_Task;

import Test_Task.CreditCard.CreditCard;
import Test_Task.DrivingLicense.DrivingLicense;
import Test_Task.InsurancePolicy.InsurancePolicy;
import Test_Task.Passport.Passport;
import Test_Task.PersonData.PersonData;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.Level;



public class UniversalCard {

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


    private String Name;
    private String LastName;
    private String BirthdayDate;

    public UniversalCard(String name, String lastName, String birthdayDate){
        Name = name;
        LastName = lastName;
        BirthdayDate = birthdayDate;
    }

    private Passport passport = null;
    private ArrayList<DrivingLicense> drivingLicenses = new ArrayList<DrivingLicense>();
    private ArrayList<CreditCard> creditCards = new ArrayList<CreditCard>();
    private ArrayList<InsurancePolicy> insurancePolicies = new ArrayList<InsurancePolicy>();

    public void createPassport(String unicId, String dateOfIssue){
        if (passport == null){
            passport = new Passport(Name, LastName, BirthdayDate, unicId, dateOfIssue);
            log.info("Passport created");
        } else {
            log.warning("Attempt to create new passport");
        }
    }
    public String getPassportString(){
        return  passport.getString();
    }

    public Passport getPassport() {
        return passport;
    }

    /*
     * From the very beginning there should have been a collection,
     * but i don't know how to bring the ArrayList<Child> to the ArrayList<Parent>
     */
    private boolean isEqual(PersonData item, String id){
        if (item.getUnicId().equals(id)) return true;
        return false;
    }

    public void addDrivingLicense(String unicId, String timeOfAction, String category){
        // Search copy in collection
        boolean flag = false;
        for (DrivingLicense item: drivingLicenses) {
            if (isEqual(item, unicId)) {
                flag = true;
                break;
            }
        }

        if (!flag){
            drivingLicenses.add(new DrivingLicense(Name, LastName, BirthdayDate, unicId, timeOfAction, category));
            log.info("Driving license added");
        } else {
            log.warning("Driving license is not added");
        }
    }

    public DrivingLicense getDrivingLicense(String unicId){
        for (DrivingLicense item: drivingLicenses) {
            if (isEqual(item, unicId)) {
                log.info("Insurance policy found (for unicId)");
                return item;
            }
        }
        log.warning("Insurance policy is not found (for unicId)");
        return null;
    }

    public DrivingLicense getDrivingLicense(int index) {
        if (index < drivingLicenses.size()) {
            log.info("Credit card found (for index)");
            return drivingLicenses.get(index);
        }
        else {
            log.warning("Credit card is not found (for index)");
            return null;
        }
    }

    public ArrayList<DrivingLicense> getDrivingLicenses(){
        return drivingLicenses;
    }

    public void addCreditCard(String unicId, String actionDate, String dateOfIssue, int secretCode){
        // Search copy in collection
        boolean flag = false;
        for (CreditCard item: creditCards) {
            if (isEqual(item, unicId)) {
                flag = true;
                break;
            }
        }

        if (!flag){
            creditCards.add(new CreditCard(Name, LastName, BirthdayDate, unicId, actionDate, dateOfIssue, secretCode));
            log.info("Credit card added");
        } else {
            log.warning("Credit card is not added");
        }
    }

    public CreditCard getCreditCard(String unicId){
        for (CreditCard item: creditCards) {
            if (isEqual(item, unicId)) {
                log.info("Insurance policy found (for unicId)");
                return item;
            }
        }
        log.warning("Insurance policy is not found (for unicId)");
        return null;
    }
    public CreditCard getCreditCard(int index) {
        if (index < creditCards.size()) {
            log.info("Credit card found (for index)");
            return creditCards.get(index);
        }
        else {
            log.warning("Credit card is not found (for index)");
            return null;
        }
    }

    public ArrayList<CreditCard> getCreditCards(){
        return creditCards;
    }

    public void addInsurancePolicy(String unicId, String dateOfIssue, String category){
        boolean flag = false;
        for (InsurancePolicy item: insurancePolicies) {
            if (isEqual(item, unicId)) {
                flag = true;
                break;
            }
        }

        if (!flag){
            insurancePolicies.add(new InsurancePolicy(Name, LastName, BirthdayDate, unicId, category, dateOfIssue));
            log.info("Insurance policy added");
        }
        else {
            log.warning("Insurance policy is not added");
        }
    }

    public InsurancePolicy getInsurancePolicy(String unicId){
        for (InsurancePolicy item: insurancePolicies) {
            if (isEqual(item, unicId)) {
                    log.info("Insurance policy found (for unicId)");
                    return item;
                }
            }
        log.warning("Insurance policy not found (for unicId)");
        return null;
    }

    public InsurancePolicy getInsurancePolicy(int index) {
        if (index < insurancePolicies.size()){
                log.info("Insurance policy found (for index)");
                return insurancePolicies.get(index);
            }
            else {
                log.warning("Insurance policy not found (for index)");
                return null;
            }
    }

    public ArrayList<InsurancePolicy> getInsurancePolicies(){
        return insurancePolicies;
    }

}
