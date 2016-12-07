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

Persistent, ephemeral and sequential znodes:
A persistent znode /path can be deleted only through a call to delete. An epheremal znode, in contrast, is deleted if the client that created it crashes or simply closes its connnection to ZooKeeper.

Persistent znodes are useful if we persist data even after the node crashes, for example the tasks assigned to worker or list of tasks. This information should be retained even if the node performing the tasks crashes so that it can be reassigned to some other node.
Ephemeral znodes convey information about few components of the application as long as they are active, for example, master and worker nodes. As soon as a master or worker node crashes, its status should be updated so that new master can be elected and new worker can pick old worker's task.

Sequential znode is assigned a unique, monotonically increasing integer. This sequence number is appended to the path used to create the znode.

Four znode types:
1. Persistent
2. Ephemeral
3. Persistent_sequential
4. Ephemeral_sequential

*Watches*
Registering to receive a notification consists of setting a watch. After every notification the watch has to be set again to receive next notification. If watch is not set, the next notification will be not be delivered. Watches are set with operations that read the state of the ZooKeeper.

A notification is delivered to a client before any new changes are made to the same znode.

*Versions*
Every znode has a version associated with it which is incremented every data change. A new write operation only succeeds only when the current version matches with the version number sent by client, this helps overriding stale data. If a client passes old version, the write will fail, hence the client will have to take an update and do a write again with latest version number.

*ZooKeeper Quorums*
To avoid split brain, it is always recommended to choose old numnber of nodes and set quorum to n/2 + 1.
Why odd?
For a cluster with 4 nodes, minimum quorum required is 3, hence it can only sustain a failure of single node, if two nodes fails the cluster will be down. However with 5 node cluster, the quorum will still be 3, but now the cluster can sustain failure of 2 nodes.

*Sessions*
Before executing any operation against a ZooKeeper ensemble, a client must establish a session. All operations submitted by a client is associated with a session, the moment session ends for any reason all ephemeral nodes created during that session disappears. 
