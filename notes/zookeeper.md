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

Three major problems in a master-worker system:
1. Master crashes
2. Worker crashes
3. Communication failures

Requirements of a master-worker architecture:
1. Master election
2. Crash detection
3. Group membership management
4. Metadata management

ZooKeeper exposes a file system-like API comprised of a small set of calls that enables applications to implement their own primitives.

ZooKeeper does not allow partial reads or writes or znode data. The content of znode is replaced or read entirely.

Persistent and ephemeral znodes:
A persistent znode /path can be deleted only through a call to delete. An epheremal znode, in contrast, is deleted if the client that created it crashes or simply closes its connnection to ZooKeeper.

Persistent znodes are useful if we persist data even after the node crashes, for example the tasks assigned to worker or list of tasks. This information should be retained even if the node performing the tasks crashes so that it can be reassigned to some other node.
Ephemeral znodes convey information about few components of the application as long as they are active, for example, master and worker nodes. As soon as a master or worker node crashes, its status should be updated so that new master can be elected and new worker can pick old worker's task.
 
