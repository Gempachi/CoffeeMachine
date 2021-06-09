import java.util.Scanner;

public class CoffeMaker {
    private int baseWater;
    private int baseMilk;
    private int baseBeans;
    private int numberOfCups;
    private int money;

    static Scanner scanner = new Scanner(System.in);

    public CoffeMaker(int baseWater, int baseMilk, int baseBeans, int numberOfCups, int money){
        this.baseWater = baseWater;
        this.baseMilk = baseMilk;
        this.baseBeans = baseBeans;
        this.numberOfCups = numberOfCups;
        this.money = money;
    }

    public int getBaseWater() {
        return this.baseWater;
    }

    public int getBaseMilk() {
        return this.baseMilk;
    }

    public int getBaseBeans() {
        return this.baseBeans;
    }

    public int getNumberOfCups() {
        return this.numberOfCups;
    }

    public int getMoney() {
        return this.money;
    }



    private void takeMoney(){
        money = 0;
    }

    private void fillWater(int water){
        baseWater += water;
    }
    private void fillMilk(int milk){
        baseMilk += milk;
    }
    private void fillBeans(int beans){
        baseBeans += beans;
    }
    private void fillCups(int cups){
       numberOfCups += cups;
    }


    private void lossWater(int water){
        baseWater -= water;
    }

    private void lossMilk(int milk){
        baseMilk -= milk;
    }
    private void lossBeans(int beans){
        baseBeans -= beans;
    }
    private void lossCups(){
        numberOfCups--;
    }
    private void addMoney(int addMoney){
        money += addMoney;
    }

    public void action(String command){
        switch (command) {
            case "buy":
                buy();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            case "remaining":
                printIngredients();
                break;
            case "exit":
                break;
            default:
                System.out.println("Unexpected action.");
        }
    }


    public void buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:: ");

        switch (scanner.next()){
            case "1":
                if ( getBaseWater()>=250 && getBaseBeans() >= 16 && getNumberOfCups() > 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    buyBeverage(250,0,16,4);
                }else if(getBaseWater() < 250){
                    System.out.println("Sorry, not enough water!");
                }else if( getBaseBeans() < 15){
                    System.out.println("Sorry, not enough coffee!");
                }else if( getNumberOfCups() == 0){
                    System.out.println("Sorry, not enough cup!");
                }
                break;
            case "2":
                if (getBaseWater() >=350 && getBaseMilk() >= 75 &&getBaseBeans() >= 20 && getNumberOfCups() > 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    buyBeverage(350,75,20,7);
                }else if(getBaseWater() < 350){
                    System.out.println("Sorry, not enough water!");
                }else if(getBaseMilk() < 75){
                    System.out.println("Sorry, not enough milk!");
                }else if( getBaseBeans() < 20){
                    System.out.println("Sorry, not enough coffee!");
                }else if( getNumberOfCups() == 0){
                    System.out.println("Sorry, not enough cup!");
                }
                break;
            case "3":
                if (getBaseWater() >=200 && getBaseMilk() >= 100 && getBaseBeans() >= 12 && getNumberOfCups() > 1) {
                    System.out.println("I have enough resources, making you a coffee!");
                    buyBeverage(200,100,12,6);
                }else if(getBaseWater() < 200){
                    System.out.println("Sorry, not enough water!");
                }else if(getBaseMilk() < 100){
                    System.out.println("Sorry, not enough milk!");
                }else if( getBaseBeans() < 12){
                    System.out.println("Sorry, not enough coffee!");
                }else if( getNumberOfCups() == 0){
                    System.out.println("Sorry, not enough cup!");
                }
                break;
            default:
                System.out.println("Try again, error.");
        }

        //For the espresso, the coffee machine needs 250 ml of water and 16 g of coffee beans. It costs $4.
        //For the latte, the coffee machine needs 350 ml of water, 75 ml of milk, and 20 g of coffee beans. It costs $7.
        //And for the cappuccino, the coffee machine needs 200 ml of water, 100 ml of milk, and 12 g of coffee beans. It costs $6.
    }
    private void buyBeverage(int waterLoss, int milkLoss, int coffeeLoss, int moneyEarned) {
        lossWater(waterLoss);
        lossMilk(milkLoss);
        lossBeans(coffeeLoss);
        lossCups();
        addMoney(moneyEarned);
    }
    public  void printIngredients(){
        System.out.println("The coffee machine has: ");
        System.out.println(getBaseWater() +" ml of water");
        System.out.println(baseMilk+" ml of milk");
        System.out.println(baseBeans +" g of coffee beans");
        System.out.println(numberOfCups +" disposable cups");
        System.out.println("$"+money+" of money\n\n");
    }
    public void fill(){

        System.out.println("Write how many ml of water you want to add:  ");
        fillWater(scanner.nextInt());
        System.out.println("Write how many ml of milk you want to add:  ");
        fillMilk(scanner.nextInt());
        System.out.println("Write how many grams of coffee beans you want to add:   ");
        fillBeans(scanner.nextInt());
        System.out.println("Write how many disposable cups of coffee you want to add:    ");
        fillCups(scanner.nextInt());



    }
    public void take(){

        System.out.println("I gave you "+getMoney() +"$");
        int money = getMoney();
        takeMoney();


    }
}
