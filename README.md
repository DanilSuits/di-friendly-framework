# Inspiration

* [Seemann, 2014][1]
* [Parnas, 1971][2]

# Explanation

How do we test that a module satisfies a contract?

How do we minimize the coupling between the implementation
of the module and the client?

Seemann proposes a challenging idea - that the entry point
to the custom implementation is a _no argument constructor_.
Given the name of the entry point, an instance of it can be
created, and then you can follow the protocols from there
to navigate to the functionality required by the client.

In this particular case, he proposes that the root of the module
is a factory that understands `T create(...)` and `void release(T)`.

# Experience

The value of `void release(T)` isn't immediately obvious; in part
because the trivial implementation of release doesn't tell me
very much, and partly because java does have `Closeable` and
`AutoCloseable` which serve much the same purpose.

On the other hand, it is one less dependency to force into the mix.
It is straight forward enough for each side of the seam to introduce
the dependency if it is convenient.









[1]: http://blog.ploeh.dk/2014/05/19/di-friendly-framework/
[2]: https://repository.cmu.edu/cgi/viewcontent.cgi?article=2979&context=compsci