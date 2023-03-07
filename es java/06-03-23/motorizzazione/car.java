package motorizzazione;


class Vehicle {
    protected String brand = "Ford";
    public void honk() {
        System.out.println("honkuhuyf");
    }
}

 class car extends Vehicle {
    private String modelName = "Fiat";
    public static void main(String[] args) {
        car myCar = new car();
        myCar.honk();
        System.out.println(myCar.brand + ""+ myCar.modelName);
    }
}
