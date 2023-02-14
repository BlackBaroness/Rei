## Nullability

As we use `NullnessChecker` from `checkerframework`, any field or argument is not-null
by default. If you want to make something nullable, you must add an annotation
`@Nullable`.

For example, this code:

```java
public class Test {

    void a() {
        test(null);
    }

    void test(String s) {

    }
}
```

will not compile. But this:

```java
public class Test {

    void a() {
        test(null);
    }

    void test(@Nullable String s) {

    }
}
```

will.

## Optionals

Java `Optional` class can be very useful, but we follow some rules to avoid problems
with it:

1. Never, ever, use null for an Optional variable or return value.
2. Never use Optional.get() unless you can prove that the Optional is present.
3. Prefer alternative APIs over Optional.isPresent() and Optional.get().
4. It’s generally a bad idea to create an Optional for the specific purpose of chaining methods from it to get a value.
5. Avoid using Optional in fields, method parameters, and collections.
6. Don’t use an Optional to wrap any collection type (List, Set, Map). Instead, use an empty collection to represent the
   absence of values.

All that rules are covered by `checkerframework` and you will cannot compile project
without following them.
