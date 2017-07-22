# Prophecy

Prophecy is a simple java SQL Connection pool capable of having multiple connections to enhance
database access speed by using more than one connection. 

# Installation / Usage

- Install [Maven](http://maven.apache.org/download.cgi)
- Clone this repo
- Instal: ```mvn clean install```

**Maven dependencies**

_Client:_
```xml
<dependency>
    <groupId>de.felix_klauke</groupId>
    <artifactId>prophecy-core</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```

# Example

_Creation:_
```java
ProphecyConfig config = ProphecyConfig.newBuilder()
        .setDatabaseURL("{URL}")
        .setDatabaseUser("user")
        .setDatabaseUserPassword("password")
        .createProphecyConfig();
        
Prophecy prophecy = ProphecyFactory.createProphecy(config);
```

_Plain old usage:_
```java
Connection connection = prophecy.getConnection();
        
// Do whatever you want, query, update...
        
prophecy.checkInConnection(connection);
```

_Using AutoCloseable:_
```java
try (Connection connection = prophecy.getConnection()){
    // Do whatever you want
} catch (SQLException e) {
    e.printStackTrace();
}
```

_We also support Datasources:_
```java
DataSource dataSource = prophecy.createDatasource();
```