# MapReduce-Big-Data

## The Data
1. The following data items where each item represents a record on a table; each record is have 3 values (Table name, PK, AttributeValue).
2. The AttributeValue in T2 is the FK for the PK in T1

## The Requirements
1. Write a MapReduce program to do an inner join between T1 and T2.  
The query results should be:  
(A, 1,X)  
(B, 2,X)  
(C, 3,X)  

2. Write a MapReduce program to do a full outer join between T1 and T2.  
The query results should be:  
(A, 1,X)  
(B, 2,X)  
(C, 3,X)  
(null, 4, y)  
(null, 5, y)  
(null, 6, y)  
(null, 7, z)  
(null, 8, z)  

3. Write a MapReduce program to find out the difference between two attributes.  
For example : A1[T1] – A1[T2] , The result would [4,5,6,7,8]

## The Benefits of MapReduce
1. MapReduce is used for parallel computing and offline computing of large-scale datasets (larger than 1 TB).
2. Highly abstract programming ideas: Programmers only need to describe what to do, and the execution framework will process the work accordingly. 
3. Outstanding scalability: Cluster capabilities can be improved by adding nodes.
4. High fault tolerance: Cluster availability and fault tolerance are improved using policies, such as computing or data migration.
