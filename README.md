# e-commerce

## 개발환경

* Kafka
* Kafka connect
* Rabbit MQ
* Zipkin
* Grafana
* Prometheus
* Java11
* Spring Cloud
* JPA
* MariaDB

</br>

## 서비스 구성

<img width="1210" alt="image" src="https://user-images.githubusercontent.com/45115557/202171646-de94fc92-64ea-42d1-9b32-a985412c3659.png">

</br>

## 카프카 실행 명령어

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

#### Topic 삭제

예전에는 `--zookeeper` 옵션을 줘서 삭제를 해줬지만 이는 deprecated 된 옵션이다.    
zookeeper 쉘이 아닌, kafka-topics를  사용해서 `--bootstrap-server` 옵션으로 진행해줘야 한다. 

```
$KAFKA_HOME/bin/kafka-topics.sh --bootstrap-server localhost:9092 --delete topic-name
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
./bin/connect-distributed ./etc/kafka/connect-distributed.properties
```

</br>

## MariaDB 실행

mac 환경에서 brew로 간편하게 설치할 수 있다. 

#### 설치

```
brew install mariadb
```

#### 기동

```
brew services start mariadb
```

#### 기동 확인

```
brew services
```

#### 접속

```
mysql -uroot
```
이 때 Access denied 권한 에러가 난다면

```
sudo mysql -u root
```
로 접속한다. 이때 비밀번호는 root 비밀번호가 아니라, sudo 계정의 비밀번호다. 

<img width="645" alt="image" src="https://user-images.githubusercontent.com/45115557/198336940-d524a7a1-f49f-4db3-b820-dd7aabf00db5.png">

kafka sink-connector를 통해 order-service에서 orders topic에 등록한 데이터를 mariadb에 넣을 수 있다. 이로써 여러개의 분산처리된 order-service의 db접근 데이터를 동기화 할 수 있다. 

<img width="644" alt="image" src="https://user-images.githubusercontent.com/45115557/198337465-05e1c9db-4526-4c2c-a82d-08989e47a1b8.png">

위는 connector 로그 캡쳐화면이다. 

</br>
