import java.io.Serializable;

public class GraphicsCard implements Serializable {

    private String brand;
    private String model;

    public GraphicsCard(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Processor processor = (Processor) o;

        if (getBrand() != null ? !getBrand().equals(processor.getBrand()) : processor.getBrand() != null) { return false; }
        return getModel() != null ? getModel().equals(processor.getModel()) : processor.getModel() == null;
    }

    @Override
    public int hashCode() {
        int result = getBrand() != null ? getBrand().hashCode() : 0;
        result = 31 * result + (getModel() != null ? getModel().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "GraphicsCard{ brand='" + brand + '\'' + ", model='" + model + '\'' + '}';
    }
}
