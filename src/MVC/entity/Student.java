package mvc.entity;

public class Student extends Person {
    private float point;

    public Student() {
    }

    public Student(int code, String name, String address, float point) {
        super(code, name, address);
        this.point = point;
    }

    public float getPoint() {
        return point;
    }

    public void setPoint(float point) {
        this.point = point;
    }

    @Override
    public String toString() {

        return super.toString() + "," + this.point;
    }
}
