abstract class MedicalService {
    String serviceID;
    String serviceName;
    double baseCost;

    public MedicalService(String serviceID, String serviceName, double baseCost) {
        this.serviceID = serviceID;
        this.serviceName = serviceName;
        this.baseCost = baseCost;
    }

    public abstract double calculateTotalCost();

    public void displayServiceInfo() {
        System.out.println("Service ID: " + serviceID);
        System.out.println("Service: " + serviceName);
        System.out.printf("Total Cost: $%.2f%n",
                calculateTotalCost());
        System.out.println();
    }
}

class Consultation extends MedicalService {
    double doctorFee;

    public Consultation(String id, double baseCost, double doctorFee) {
        super(id, "Consultation", baseCost);
        this.doctorFee = doctorFee;
    }

    @Override
    public double calculateTotalCost() {
        return baseCost + doctorFee;
    }
}

class LaboratoryTest extends MedicalService {
    double testCharge;

    public LaboratoryTest(String id, double baseCost, double testCharge) {
        super(id, "Laboratory Test", baseCost);
        this.testCharge = testCharge;
    }

    @Override
    public double calculateTotalCost() {
        return baseCost + testCharge;
    }
}

class Ultrasound extends MedicalService {
    double additionalFee;

    public Ultrasound(String id, double baseCost, double additionalFee) {
        super(id, "Ultrasound", baseCost);
        this.additionalFee = additionalFee;
    }

    @Override
    public double calculateTotalCost() {
        return baseCost + additionalFee;
    }
}

public class HospitalMedicalBilling {
    public static void main(String[] args) {

        MedicalService[] services = {
                new Consultation("S1", 15, 10),
                new LaboratoryTest("S2", 10, 8),
                new Ultrasound("S3", 30, 10)
        };

        double totalBill = 0;

        System.out.println("HOSPITAL BILLING SYSTEM");
        System.out.println();

        for (MedicalService service : services) {
            service.displayServiceInfo();
            totalBill += service.calculateTotalCost();
        }


        System.out.printf("Total Hospital Bill: $%.2f%n",
                totalBill);
    }
}