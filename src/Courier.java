public class Courier {
    private final String uniqueID;
    private double weight;
    private String packageName;
    private static String courierName;

    public static String getCourierNAme() {
        return Courier.courierName;
    }

    public static void setCourierName(String courierName) {
        Courier.courierName = courierName;

    }

    public String getPackageName() {
        return this.packageName;
    }

    public Courier(String uniqueID, double weight, String packageName) {
        this.uniqueID = uniqueID;
        this.weight = weight;
        this.packageName = packageName;

    }

    public Courier(String uniqueID) {
        this.uniqueID = uniqueID;
    }

    public void addItem(double itemWeight) {
        this.weight += itemWeight;

    }

    private boolean condOne() {
        boolean check = false;
        for (int i = 0; i < this.uniqueID.length(); i++) {
            if (Character.isDigit(this.uniqueID.charAt(i)) == false) {
                check = true;
            }
        }
        if (check) {
            return true;
        } else
            return false;
    }

    private boolean condTwo() {
        int contor = 0;
        for (int i = 0; i < this.uniqueID.length(); i++) {
            int index = Character.getNumericValue(uniqueID.charAt(i));
            if (index % 2 == 1) {
                contor++;
            }
        }
        return (contor % 3 == 0);
    }

    private boolean condThree() {
        int sum = 0;
        for (int i = 0; i < this.uniqueID.length(); i++) {
            int index = Character.getNumericValue(uniqueID.charAt(i));
            sum += index;
        }
        return (sum % 4 == 0);
    }

    private boolean condFour() {

        if (this.uniqueID.length() < 2){
            return true;
        }

        boolean check = false;
        int result = 0;
        for (int i = 0; i < this.uniqueID.length(); i++) {
            int index = Character.getNumericValue(this.uniqueID.charAt(i));
            int nextIndex = Character.getNumericValue(this.uniqueID.charAt(i + 1));

            result = index - nextIndex;
            if (result < 0) {
                result = result * (-1);
            }
        }
        return (result < 5);

    }


    private boolean condFive() {
        return (this.uniqueID.length() >= 10 && this.uniqueID.length() <= 12);
    }

    public boolean checkID() {
        return this.condOne() && this.condTwo() && this.condThree() && this.condFour() && this.condFive();
    }

    public String computeDetails() {
        String str = "Pachetul " + this.packageName + " avand codul " + this.uniqueID + " si greutatea "
                + this.weight + " apartine curierului " + Courier.courierName + ".";
        return str;
    }

}
