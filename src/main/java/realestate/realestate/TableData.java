package realestate.realestate;

public class TableData {
   String name;
   Integer serial;

    public TableData(String name, Integer serial) {
        this.name = name;
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSerial() {
        return serial;
    }

    public void setSerial(Integer serial) {
        this.serial = serial;
    }
}
