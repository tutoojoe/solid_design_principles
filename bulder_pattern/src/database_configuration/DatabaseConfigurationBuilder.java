package database_configuration;

@WithBuilder
public class DatabaseConfigurationBuilder {
    private String databaseUrl;
    private String username;
    private String password;
    private int maxConnections;
    private boolean enableCache;
    private boolean isReadOnly;


    public static Builder getBuilder(){
        return new Builder();
    }

    private DatabaseConfigurationBuilder(Builder builder){
        this.databaseUrl = builder.databaseUrl;
        this.username = builder.username;
        this.password = builder.password;
        this.maxConnections = builder.maxConnections;
        this.enableCache = builder.enableCache;
        this.isReadOnly = builder.isReadOnly;
    }

    @Override
    public String toString() {
        return "Database URL: " + databaseUrl +
                "\nUsername: " + username +
                "\nPassword: " + password +
                "\nMax Connections: " + maxConnections +
                "\nEnable Cache: " + enableCache +
                "\nRead Only: " + isReadOnly;
    }

    public static class Builder{
        private String databaseUrl;
        private String username;
        private String password;
        private int maxConnections;
        private boolean enableCache;
        private boolean isReadOnly;


        public Builder databaseUrl(String databaseUrl){
            this.databaseUrl = databaseUrl;
            return this;
        }
        public Builder username(String username){
            this.username = username;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public Builder maxConnections(int maxConnections){
            this.maxConnections = maxConnections;
            return this;
        }
        public Builder enableCache(boolean enableCache){
            this.enableCache = enableCache;
            return this;
        }
        public Builder isReadOnly(boolean isReadOnly){
            this.isReadOnly = isReadOnly;
            return this;
        }

        public DatabaseConfigurationBuilder build(){
            return new DatabaseConfigurationBuilder(this);
        }
    }

}
