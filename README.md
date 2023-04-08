# MapReduce-Big-Data-Course-Assignment

## The Data
1. The following data items where each item represents a record on a table; each record is have 3 values (Table name, PK, AttributeValue).
2. The AttributeValue in T2 is the FK for the PK in T1

## The Requirements
1. Write a map/reduce program to do an inner join between T1 and T2 where A1 in T1 is a foreign key in T2. 
The query results should be:
- (A, 1,X)
- (B, 2,X)
- (C, 3,X)

2. Write a map/reduce program to do a full outer join between T1 and T2 where A1 in T1 is a foreign key in T2. 
The query results should be:
- (A, 1,X)
- (B, 2,X)
- (C, 3,X)
- (null, 4, y)
- (null, 5, y)
- (null, 6, y)
- (null, 7, z)
- (null, 8, z)

3. Write a map/reduce program to find out the difference between two attributes. For example : A1[T1] – A1[T2] , The result would [4,5,6,7,8]
