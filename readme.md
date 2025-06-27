**What is Batch Processing**

```
Batch Processing -> Processing of a finite amount of data without interaction or interuption

Batch processing Use Cases

(a)ETL - Extract, Transform, LOAD
(b)Reporting
(c)BIG DATA
(d)DataScience
(e)Non Interactive processing

```

**Set Up of a Spring Batch Job**

```
There are tow ways for setup of a spring batch Job

(a)ChunkStep ->Spring reads your data in chunks
In the ChunkStep, we have the reader, processor,writer

(b)TaskLet

We just have execute, and it repeats a task until its finished
or until exception or until null is returned
```
*FEATURES*

```
1.JOB Flow State Machine

(A JOB is a flow, it is a collection of independent processing steps )

(You transition from Step 1, Step2, Step 3....)

2.Transaction Handling

Breaking large inputs into small chunks (1,000,000)

Divide into chunks.
Maintain state, as you commit incremantally you can be able to restart at the point at which you failed

3.Declarative IO

Spring batch gives you out of the box readers and writers and processors helping us focus on business logic instead of how to read a file

4.Robust Error Handling

We have many laundry list of error handling capabilites to minimize on the capability of errors and give us ability to react accordingly in scope of framework

5.Scalability Options

Can handle large amounts of data, between one JVM and multiple JVMS

6.Battle Tested

components used are well tested

7.Built of Spring

Configuring application context etc

```

```
Spring Batch Project One

1.How to read a file with data using spring batch and save data to the database after transformation.

2.How to read data from rest endpoint and how to tranform it and save it to DB

3.How to schedule spring batch execution.

```


```
To start a Spring Batch Job via a rest, you need to hook your reader to
the GET Call,

So that when you call the request, you start the process

```

**Scheduling a Batch Job**

```

Step One
(We disable the Batch Job from executing at startUp)

spring.batch.job.enabled=false
To be able to restart a scheduled Job,it needs to be launched with some unique params
otherwise Spring will not be able to distinguish it.

```

**Chaining Jobs**

```
We can chain many Jobs by using next

```