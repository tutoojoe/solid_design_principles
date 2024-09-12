package database_configuration;

public class Main {
    public static void main(String[] args) {
        // Build a database configuration using the builder
        DatabaseConfigurationBuilder config = DatabaseConfigurationBuilder.getBuilder()
                .databaseUrl("jdbc:mysql://localhost:3306/mydb")
                .username("admin")
                .password("password123")
                .maxConnections(100)
                .enableCache(true)
                .isReadOnly(false)
                .build();

        // Print the result to verify the configuration
        System.out.println(config);
    }
}
