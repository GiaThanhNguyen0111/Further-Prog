package Week1.main;

public class PartTimeStudent extends Student {

    private Integer minHour;
    private Integer maxHour;

    private static Integer numberOfPartTimeStudent;

    public PartTimeStudent(Integer studentId, String name,String major) {
        super(studentId, name, major);
        numberOfPartTimeStudent++;
    }

    public Integer getMinHour() {
        return minHour;
    }

    public void setMinHour(Integer minHour) {
        this.minHour = minHour;
    }

    public Integer getMaxHour() {
        return maxHour;
    }

    public void setMaxHour(Integer maxHour) {
        this.maxHour = maxHour;
    }

    @Override
    public String toString() {
        return super.toString() + ", minHour=" + minHour +
                ", maxHour=" + maxHour;
    }

    public static int count() {
        return numberOfPartTimeStudent;
    }
}
