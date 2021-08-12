"# Learn-kafka-and-kafka-stream" 

NOTE : 
- See lecture with title "Executing Kafka Commands" if you need guidance to execute commands
- If you use windows, change the .sh extension to .bat

# create topic t_hello
kafka-topics.sh --bootstrap-server localhost:9092 --create --topic t_hello --partitions 1 --replication-factor 1

# list topic
kafka-topics.sh --bootstrap-server localhost:9092 --list

# describe topic
kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic t_hello

# create topic t_test
kafka-topics.sh --bootstrap-server localhost:9092 --create --topic t_test --partitions 1 --replication-factor 1

# delete topic t_test
kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic t_test

NOTE : 
- See lecture with title "Executing Kafka Commands" if you need guidance to execute commands
- If you use windows, change the .sh extension to .bat


# create topic t_fixedrate
kafka-topics.sh --bootstrap-server localhost:9092 --create --topic t_fixedrate --partitions 1 --replication-factor 1

# list topic
kafka-topics.sh --bootstrap-server localhost:9092 --list

NOTE : 
- See lecture with title "Executing Kafka Commands" if you need guidance to execute commands
- If you use windows, change the .sh extension to .bat

# create topic t_fixedrate_2
kafka-topics.sh --bootstrap-server localhost:9092 --create --topic t_fixedrate_2 --partitions 1 --replication-factor 1