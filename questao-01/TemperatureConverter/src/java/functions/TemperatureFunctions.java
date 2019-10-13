package functions;

/**
 *
 * @author Carlos
 */
public class TemperatureFunctions {

    /**
     * Transforma uma temperatura em Celsius para Fahrenheit
     *
     * @param val valor da temperatura em Celsius
     * @return temperatura em Fahrenheit
     */
    public static double CelsToFahr(double val) {
        return ((9.0 / 5.0) * val) + 32.0;
    }

}
