package weatherreport;

public class WeatherReport {
    public static String Report(IWeatherSensor sensor) {
        int precipitation = sensor.Precipitation();
        // precipitation < 20 is a sunny day
        String report = "Sunny Day";

        if (sensor.TemperatureInC() > 25)
        {
            if (precipitation >= 20 && precipitation < 60)
                report = "Partly Cloudy";
            else if (sensor.WindSpeedKMPH() > 50)
                report = "Alert, Stormy with heavy rain";
        }
        return report;
    }

    private static void TestRainy() {
        IWeatherSensor sensor = new SensorStub();
        String report = Report(sensor);
        System.out.println(report);
        assert(report.contains("rain"));
    }

    private static void TestHighPrecipitation() {
        // This instance of stub needs to be different-
        // to give high precipitation (>60) and low wind-speed (<50)
        IWeatherSensor sensor = new SensorStub();

        // strengthen the assert to expose the bug
        // (function returns Sunny day, it should predict rain)
        String report = Report(sensor);
        System.out.println(report);
        assert(report != null);
    }

// Strong assertion to fail 
        private static void StrongTestRainy() {
        IWeatherSensor sensor = new SensorStubHighPrecipitation();
        String report = Report(sensor);
        System.out.println("StrongTestRainy: " + report);

        
        assert report.toLowerCase().contains("rain") : "Expected rain, got: " + report;
    }

    private static void StrongTestStormy() {
        IWeatherSensor sensor = new SensorStubStormy();
        String report = Report(sensor);
        System.out.println("StrongTestStormy: " + report);

        assert report.equals("Alert, Stormy with heavy rain") : "Expected storm alert, got: " + report;
    }

     // ===============================


    
    public static void main(String[] args) {
        TestRainy();
        TestHighPrecipitation();

         // New strong tests
        StrongTestRainy();
        StrongTestStormy();

        System.out.println("All is well (maybe!)");
    }
}

public interface IWeatherSensor {
    double TemperatureInC();
    int Precipitation();
    int Humidity();
    int WindSpeedKMPH();
}

class SensorStub implements IWeatherSensor {
    @Override
    public int Humidity() {
        return 72; // Stubbed humidity
    }

    @Override
    public int Precipitation() {
        return 70; // Stubbed precipitation
    }

    @Override
    public double TemperatureInC() {
        return 26; // Stubbed temperature
    }

    @Override
    public int WindSpeedKMPH() {
        return 52; // Stubbed wind speed
    }
}
