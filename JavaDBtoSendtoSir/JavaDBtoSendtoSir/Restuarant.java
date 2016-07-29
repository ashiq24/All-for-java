

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Restuarant {
    private final SimpleIntegerProperty key;
    private final SimpleStringProperty name;
    private final SimpleStringProperty address;
    private final SimpleStringProperty foodType;


    Restuarant(Integer key,String name, String address, String foodType) {
        this.key = new SimpleIntegerProperty(key);
        this.name = new SimpleStringProperty(name);
        this.address = new SimpleStringProperty(address);
        this.foodType = new SimpleStringProperty(foodType);
    }

    public void setNumber(Integer i)
    {
        key.set(i);
    }

    public int getNumber(){
        return key.getValue();
    }
    public String getName() {
        return name.get();
    }
    public void setName(String fName) {
        name.set(fName);
    }

    public String getAddress() {
        return address.get();
    }
    public void setAddress(String fName)
    {
        address.set(fName);
    }

    public String getFoodType() {
        return foodType.get();
    }
    public void setFoodType(String fName) {
        foodType.set(fName);
    }

    public String toString() {
        return name + ", " + address + ", " + foodType;
    }

}

