package Test_Task;

import java.util.logging.*;


/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     *
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        UniversalCard uc = new UniversalCard("Anonim", "Anonim", "20.02.2010");
        uc.addCreditCard("Ade2", "23.02.2009", "18.05.2007", 243);
        uc.addCreditCard("de2", "23.02.2009", "18.05.2007", 233);
        uc.addCreditCard("Ae2", "23.02.2009", "18.05.2007", 223);
        uc.addCreditCard("Ade2", "23.02.2009", "18.05.2007", 243);

        uc.createPassport("Add", "22.02.2002");
        uc.createPassport("rec", "23.04.2001");

        uc.addDrivingLicense("E", "22.03.2004", "A");
        uc.addDrivingLicense("fA", "22.03.2004", "B");
        uc.addDrivingLicense("fDc21", "22.03.2004", "C");
        uc.addDrivingLicense("fDC21", "22.02.2004", "C");

        uc.addInsurancePolicy("Tye", "23.08.2005", "G");
        uc.addInsurancePolicy("Tee", "23.08.2008", "L");
        uc.addInsurancePolicy("Tee", "23.08.2008", "L");

        uc.getCreditCard(1);
        uc.getInsurancePolicy(1);
        uc.getDrivingLicense(1);

        uc.getCreditCard("rec");
        uc.getInsurancePolicy("Tee");
        uc.getDrivingLicense("fA");

        uc.getPassport();
        uc.getCreditCards();
        uc.getDrivingLicenses();
        uc.getInsurancePolicies();

    }
}
