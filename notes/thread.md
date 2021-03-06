###JVM Threads
1. Main Thread
2. Memory Management Thread
3. System Management
4. Signal Procession

###Benefits of Threads:
1. Threads are lightweight compared to processes, it takes less time and resource to create a thread.
2. Threads share their parent process data and code.
3. Context switching between threads is usually less expensive than between processes.
4. Thread intercommunication is relatively easy than process communication.

###Why wait(), notify() and notifyAll() must be called from synchronized block or method in Java?
To avoid race condition, if T1 has checked on some condition and decided to wait, context-switch happens and T2 satisfies the condition and issues notify() which is unheard by T1 since it is not yet waiting, hence T1 will miss this notification and will still go in wait(). In short, before waiting lock must be acquired so that no one else should be able to notify before it starts waiting and hence it wont miss the notification signal.

###Why Should I not call sleep()/yield() method on any other Thread?
Because it is error prone and can cause deadlock, if one Thread asks another thread to go to sleep, it wont release the lock and if the thread which is going to resume it needs the lock held by sleeping thread then there is a dead lock (not really, sleep do not sleep indefinitely like Suspend and do not need notification to wake up ). Same reason with Suspend. ?

###How can we achieve thread safety in Java?
1. Synchronization
2. Atomic Classes
3. Immutable Classes
4. Lock Interface
5. Volatile
6. Thread safe classes

###What happens when exception occurs in Thread?
If not caught thread will die, if an uncaught exception handler is registered then it will get a callback. JVM will query the thread for its uncaughtexception handler using Thread.getUnCaughtExceptionHandler() and will invoke the handler’s uncaughtException(), passing thread and the exception as arguments.

###Difference between interrupted() and isInterrupted()?
Former clears the interrupt status while the later does not.
Thread.interrupt() sets this flag.
status is cleared after IE is thrown.

###Difference between volatile and atomic?
Volatile guarantees happens-before that a write will happen before any subsequent write. atomic variables provide option to perform compound operation atomically.

###Why String is immutable?
1. Cache hashcode value and can be used in HashMap
2. Security issue, accessing any file by changing name or loading class. Used as parameters in many Java classes.
3. Can be shared safely between threads.
4. String pool.
