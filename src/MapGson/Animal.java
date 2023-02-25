package MapGson;

import java.util.List;

public class Animal {
    String location;
    int number;
    List<Child>list;

    @Override
    public String toString() {
        return "Animal{" +
                "location='" + location + '\'' +
                ", number=" + number +
                ", list=" + list +
                '}';
    }

    public Animal(String location, int number, List<Child> list) {
        this.location = location;
        this.number = number;
        this.list = list;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Child> getList() {
        return list;
    }

    public void setList(List<Child> list) {
        this.list = list;
    }
}
