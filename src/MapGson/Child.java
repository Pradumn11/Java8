package MapGson;


public class Child {
    String name;
    int category;

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", category=" + category +
                '}';
    }

    public Child(String name, int category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

}
