
import java.io.*;
import java.util.UUID;

public class Laptop implements Cloneable, Serializable {

    private String id;
    private String brand;
    private String color;
    private Processor processor;
    private GraphicsCard graphicsCard;

    public Laptop(String brand, String color, Processor processor, GraphicsCard graphicsCard) {
        this.id = UUID.randomUUID().toString();
        this.brand = brand;
        this.color = color;
        this.processor = processor;
        this.graphicsCard = graphicsCard;
    }

    public Laptop cloneLaptop() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream outputByteArrayStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputByteArrayStream);
        objectOutputStream.writeObject(this);

        ByteArrayInputStream inputByteArrayStream = new ByteArrayInputStream(outputByteArrayStream.toByteArray());
        ObjectInputStream objectIO = new ObjectInputStream(inputByteArrayStream);
        return (Laptop) objectIO.readObject();
    }
    public Laptop clone() throws CloneNotSupportedException {
        return (Laptop) super.clone();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public GraphicsCard getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(GraphicsCard graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Laptop laptop = (Laptop) o;

        if (getId() != null ? !getId().equals(laptop.getId()) : laptop.getId() != null) {
            return false;
        }
        if (getBrand() != null ? !getBrand().equals(laptop.getBrand()) : laptop.getBrand() != null) {
            return false;
        }
        if (getColor() != null ? !getColor().equals(laptop.getColor()) : laptop.getColor() != null) {
            return false;
        }
        if (getProcessor() != null ? !getProcessor().equals(laptop.getProcessor()) : laptop.getProcessor() != null) {
            return false;
        }
        return getGraphicsCard() != null ? getGraphicsCard().equals(laptop.getGraphicsCard()) : laptop.getGraphicsCard() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getBrand() != null ? getBrand().hashCode() : 0);
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        result = 31 * result + (getProcessor() != null ? getProcessor().hashCode() : 0);
        result = 31 * result + (getGraphicsCard() != null ? getGraphicsCard().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Laptop{ id='" + id + '\'' + ", brand='" + brand + '\'' + ", color='" + color + '\'' + ", processor=" + processor
                + ", graphicsCard=" + graphicsCard + '}';
    }
}
