package com.jmfg.training
package s02typeClasses

import scala.util.Using


implicit object StringByteEncoder extends ByteEncoder[String] {
  def encode(value: String): Array[Byte] = value.getBytes
}

trait ChannelImplicit {

  def write[A](objc: A)(implicit enc: ByteEncoder[A]): Unit
}


object FileChannelImplicit extends ChannelImplicit {
  def write[A](objc: A)(implicit enc: ByteEncoder[A]): Unit = {
    val bytes = enc.encode(objc)
    Using(new java.io.FileOutputStream("src/main/resources/FileChannelImplicit.txt")) { fos =>
      fos.write(bytes)
      fos.flush()
    }
  }
}