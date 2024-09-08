# File based configuration manager
### Problem Statement
You are tasked with creating a system-wide configuration manager for a complex software suite. The configuration manager
is responsible for managing various configuration settings that affect the behavior and appearance of the software. 
To prevent multiple instances of the configuration manager, which could lead to inconsistencies and potential resource 
conflicts, you need to implement a design pattern that ensures the configuration manager is a singleton object.

### Assignment
You are required to extend an abstract class FileBasedConfigurationManager to implement the Singleton design pattern 
and create a configuration manager class. The abstract class provides a foundation for managing configuration settings 
using a file-based approach.

#### Part 1: Implementing Singleton and Extending Abstract Class
Extend the _FileBasedConfigurationManager_ abstract class: 
You already have an abstract class named FileBasedConfigurationManager. Your task is to extend this class to create your
own configuration manager class.

Implement the Singleton design pattern: 
Within your configuration manager class, implement the Singleton design pattern to ensure that only one instance of your 
class can exist within the program.

Implement the __getInstance()__ and __resetInstance()__ methods: 
Implement the getInstance() and resetInstance() methods in your configuration manager class. 
The getInstance() method should return the singleton instance of your configuration manager class. 
The resetInstance() method should reset the singleton instance of your configuration manager class to null.

#### Part 2: Configuration Management
The __FileBasedConfigurationManager__ abstract class provides a foundation for managing configuration settings using a 
file-based approach.

It already has a load method that loads configuration settings from a file and stores it in a Properties object. 
The Properties object is a collection of key-value pairs, where the key is a string and the value is an object.

#### Implement the following methods for configuration management in your extended class: 

* __String getConfiguration(String key)__: Retrieve a configuration value based on a given key.
* __<T> T getConfiguration(String key, Class<T> type)__: Retrieve a configuration value and perform type conversion.
* __void setConfiguration(String key, String value)__: Set a configuration value.
* __<T> void setConfiguration(String key, T value)__: Set a configuration value with type checking.
* __void removeConfiguration(String key)__: Remove a configuration value based on a given key.
* __void clear()__: Clear all configuration settings.