package mobileTesting.factoryDevice;

public class FactoryDevices {
    public static IDevice make(String deviceType){
        IDevice device;
        switch(deviceType.toLowerCase()){
            case "android":
                device = new Android();
                break;
            default:
                device= new Android();
                break;
        }
        return device;
    }
}
