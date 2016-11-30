###SQL: Structured Query Language
SQL is a declarative language for querying data. A declarative language is one in which a programmer specifies what they want the system to do, rather than procedurally defining how the system should do it.

A significant architectural component of most relational database is query optimizer,  which decides which of the many logically equivalent query plans to execute to most quickly answer a query.

Relational databases follow relational data model. This model defines highly structured entities with strict relationships between them. Querying this model with SQL allows complex data traversals without too much custom development.

*Disadvantages:*
1. Complexity leads to unpredictability: Cost of each query and overall system workload.
2. There are many ways to model a problem: Too restrictive
3. If data grows beyond capacity, need to denormalize data to avoid partition over networks.

FROM -> WHERE CLAUSE -> GROUP BY -> SELECT -> ORDER BY

*Query Optimization:*

Compilation stages:
SQL Query -> Parser -> Semantic Analyzer -> Optimizer -> Code Generator -> Executable Code

Optimizer determines the cost of a plan based on:

1. Evaluation of expressions and conditions
2. Statement transformation: correlated queries and views might be transformed to equivalent join.
3. Choice of optimizer approach : RBO/CBO
4. Choice of access paths
5. Table and column statistics
6. Metadata information (such as referential integrity, primary key)
7. Index choices
8. Scan methods (full table scan, rowid lookup, range index scan, bitmap index lookup, hash index lookup)
9. Join algorithm choice ( nested loops joins, nested loop joins with indexes, or merge join )

Query optimization happens only once for each query while the query itself may be executed many times. Gives precedence to execution time over optimization time, emphasize performance over memory usage.

Nested loops give better response time (used in interactive appln), merge joins give better throughput (used in batch).

Understanding JOINS
Joins are statements that retrieve data from more than one table. A join is characterized by multiple tables in the FROM clause, and the relationship between the tables is defined through the existence of a join condition in the WHERE clause.

###ACID

*Atomic:*
Each transaction is "all or nothing"

*Consistent:*
Makes sure db reaches from one consistent state to another. Indexes, constraints and other parameters are maintained.

*Isolation:*
One task should not impact another task, concurrency issues.

*Isolation level*
*Serializable:* Acquire read and write locks including range locks.
*Repeatable reads:* Range locks are not managed, hence phantom reads can occur.
*Read committed:* Keeps write locks until the end of transaction, but read locks are released as soon as select operation is performed, hence non-repeatable reads can occur.
*Read uncommitted:*

*Phantom reads:*
During transaction, two identical queries are executed, and the collection(New inserts or deletes) of rows returned by second query is different from the first. This occurs when range locks are not acquired.

*Non-repeatable reads:*
During transaction, a row is retrieved twice and the values within the row differ between reads.

*Durable:*
Once a value is updated, it will be written to a stable storage and recoverable if the database crashes.

*Distinct:*
Will sort the result and implicitly apply group by. Uses temp space for sorting, query will be slow since it is using common temp space.

*Join Vs Subqueries:*
One table with more records and another table with relatively very less number of records, then it is ok to use sub query. But if both tables have large data then you would want to see hash join
If we could filter records from one table using index on column and use that value to query another table then go for sub-query, but if both tables have almost equal records then join.
