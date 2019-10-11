package basics;

/**
 *
 * @author Carlos
 */
public class Temperatura {

    private double tempCels;
    private double tempFahr;

    /**
     * Objeto que recebe uma temperatura em algum tipo definido ou padrao e
     * guarda essa temperatura, alem de converter para outros tipos
     * 
     * @param val valor da temperatura
     * @param tipo tipo da temperatura (Celsius ou Fahrenheit)
     */
    public Temperatura(double val, int tipo) {
        if (tipo == TipoTemperatura.CELSIUS) {
            tempCels = val;
            tempFahr = CelsToFahr(val);
        } else if (tipo == TipoTemperatura.FAHRENHEIT) {
            tempFahr = val;
            tempCels = FahrToCels(val);
        } else {
            tempCels = val;
            tempFahr = CelsToFahr(val);
        }
    }

    /**
     * Transforma uma temperatura em Celsius para Fahrenheit
     * 
     * @param val valor da temperatura em Celsius
     * @return temperatura em Fahrenheit
     */
    private double CelsToFahr(double val) {
        return ((9.0 / 5.0) * val) + 32.0;
    }

    /**
     * Transforma uma temperatura em Fahrenheit para Celsius
     * 
     * @param val valor da temperatura em Fahrenheit
     * @return temperatura em Celsius
     */
    private double FahrToCels(double val) {
        return (val - 32.0) * 5 / 9;
    }

    /**
     * Retorna a temperatura em Celsius
     * 
     * @return temperatura em Celsius
     */
    public double getTempCels() {
        return tempCels;
    }

    /**
     * Retorna a temperatura em Fahrenheit
     * 
     * @return temperatura em Fahrenheit
     */
    public double getTempFahr() {
        return tempFahr;
    }

}
