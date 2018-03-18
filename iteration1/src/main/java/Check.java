public class Check {

    private Integer id;
    private String name;
    private String Device;


        public Check(){
        System.out.println("Default constructor check");
        }

    public String toString() {
        String printPojo = " POJO "+getClass() +"[id="+ id + ", name = " + name + ", Device = " +Device+"]";
        return printPojo;
    }

    public Check(Integer id, String name, String Device) {
        //super();
        System.out.println("constructor check");
        this.id = id;
        this.name = name;
        this.Device = Device;
    }
}
