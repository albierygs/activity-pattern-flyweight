import java.util.ArrayList;
import java.util.List;

public class Dealership {

  // NÃO MODIFIQUE ESTA CLASSE!!!!!!!

  private static final Integer NUM_OBJECTS = 1_000_000;
  private static List<Object> carList = new ArrayList<>(NUM_OBJECTS);

  public static long memoryTest(boolean withFlyweight) {
    carList.clear();
    Runtime runtime = Runtime.getRuntime();

    runGarbage(runtime);

    long previousMemory = calculateMemory(runtime);

    if (withFlyweight) {
      runWithFlywieght();
    } else {
      runWithoutFlyweight();
    }

    runGarbage(runtime);

    long afterMemory = calculateMemory(runtime);

    return (afterMemory - previousMemory) / (1024 * 1024);
  }

  private static void runGarbage(Runtime runtime) {
    runtime.gc();

    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private static long calculateMemory(Runtime runtime) {
    return runtime.totalMemory() - runtime.freeMemory();
  }

  public static void runWithoutFlyweight() {
    for (int i = 0; i < NUM_OBJECTS; i++) {
      carList.add(new CompleteCar("Modelo" + (i % 10)));
    }
  }

  public static void runWithFlywieght() {
    for (int i = 0; i < NUM_OBJECTS; i++) {
      carList.add(new Car(CarFactory.getCharacterType("Modelo" + (i % 10))));
    }
  }
}


