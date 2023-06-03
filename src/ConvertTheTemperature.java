// https://leetcode.com/problems/convert-the-temperature
// T: O(1)
// S: O(1)

public class ConvertTheTemperature {
    public double[] convertTemperature(double celsius) {
        return new double[] { celsiusToKelvin(celsius), celsiusToFahrenheit(celsius) };
    }

    private double celsiusToFahrenheit(double celsius) {
        return celsius * 1.8 + 32.00;
    }

    private double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
}
