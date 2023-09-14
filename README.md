# ScalaCatsTraining
Training Scala + Cats / Cats Effect


Based on https://www.udemy.com/course/functional-programming-with-scala-cats/


# Section 2: Type Classes

## 4: Introduction

- Channel: write and read object
    - Simple
    - Inheritance
    - TypeClasses
- Implicits & Helper Methods
- Laws
- Automatic Instance Derivation
- Syntax

## 5: Channel - Any

- Simple Interface
- An unhandled type throws exceptions
- Has two responsibilities: read and write

## 6: Channel - Any - Code

- Code: [FileChannel.sc](src/main/scala/t06/FileChannel.scala)

## 7: Channel - Inheritance

## 8: Channel - Inheritance - Code

- Code: [FileChannelEncodable.sc](src/main/scala/t08/FileChannelEncodable.scala)

## 9: Channel - Type Classes

- Unique responsibility
- Easy to test
- Unhandled type throws compilation error

### Instances of Classes
  

## 10: Channel  - TypeClasses - Code

- Code: [FileEncoderTypeClasses.sc](src/main/scala/t10/FileChannelTypeClasses.scala)



## 11: Channel - TypeClasses - Advantages

- Can be instanced by any type
- Cleaner interface
- Several implementations posible

## 12: TypeClasses: Helper Methods

- Using implicits to provide the type of the class

## 13: Channel  - Implicit - Code

- Code: [FileChannelImplicit.sc](src/main/scala/t13/FileChannelImplicit.scala)


## 16: Implicits - Helper Methods - Code - Instance Method



## 17: Channel - Read
- Add apply to ByteDecoder
- Write an instance of ByteDecoder[String]
- Use the instance to decode an array

## 18: Channel - Read - Code

- Code: [FileChannelImplicit.sc](src/main/scala/t18/ByteDecoder.scala)


## 19. Laws

- Property:: Encoding and decoding a value should return the same value
- Testing Laws with Discipline
- Code: [ByteCodecLaws.sc](src/main/scala/t19/ByteCodecLaws.scala)
 


## 20: Laws  - Code


- Code: [ByteCodecSpec.sc](src/main/scala/t20/ByteCodecSpec.scala)

## 21: Automatic Instance Derivation


- Code: [ByteCodecSpec.sc](src/main/scala/t21/t21.scala)


 ## 24: Summary

- TypeClasses enable
  - Extends type outside of contro
  - Add functionality without modifying the interface
  - Use ad-hoc polymorphism
  - Provide several implementations of the functionality
- Using implicites we can make typeclasses easier to use
- TypeCLasses have laws
- Laws make it easier to test typeclasses

---

# Section 3: Cats Type Classes

## 26: Introduction

### Outline
- Simple typeclasses
  - Eq
  - Order
  - Show
  - Monoid
- Higher Kinded Type
- More TypeClasses
  - Functor
  - Applicative
  - Monad
  - MonadError
  - Foldable
  - Traverse
- Testing

## 27: Eq

- Accounts
```scala

case class Account(id: Long, number: String, balance: BigDecimal, owner: String)

```

- Equality
  - Structural Equality
  - Referential Equality
  - TypeClass Equality

### Eq Laws

- The convention is one uppercase letter
- We use IsEq to return a boolean
- Everybody should be equal to itself
- Symmetry: X == Y => Y == X
- AntiSymmetry X != Y => Y != X
- 


## 28: Eq - Code

- Code: [ByteCodecSpec.sc](src/main/scala/t28/Account.scala)
