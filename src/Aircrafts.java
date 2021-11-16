import java.io.Serializable;

public class Aircrafts   implements Serializable {
    protected  Long id;

    protected String name ;

    protected String  model ;

    protected int business_class_capacity ;

    protected int econom_class_capacity ;

    public Aircrafts(Long id,String name,String model,int business_class_capacity,int econom_class_capacity){
        this.id=id;
        this.name=name;
        this.model=model;
        this.business_class_capacity=business_class_capacity;
        this.econom_class_capacity=econom_class_capacity;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBusiness_class_capacity(int business_class_capacity) {
        this.business_class_capacity = business_class_capacity;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setEconom_class_capacity(int econom_class_capacity) {
        this.econom_class_capacity = econom_class_capacity;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public int getBusiness_class_capacity() {
        return business_class_capacity;
    }

    public int getEconom_class_capacity() {
        return econom_class_capacity;
    }

    public String getModel() {
        return model;
    }

    @Override
    public String toString() {
        return  id +
                " " + name +
                " " + model +
                " " + business_class_capacity +
                " " + econom_class_capacity;
    }
}
