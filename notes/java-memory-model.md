The Java Memory Model (JMM) defines the allowable behavior of multithreaded programs, and therefore describes when such reorderings are possible. It places execution-time constraints on the relationship between threads and main memory in order to achieve consistent and reliable Java applications. By doing this, it makes it possible to reason about code execution in a multithreaded environment, even in the face of optimizations performed by the dynamic compiler, the processor(s) and the caches.

###Happens-before guarantees:
* Monitor lock rule:* lock.unlock before any subsequent lock.lock
* Volatile variable rule:* write before any subsequence read
* Thread start rule:* Thread.start() before Thread.isAlive() return false or Thread.join() returns
* Thread Interruption rule:* Thread calling interrupt() happens-before Thread throws IE
* Finalizer rule:* Constructor before finalizer.

Memory Management is the process of recognizing when allocated objects are not longer needed, deallocating the memory used by such objects, and making it available for subsequent allocations.

###Disadvantages of Explicit Memory Management:
* Dangling references, ref points to allocation which has been reallocated to a new object.
* Space leaks, memory is allocated and no longer referenced but is not released.

###Garbage Collector:
* Allocating Memory.
* Ensuring that any referenced objects remain in memory.
* Recovering memory used by objects that are no longer reachable from references from executing code.

###Advantages of GC:
* Frees user from responsibility of memory allocation and deallocation.
* Reduces memory leaks.

###Disadvantages of GC:
* Performance Hit, complex task taking time and resources of its own.
* No fine-grain control.
* Cannot force GC.

###Three important criteria of GC:
* Throughput: The amount of work done by an application as a ratio of time spent in GC.
* Latency: The time taken by systems in responding to events which is impacted by pauses introduced by GC.
* Memory:
