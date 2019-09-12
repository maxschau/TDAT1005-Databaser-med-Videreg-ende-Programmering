import java.util.Objects;

public class Student {
    private String navn;
    private int alder;

    public Student(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
    }


    public String getNavn() {
        return navn;
    }

    public int getAlder() {
        return alder;
    }
}

