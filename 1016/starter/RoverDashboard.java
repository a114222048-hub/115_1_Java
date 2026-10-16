public class RoverDashboard {
    public static void main(String[] args) {
        String roverName = "赤砂號"; // 可自訂名稱
        char zone = 'A';
        int energy = 7;
        boolean locked = false;

        double batteryPercent = calculateBatteryPercent(energy);
        int explorationCount = energy / 6; // 每次探索消耗 6 格能源，可完成幾次就用整除
        int remainingEnergy = energy % 6; // 探索完後剩下的能源
        boolean validEnergy = energy >= 0 && energy <= 20; // 0 到 20 之間才算有效
        boolean canExplore = energy >= 6 && !locked; // 至少 6 格且未鎖定才可探索

        System.out.println("探測車：" + roverName + "；區域：" + zone);
        System.out.println("能源：" + energy + "；電量百分比：" + batteryPercent);
        System.out.println("完整探索次數：" + explorationCount + "；剩餘能源：" + remainingEnergy);
        System.out.println("有效能源：" + validEnergy + "；能否探索：" + canExplore);
    }

    static double calculateBatteryPercent(int energy) {
        // 電池容量設為 20，依照剩餘能源計算百分比
        return (energy / 20.0) * 100;
    }
}
