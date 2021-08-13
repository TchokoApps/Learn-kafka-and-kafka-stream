"# Learn-kafka-and-kafka-stream" 

NOTE : 
- See lecture with title "Executing Kafka Commands" if you need guidance to execute commands
- If you use windows, change the .sh extension to .bat

# create topic t_hello
kafka-topics.bat --bootstrap-server localhost:9092 --create --topic t_hello --partitions 1 --replication-factor 1

# list topic
kafka-topics.bat --bootstrap-server localhost:9092 --list

# describe topic
kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic t_hello

# create topic t_test
kafka-topics.bat --bootstrap-server localhost:9092 --create --topic t_test --partitions 1 --replication-factor 1

# delete topic t_test
kafka-topics.bat --bootstrap-server localhost:9092 --delete --topic t_test

NOTE : 
- See lecture with title "Executing Kafka Commands" if you need guidance to execute commands
- If you use windows, change the .sh extension to .bat


# create topic t_fixedrate
kafka-topics.bat --bootstrap-server localhost:9092 --create --topic t_fixedrate --partitions 1 --replication-factor 1

# list topic
kafka-topics.bat --bootstrap-server localhost:9092 --list

NOTE : 
- See lecture with title "Executing Kafka Commands" if you need guidance to execute commands
- If you use windows, change the .sh extension to .bat

# create topic t_fixedrate_2
kafka-topics.bat --bootstrap-server localhost:9092 --create --topic t_fixedrate_2 --partitions 1 --replication-factor 1

NOTE : 
- See lecture with title "Executing Kafka Commands" if you need guidance to execute commands
- If you use windows, change the .sh extension to .bat


# create topic
kafka-topics.bat --bootstrap-server localhost:9092 --create --topic t_multi_partitions --partitions 3 --replication-factor 1

# describe topic
kafka-topics.bat --bootstrap-server localhost:9092 --describe --topic t_multi_partitions

# Kafka console consumer (change the partition number as needed)
kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic t_multi_partitions --offset earliest --partition 0

NOTE : 
- See lecture with title "Executing Kafka Commands" if you need guidance to execute commands
- If you use windows, change the .sh extension to .bat


# create topic
kafka-topics.sh --bootstrap-server localhost:9092 --create --topic t_multi_partitions --partitions 3 --replication-factor 1

# describe topic
kafka-topics.sh --bootstrap-server localhost:9092 --describe --topic t_multi_partitions

# Kafka console consumer (change the partition number as needed)
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic t_multi_partitions --offset earliest --partition 0

NOTE : 
- See lecture with title "Executing Kafka Commands" if you need guidance to execute commands
- If you use windows, change the .sh extension to .bat


# add topic
kafka-topics.sh --bootstrap-server localhost:9092 --create --topic t_employee --partitions 1 --replication-factor 1

# Kafka console consumer
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic t_employee --offset earliest --partition 0

NOTE : 
- See lecture with title "Executing Kafka Commands" if you need guidance to execute commands
- If you use windows, change the .sh extension to .bat


# add topic
kafka-topics.sh --bootstrap-server localhost:9092 --create --topic t_employee --partitions 1 --replication-factor 1

# Kafka console consumer
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic t_employee --offset earliest --partition 0

# Delete topic
kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic t_employee

NOTE : 
- See lecture with title "Executing Kafka Commands" if you need guidance to execute commands
- If you use windows, change the .sh extension to .bat


# add topic
kafka-topics.sh --bootstrap-server localhost:9092 --create --topic t_commodity --partitions 1 --replication-factor 1

# Kafka console consumer
kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic t_commodity --offset earliest --partition 0
