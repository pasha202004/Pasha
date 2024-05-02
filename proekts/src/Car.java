public class Car {
    private String model;
    private double pricePerHour;
    private char typeOfTransmission;
    private String typeOfFuel;


    public Car(String model, double pricePerHour, char typeOfTransmission, String typeOfFuel) {
        this.model = model;
        this.pricePerHour = pricePerHour;
        this.typeOfTransmission = typeOfTransmission;
        this.typeOfFuel = typeOfFuel;
    }

    @Override
    public String toString() {
        String strTransmission = "";
        switch (typeOfTransmission) {
            case 'A':
                strTransmission = "automāts";
                break;
            case 'B':
                strTransmission = "mehanika";
                break;
            default:
                break;

        }

        return "Automašīnas modelis: " + model + "\n" +
                "Cena par stundu: " + pricePerHour + " EUR\n" +
                "Pārnešana veids: " + strTransmission + "\n" +
                "Degvielas veids: " + typeOfFuel + "\n";
    }

    public String getModelAndPrice() {
        return model+" "+pricePerHour+" EUR/h";
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public char typeOfTransmission() {
        return typeOfTransmission;
    }

    public void typeOfTransmission(char typeOfTransmission) {
        this.typeOfTransmission = typeOfTransmission;
    }

    public String getTypeOfFuel() {
        return typeOfFuel;
    }

    public void setTypeOfFuel(String typeOfFuel) {
        this.typeOfFuel = typeOfFuel;
    }
}
