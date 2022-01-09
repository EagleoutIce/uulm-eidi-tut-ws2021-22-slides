public class Taxi {
    private final double basicCharge;
    private final double kilometerPrice;
    private final double fuelConsumption;
    private final double fueltankCapacity;

    private double remainingFuel;
    private double taxometer;
    private double totalEarnings;

    public Taxi(double basicCharge, double kilometerPrice, double fuelConsumption, double fueltankCapacity) {
        this.basicCharge = basicCharge;
        this.kilometerPrice = kilometerPrice;
        this.fuelConsumption = fuelConsumption;
        this.fueltankCapacity = fueltankCapacity;

        this.remainingFuel = fueltankCapacity;
        this.taxometer = 0.0;
        this.totalEarnings = 0.0;
    }

    public double drive(double distance) {
        double requiredFuel = distance * fuelConsumption / 100;
        // Wir können die Kapazität zur Sicherheit prüfen. theoretisch sollte die Klasse
        // aber den zweiten Teil der Anweisung implizit gewährleisten.
        if (this.remainingFuel < requiredFuel || this.fueltankCapacity < requiredFuel)
            return -1;

        this.remainingFuel -= requiredFuel;
        this.taxometer += basicCharge + distance * kilometerPrice;

        return taxometer;
    }

    // großzügiges Rundungsfehler ignorieren
    public boolean pay(double amount) {
        if (amount < taxometer)
            return false;
        else if (amount > taxometer)
            System.out.format("Received %.2f€ tip%n", amount - taxometer);

        taxometer = 0.0;
        totalEarnings += amount;
        return true;
    }

    public void refill(double pricePerLitre) {
        double refill = Math.min(this.totalEarnings / pricePerLitre, this.fueltankCapacity - this.remainingFuel);

        this.remainingFuel += refill;
        this.totalEarnings -= refill * pricePerLitre;
    }

    public static void main(String[] args) {
        Taxi taxi = new Taxi(3, 0.5, 10, 50);
        double totalCost = taxi.drive(250);

        if (totalCost == -1)
            System.out.println("Not enough fuel left");
        else
            System.out.println("Trip costs " + totalCost);

        if (taxi.pay(totalCost + 3.00))
            System.out.println("Tipped 3,00€");

        totalCost = taxi.drive(450);
        if (totalCost == -1)
            System.out.println("Not enough fuel left");

        taxi.refill(1.7);

        totalCost = taxi.drive(450);
        if (totalCost == -1)
            System.out.println("Not enough fuel left");
        else
            System.out.println("Trip costs " + totalCost);

    }
}
