package utng.edu.mx.msaucedo.temperaturas;

/**
 * Created by Mariana Saucedo on 20/06/2016.
 */
public class Conversiones {
    /**
     * Convierte de grados celsius a grados fahrenheit
     * @param gc grados celsius
     * @return gf grados fahrenhet
     */
    public static double gradosCTogradosF(double gc) {
        double gf = 0.0;
        gf = 1.8*gc + 32;

        return gf;
    }

    /**
     * Converte de grados celsius a kelvin
     * @param gc grados celsius
     * @return gk kelvin
     */
    public static double gradosCTogradosK(double gc) {
        double gk = 0.0;
        gk = gc + 273;

        return gk;
    }

    /**
     * Converte de grados celsius a kelvin
     * @param gc grados celsius
     * @return gk kelvin
     */
    public static double gradosCTogradosR(double gc) {
        double gk = 0.0;
        double gr = 0.0;

        gk = gradosCTogradosK(gc);

        gr = gk * 1.8;

        return gr;
    }
    /**
     * Converte de pesos a dolares
     * @param mx pesos
     * @return dl dolares
     */
    public static double pesosToDolares(double mx) {

        double dl = 0.0;
        dl= mx*0.05334;
        return dl;
    }
    /**
     * Converte de pesos a euros
     * @param mx pesos
     * @return eu euros
     */
    public static double pesosToEuros(double mx) {

        double eu = 0.0;
        eu= mx*0.0469811071;
        return eu;
    }
    /**
     * Converte de pesos a yenes
     * @param mx pesos
     * @return yn yenes
     */
    public static double pesosToYenes(double mx) {

        double yn = 0.0;
        yn= mx*55931;
        return yn;
    }
    /**
     * Converte de metros a kilometros
     * @param mtrs metros
     * @return km kilometros
     */
    public static double metrosToKilometros(double mtrs) {

        double km = 0.0;
        km= mtrs*0.001;
        return km;
    }
    /**
     * Converte de metros a yardas
     * @param mtrs metros
     * @return yd yardas
     */
    public static double metrosToYardas(double mtrs) {

        double yd = 0.0;
        yd= mtrs*1.09361;
        return yd;
    }
    /**
     * Converte de metros a millas
     * @param mtrs metros
     * @return mll millas
     */
    public static double metrosToMillas(double mtrs) {

        double mll = 0.0;
        mll= mtrs*0.000621371;
        return mll;
    }
}
