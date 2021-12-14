public class Student {
    private String name;
    private int writtenMark;
    private int oralMark;

    public Student(String name, int writtenMark, int oralMark) {
        this.name = name;
        this.oralMark = oralMark;
        this.writtenMark = writtenMark;
    }

    public String getName() {
        return name;
    }

    public int getWrittenMark() {
        return writtenMark;
    }

    public int getOralMark() {
        return oralMark;
    }
}
