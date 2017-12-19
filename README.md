This sample uses two examples:

[Tuning RabbitMQ MQTT for large number of connections](http://antoine-galataud.github.io/messaging/rabbitmq/mqtt/performance/2016/08/05/rabbitmq-mqtt-tuning.html)

[rmq-mqtt-demo](https://github.com/andypiper/rmq-mqtt-demo/blob/master/MqttTest.java)

The tuning example was converted to a unit test and can be run by highlighting
the test method and selecting run if you're using Intellij. The result will
be a green bar. 

The rmq-mqtt-demo was converted to a component and an implementation of 
CommandLineRunner. The expected output is:


``` 2017-12-19 09:12:40.217  INFO 14614 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Located managed bean 'rabbitConnectionFactory': registering with JMX server as MBean [org.springframework.amqp.rabbit.connection:name=rabbitConnectionFactory,type=CachingConnectionFactory]
 2017-12-19 09:12:40.243  INFO 14614 --- [           main] o.s.c.support.DefaultLifecycleProcessor  : Starting beans in phase 2147483647
 2017-12-19 09:12:40.325  INFO 14614 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
 this payload was published on MQTT and read using AMQP
 2017-12-19 09:12:42.813  INFO 14614 --- [           main] i.p.spring.mqtt.boot.demo.Application    : Started Application in 6.347 seconds (JVM running for 7.087)
```
The Tuning example was converted to a unit test so that you could see how
they are structured.  If you read the article there are a number of ways you can
extend this to develop a structure for performance testing. The apps were not refactored any
further than to enable them to be launched as boot apps in a testing and CommandLineRunner
format.  

