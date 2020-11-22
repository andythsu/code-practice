/**
 * @Author asu
 * @Date 11/21/2020
 * @Description https://aonecode.com/amazon-online-assessment-utilization-checks
 **/
public class UtilizationCheck {
    public int solution(int instances, int[] averageUtil) {
        for (int i = 0; i < averageUtil.length; i++) {
            if (averageUtil[i] < 25) {
                if (instances == 1) continue;
                instances = (int) Math.ceil((double) instances / 2);
                i = i + 10;
            } else if (averageUtil[i] >= 25 && averageUtil[i] <= 60) {
                continue;
            } else {
                if (instances * 2 <= 2 * Math.pow(10, 8)) {
                    instances = instances * 2;
                    i = i + 10;
                } else {
                    continue;
                }
            }
        }
        return instances;
    }
}
