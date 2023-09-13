package com.jmfg.training

import t06.FileChannel
import t08.{FileChannelEncodable, FullName}
import t10.{ByteEncoder, FileChannelTypeClasses, IntByteEncoder}
import t13.FileChannelImplicit

val faker = new com.github.javafaker.Faker()
@main
def main(): Unit = {

  s02()

}

def s02(): Unit = {

  FileChannel.write(faker.princessBride().quote())

  FileChannelEncodable.write(FullName(faker.name().firstName(), faker.name().lastName()))

  FileChannelTypeClasses.write[Int](value = faker.number().randomDigit(), IntByteEncoder)

  FileChannelImplicit.write(faker.buffy().quotes())

  val encoded = implicitly[ByteEncoder[String]].encode("Hello World")
  println(encoded.mkString("Array(", ", ", ")"))

  println("Finished Section 2")


}