package com.jmfg.training
package t06


import java.io.FileOutputStream
import java.nio.ByteBuffer
import scala.util.Using

trait Channel {
  def write(obj: Any): Unit

}

object FileChannel extends Channel {
  override def write(obj: Any): Unit = {
    val bytes: Array[Byte] = obj match {
      case n: Int => ByteBuffer.allocate(4).putInt(n).array()
      case s: String => s.getBytes
      case _ => throw new IllegalArgumentException("Not supported type")

    }


    Using(new FileOutputStream("src/main/resources/fileChannel.txt")) { file =>
      file.write(bytes)
      file.flush()
    }
  }
}

