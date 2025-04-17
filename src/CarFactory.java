import java.util.HashMap;
import java.util.Map;

public class CarFactory {
  private static Map<String, CarType> carTypes = new HashMap<>();


  // EXISTE UM COMANDO PARA ADICIONAR NESTE METODO!!
  public static CarType getCharacterType(String model) {
    CarType type = carTypes.get(model);
    if (type == null) {
      type = new CarType(model);
    }
    return type;
  };
}