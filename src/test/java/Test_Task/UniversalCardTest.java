package Test_Task;

import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.logging.Level;

import static org.junit.Assert.*;

import Test_Task.DrivingLicense.*;
import Test_Task.CreditCard.*;
import Test_Task.InsurancePolicy.*;
import Test_Task.Passport.*;


public class UniversalCardTest {

    private UniversalCard uc;
    private Calendar calDate = Calendar.getInstance();
    private String date ="01.01.1001";
    private String Name = "Name";
    private String LastName = "LastName";

    @Before
    public void setUp() throws Exception {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            calDate.setTime(sdf.parse(date));
        } catch (Exception ex) {
        }

        uc = new UniversalCard("Name", "LastName", date);

    }

    @Test
    public void createPassport() {

        uc.createPassport("passport", date);
        assertEquals(uc.getPassport().getUnicId(), "passport");
        assertEquals(uc.getPassport().getName(), "Name");
        assertEquals(uc.getPassport().getLastName(), "LastName");
        assertEquals(uc.getPassport().getDateOfIssue(), calDate);
    }

    @Test
    public void addDrivingLicense() {
        uc.addDrivingLicense("driving", "02.02.2002", "A");
        assertEquals(uc.getDrivingLicense("driving").getString(),
            new DrivingLicense(Name, LastName, date, "driving", "02.02.2002", "A").getString());
    }

    @Test
    public void getPassport() {
        uc.createPassport("passport", date);
        assertEquals(uc.getPassport().getString(), new Passport(Name, LastName, date, "passport", date).getString());

    }

    @Test
    public void addCreditCard() {
        uc.addCreditCard("credit", "02.02.2002", "02.02.2004", 123);
        assertEquals(uc.getCreditCard("credit").getString(),
            new CreditCard(Name, LastName, date,
                "driving", "02.02.2002", "02.02.2004", 123).getString());
        assertEquals(uc.getCreditCard(0).getString(),
            new CreditCard(Name, LastName, date,
                "driving", "02.02.2002", "02.02.2004", 123).getString());


    }

    @Test
    public void getCreditCard() {
        uc.addCreditCard("credit", "02.02.2002", "02.02.2004", 123);
        assertEquals(uc.getCreditCard("credit").getString(),
            new CreditCard(Name, LastName, date,
                "driving", "02.02.2002", "02.02.2004", 123).getString());
        assertEquals(uc.getCreditCard(0).getString(),
            new CreditCard(Name, LastName, date,
                "driving", "02.02.2002", "02.02.2004", 123).getString());
    }

    @Test
    public void addInsurancePolicy() {

        uc.addInsurancePolicy("policy", "02.02.2002",  "Middle");
        assertEquals(uc.getInsurancePolicy("policy").getString(),
            new InsurancePolicy(Name, LastName, date,
                "policy", "Middle", "02.02.2002").getString());
        assertEquals(uc.getInsurancePolicy(0).getString(),
            new InsurancePolicy(Name, LastName, date,
                "policy", "Middle", "02.02.2002").getString());
    }

}
