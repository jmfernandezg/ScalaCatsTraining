package com.jmfg.training

import s02typeClasses.{FileChannel, FileChannelEncodable, FileChannelImplicit, FileChannelTypeClasses, FullName, IntByteEncoder, StringByteEncoder}

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

  println("Finished Section 2")

}