# Prophecy

Prophecy is a simple java SQL Connection pool capable of having multiple connections to enhance
database access speed by using more than one connection. 

# Installation / Usage

- Install [Maven](http://maven.apache.org/download.cgi)
- Clone this repo
- Instal: ```mvn clean install```

**Maven repositories**
```xml
<repositories>
    <!-- Klauke Enterprises Releases -->
    <repository>
        <id>klauke-enterprises-maven-releases</id>
        <name>Klauke Enterprises Maven Releases</name>
        <url>https://repository.klauke-enterprises.com/repository/maven-releases/</url>
    </repository>
	
    <!-- Klauke Enterprises Snapshots -->
    <repository>
        <id>klauke-enterprises-maven-snapshots</id>
        <name>Klauke Enterprises Maven Snapshots</name>
        <url>https://repository.klauke-enterprises.com/repository/maven-snapshots/</url>
    </repository>
</repositories>
```


**Maven dependencies**

_Core:_
```xml
<dependency>
    <groupId>de.felixklauke.prophecy</groupId>
    <artifactId>prophecy-core</artifactId>
    <version>1.0.0</version>
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
