ZooKeeper helps implement common tasks:
* Electing a master server
* Managing group membership
* Managing metadata.

It enabled coordination tasks for distributed systems.

ZooKeeper has consistency and availability of CAP, it also provides read-only capability during network partition.

It uses shared storage model to let applications implement coordination and synchronization primitives.

It is very difficult to coodinate in distributed systems as it gets impacted due to:
1. Message delays
2. Processor speeds
3. Clock drift

It becomes very difficult to differentiate if the process has crashed or if there is a delay due to above factors.
