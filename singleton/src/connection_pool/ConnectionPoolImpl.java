package connection_pool;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectionPoolImpl implements ConnectionPool {

    // Singleton instance
    private static ConnectionPoolImpl instance;

    // Pool to store available connections
    private final Queue<DatabaseConnection> availableConnections;

    // Maximum number of connections in the pool
    private int maxConnections;

    // Private constructor to prevent direct instantiation
    private ConnectionPoolImpl(int maxConnections) {
        this.maxConnections = maxConnections;
        this.availableConnections = new LinkedList<>();
        initializePool();
    }

    // Singleton getInstance method
    public static synchronized ConnectionPoolImpl getInstance(int maxConnections) {
        if (instance == null) {
            instance = new ConnectionPoolImpl(maxConnections);
        }
        return instance;
    }

    // Resetting the Singleton instance
    public static synchronized void resetInstance() {
        instance = null;
    }

    @Override
    public void initializePool() {
        for (int i = 0; i < maxConnections; i++) {
            availableConnections.add(new DatabaseConnection()); // Dummy connections
        }
    }

    @Override
    public synchronized DatabaseConnection getConnection() {
        if (availableConnections.isEmpty()) {
            throw new RuntimeException("No available connections.");
        }
        return availableConnections.poll(); // Remove and return the first available connection
    }

    @Override
    public synchronized void releaseConnection(DatabaseConnection connection) {
        if (connection != null) {
            availableConnections.offer(connection); // Return connection back to the pool
        }
    }

    @Override
    public synchronized int getAvailableConnectionsCount() {
        return availableConnections.size(); // Count of available connections
    }

    @Override
    public int getTotalConnectionsCount() {
        return maxConnections; // Total number of connections in the pool (available + in use)
    }
}
