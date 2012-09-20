# scaredis

A simple redis client for scala.

# Syntax

```scala
    val redis = RedisClient() // Defaults to "localhost", 6379
    redis choose // Pick a database
    redis += // item[s]
    redis -= // Remove item[s]
    redis ?? // Get an item back wrapped in a future
```

# TODO

- Read responses and figure out types and how to handle errors.
- RedisClient#apply should only give back the interface to send/get to the redis connection. (Not the meta info)
- Better support for writing data structures (we should be able to do something nice for products.) (case classes should be easy)
- Setup some tests (with a mock connection)
- Setup the commands to be added with a connection. (And as the response from a RedisClient)
- Futures for getting data/objects back from the server.
- Bulk reads and writes.
