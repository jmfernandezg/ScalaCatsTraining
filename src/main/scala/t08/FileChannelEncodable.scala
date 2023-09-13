package com.jmfg.training
package t08


import java.io.FileOutputStream
import scala.util.Using

trait ByteEncodable {
  def encode: Array[Byte]
}

trait ChannelEncodable {
  def write(obj: ByteEncodable): Unit

}

case class FullName(firstName: String, lastName: String) extends ByteEncodable {
  override def encode: Array[Byte] = s"$firstName $lastName".getBytes

}

object FileChannelEncodable extends ChannelEncodable {
  override def write(obj: ByteEncodable): Unit =
    val bytes = obj.encode
    Using(new FileOutputStream("src/main/resources/fileChannelEncodable.txt")) { file =>
      file.write(bytes)
      file.flush()
    }
}


