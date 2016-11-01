The Java Memory Model (JMM) defines the allowable behavior of multithreaded programs, and therefore describes when such reorderings are possible. It places execution-time constraints on the relationship between threads and main memory in order to achieve consistent and reliable Java applications. By doing this, it makes it possible to reason about code execution in a multithreaded environment, even in the face of optimizations performed by the dynamic compiler, the processor(s) and the caches.