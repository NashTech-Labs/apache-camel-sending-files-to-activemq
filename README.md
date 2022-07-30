# apache-camel-sending-files-to-activemq
This template will help us to create a module using which we can easily send files to ActiveMQ server from our local system. The basic idea is to create a single module using Apache Camel using which the user can send multiple files to ActiveMQ server.  

# Download ActiveMQ and run it in backgroud using below command: 
activemq start

# Login to ActiveMQ
Go on the port: localhost:8161 and add default username and password i.e admin.

# Create Queue
create a queue and remember to use the same queue name while creating the module for sending files.

# Run the program
After running the program, just refresh the ActiveMQ console and you will see the count of "Number of pending messages" changed to number of files you have sent.
