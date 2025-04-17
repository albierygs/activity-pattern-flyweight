public class Main {
  public static void main(String[] args) {

    // MODIFIQUE AS CLASSES Car, CarType, e CarFactory E DEPOIS EXECUTE ESTA CLASSE

    System.out.println("Executando sem Flyweight...");
    long memoryWithoutFlyweight = Dealership.memoryTest(false);
    System.out.println("Memória usada SEM Flyweight: " + memoryWithoutFlyweight + " MB");

    System.out.println("\nExecutando com Flyweight...");
    long memoryWithFlyweight = Dealership.memoryTest(true);
    System.out.println("Memória usada COM Flyweight: " + memoryWithFlyweight + " MB");

    if (memoryWithFlyweight >= memoryWithoutFlyweight) {
      System.out.println("\n\nResultado incorreto. Tente Novamente!");
    } else {
      System.out.println("\n\nParabéns, você conseguiu!");
    }
  }
}
