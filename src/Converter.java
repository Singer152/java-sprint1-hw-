public class Converter {

    double distance(int sum){
        double distance = sum * 75;
        return distance / 100000;
    }

    double burnKilocalories(int sum){
        double burnKcal = sum * 50;
        return burnKcal / 1000;
    }
}
