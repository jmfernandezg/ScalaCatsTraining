package com.jmfg.training
package s02typeClasses

import java.io.FileOutputStream
import java.nio.ByteBuffer
import scala.util.Using

trait ByteEncoder[A] {
  def encode(value: A): Array[Byte]
}

trait ChannelEncoder {
  def write[A](value: A, enc: ByteEncoder[A]): Unit
}

object FileChannelTypeClasses extends ChannelEncoder {
  override def write[A](value: A, enc: ByteEncoder[A]): Unit = {
    val bytes = enc.encode(value)

    Using(new FileOutputStream("src/main/resources/fileChannelTypeClasses.txt")) { fos =>
      fos.write(bytes)
      fos.flush()
    }
  }
}


object IntByteEncoder extends ByteEncoder[Int] {
  override def encode(value: Int): Array[Byte] = ByteBuffer.allocate(4).putInt(value).array()
}

