package file_based_configuration;


public class Main {
    public static void main(String[] args) {
        // Get instance of the configuration manager
        FileBasedConfigurationManagerImpl configManager = FileBasedConfigurationManagerImpl.getInstance();

        // Set configuration values
        configManager.setConfiguration("app.name", "MyApp");
        configManager.setConfiguration("app.version", "1.0");
        configManager.setConfiguration("max.connections", 15);

        // Retrieve configuration values
        String appName = configManager.getConfiguration("app.name");
        int maxConnections = configManager.getConfiguration("max.connections", Integer.class);

        // Print values
        System.out.println("App Name: " + appName);
        System.out.println("Max Connections: " + maxConnections);

        // Clear all configurations
        configManager.clear();

        // Reset the instance if needed
        FileBasedConfigurationManagerImpl.resetInstance();
    }
}
