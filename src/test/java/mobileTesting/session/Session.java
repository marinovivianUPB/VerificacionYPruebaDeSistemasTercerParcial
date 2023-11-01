package mobileTesting.session;


import io.appium.java_client.AppiumDriver;
import mobileTesting.factoryDevice.FactoryDevices;

public class Session {
    private static Session session = null;
    private AppiumDriver device;
    private Session(){

    }


    public static Session getSession(){
        if(session==null){
            session=new Session();
        }
        return session;
    }

    public void closeApp(){
        device.quit();
        session=null;
    }

    public void setPackageAndActivity(String packageS, String activity){
        device= FactoryDevices.make("android").create(packageS, activity);
    }

    public AppiumDriver getDevice(){
        return device;
    }
}
