import java.util.ArrayList;
import java.util.List;

public class Dealership {

  // NÃO MODIFIQUE ESTA CLASSE!!!!!!!

  private static final Integer NUM_OBJECTS = 1_000_000;
  private static List<Object> carList = new ArrayList<>(NUM_OBJECTS);

  public static long memoryTest(boolean withFlyweight) {
    carList.clear();
    Runtime runtime = Runtime.getRuntime();

    runtime.gc(); // Força coleta de lixo antes do teste

    try {
      Thread.sleep(100); // Dá um tempo pro GC trabalhar
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    long previousMemory = runtime.totalMemory() - runtime.freeMemory();

    if (withFlyweight) {
      runWithFlywieght();
    } else {
      runWithoutFlyweight();
    }

    runtime.gc(); // Força coleta de lixo depois da criação

    try {
      Thread.sleep(100); // Espera novamente
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    long afterMemory = runtime.totalMemory() - runtime.freeMemory();

    return (afterMemory - previousMemory) / (1024 * 1024); // Retorna em MB
  }

  public static void runWithoutFlyweight() {
    for (int i = 0; i < NUM_OBJECTS; i++) {
      carList.add(new CompleteCar("Modelo" + (i % 10))); // Cria novos objetos mesmo com tipos repetidos
    }
  }

  public static void runWithFlywieght() {
    for (int i = 0; i < NUM_OBJECTS; i++) {
      carList.add(new Car(CarFactory.getCharacterType("Modelo" + (i % 10)))); // Reutiliza objetos do mesmo tipo
    }
  }
}


