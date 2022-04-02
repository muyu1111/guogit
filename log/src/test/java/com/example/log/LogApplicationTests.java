package com.example.log;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@Slf4j
@SpringBootTest
class LogApplicationTests {

//    @Test
    void contextLoads() {
    }
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    class Letter {
        private String name;
        private int age;
        public Letter(int age){
            this.age = age;
        }
//        public   Letter  gs(Letter user){
//            return user;
//        }


    }
    @Autowired
    private RedisTemplate<String, Object> redisTemplate ;
    @Test
    public  void tedsss() {
//        RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
//        RedisConnection connection = connectionFactory.getConnection();

        // 往Redis服务端中设置一个String类型的key，值为zhangsan
//       redisTemplate.opsForValue().set("name","zhangsan");
        // 获取并打印这个key的值
        System.out.println(redisTemplate.opsForValue().get("name"));



    }
    @Test
    public void test() {
        Letter user = new Letter("李白", 15);

        //Optional<String,Letter> u = Optional.ofNullable(user).flatMap(s -> ).map()

        //System.out.println(u);
        //Optional<Letter> letter1 = Optional.ofNullable(user);
        //
//        Cal c = (a,b) -> a * b;
//        int i = c.get(3, 4);
       // System.out.println(i);
//        Optional<String> s2 = Optional.ofNullable(user).map(Letter::getName).map(Letter::getName);
//        System.out.println(user);
//        Letter other =  Optional.of(user).orElse(null);
//        System.out.println(other);
//        Asd asd = Letter::new;
//        Letter tests = asd.tests("sds",12);
//        System.out.println(tests);
//        Function<Letter,Integer>  function = e -> e.getAge();
//        Object apply = function.apply(user);
//        System.out.println(apply );
//        Function<Integer,Letter>  function = Letter::new;
//        Object apply = function.apply(13);
//        System.out.println(apply );
//        Function<Integer,Letter>  function =age -> new Letter(age);
//        Object apply = function.apply(13);
//        System.out.println(apply );
       // Function<Letter,Letter> gs = user::gs;
//        Function<Letter, Letter> gs1 = user::gs;
//        Letter apply = gs1.apply(user);
//        System.out.println(apply);
//
//        Function<Letter,String>  function =e -> e.getName();
//        String apply = function.apply(user);
//        System.out.println(apply);
//        Function<Letter,String>  function =Letter::getName;
//        String apply = function.apply(user);
//        System.out.println(apply);
          Supplier<String> ss = user::getName;
          System.out.println( ss.get());
          Optional<String> s2 = Optional.ofNullable(user).map(Letter::getName);
          System.out.println( s2.orElse(null));
    }
     @Test
     public  void tes() {
         log.debug("This is debug message.");
         // 记录info级别的信息
         log.info("This is info message.");
         // 记录error级别的信息
         log.error("This is error message.");
     }
//    interface Cal {
//        int get(int a,int b);
//    }

    interface  Asd{
        Letter tests(Integer integer);


    }
}
