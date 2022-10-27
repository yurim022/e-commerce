# e-commerce

### 개발환경

* Kafka
* Kafka connect
* Rabbit MQ
* Java11
* Spring Cloud
* JPA

</br>

### 카프카 실행 명령어

zookeeper 먼저 실행후, 30초정도 대기한 뒤 카프카를 띄워준다.  

#### zookeeper 실행

```
$KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties
```
#### kafka 실행

```
$KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server.properties
```

#### topic 생성

```
$KAFKA_HOME/bin/kafka-topics.sh --create --topic topic-name --bootstrap-server localhost:9092 --partitions 1
```

#### topic 목록 확인

```
$KAFKA_HOME/bin/kafka-topics.sh --bootstrap-server localhost:9092 --list
```

#### topic 정보 확인

```
$KAFKA_HOME/bin/kafka-topics.sh --describe --topic topic-name --bootstrap-server localhost:9092
```

</br>

### Producer/Consumer 테스트

#### 메세지 생산

```
$KAFKA_HOME/bin/kakfa-console-producer.sh --broker-list localhost:9092 --topic topic-name
```

#### 메세지 소비

```
$KAFKA_HOME/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic topic-name --from-beginning
```

</br>

### Kafka Connect

#### kafka connect 실행

kafka connect는 별도로 설치 및 실행해주어야 한다. db에 맞는 jdbc connector도 설정해주는 것 잊지 말자!

```
.\bin\connect-distributed .\etc\kafka\connect-distributed.properties
```

#### Topic 목록 확인

```
.\bin\kafka-topics.sh --bootstrap-server localhost:9092 --list
```
