# mybatis-spring-boot-gh-606

Sample for https://github.com/mybatis/spring-boot-starter/issues/606.

# Mapper Files

## Mapper XML in other-module

other-module/src/main/resources/com/example/demo/FooMapper.xml

```xml
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.demo.FooMapper">
    <select id="ping" resultType="_int">
        select 1
    </select>
</mapper>
```

Note: return `1` from other module mapper file.

## Mapper XML in my-module (overriding mapper xml)

my-module/src/main/resources/com/example/demo/FooMapper.xml

```xml
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.example.demo.FooMapper">
    <select id="ping" resultType="_int">
        select 2
    </select>
</mapper>
```

Note: return `2` from my module mapper file.

# How to override

my-module/src/main/resources/application.properties

```properties
mybatis.mapper-locations=classpath:/com/example/demo/FooMapper.xml
```

Build:

```
./mvnw package
```

Run application:

```
java -jar my-module/target/my-module-0.0.1-SNAPSHOT.jar 
...
2021-12-30 15:46:23.278  INFO 14353 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
2
bar
2021-12-30 15:46:23.329  INFO 14353 --- [ionShutdownHook] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Shutdown initiated...
...
```
