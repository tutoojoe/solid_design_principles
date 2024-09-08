package file_based_configuration;

public class FileBasedConfigurationManagerImpl extends FileBasedConfigurationManager {
    private static FileBasedConfigurationManagerImpl instance;

    private FileBasedConfigurationManagerImpl(){
        super();
    }

    @Override
    public String getConfiguration(String key) {
        // TODO Auto-generated method stub
        return properties.getProperty(key);
        //throw new UnsupportedOperationException("Unimplemented method 'getConfiguration'");
    }

    @Override
    public <T> T getConfiguration(String key, Class<T> type) {
        // TODO Auto-generated method stub
        String value = properties.getProperty(key);
        if (value==null){
            return null;
        }
        return convert(value, type);
        //throw new UnsupportedOperationException("Unimplemented method 'getConfiguration'");
    }

    @Override
    public void setConfiguration(String key, String value) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'setConfiguration'");
        properties.setProperty(key, value);
    }

    @Override
    public <T> void setConfiguration(String key, T value) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'setConfiguration'");
        properties.setProperty(key, value.toString());
    }

    @Override
    public void removeConfiguration(String key) {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'removeConfiguration'");
        properties.remove(key);
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'clear'");
        properties.clear();
    }

    public static FileBasedConfigurationManagerImpl getInstance() {
        // TODO Auto-generated method stub
        //return null;
        if (instance == null) {
            instance = new FileBasedConfigurationManagerImpl();
        }
        return instance;
    }

    public static void resetInstance() {
        // TODO Auto-generated method stub
        instance = null;
    }

}