Cassandra stores data both in memory and on disk.
Cassandra Daemon (JVM):
* Memtables (native memory)
* Key Caches
* Row Caches
Disk:
* Commit Logs
* SSTables
* Hints (2.2+)

Whenever a write operation is performed, it is immediately written to commit log. The commit log is a crash-recovery mechanism that supports Cassandra's durability goals.
When a node starts, the commit log gets replayed.
When number of objects in memtable reaches a threshold level, the contents of the table are flushed to disk in a file called SSTable. This is non-blocking operation; multiple memtables may exist for the single table, one current and rest waiting to be flushed.

Paxos is a consensus algorithm that allows distributed peer nodes to agree on a proposal, without requiring a master to coordinate a transactation.

The Cassandra implementation extends the basic Paxos algorithm in order to support the desired read-before-write semantics (also known as "check-and-set"), and to allow the state to be reset between transactions. It does this by inserting two additional phases into the algorithm, so that it works as follows:
* Prepare/Promise
* Read/Results
* Propose/Accept
* Commit/Ack

Compaction Strategies:
* SizeTieredCompactonStrategy (STCS)
  * write-intensive tables
* LevelCompactionStrategy (LCS)
  * read-intensive tables
* DateTieredCompactionStrategy (DTCS)
  * time series or other date-based data.

Cassandra uses anti-entropy protocols which work by comparing replicas of data and reconciling differences observed between the replicas.
