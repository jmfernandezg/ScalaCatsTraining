package com.jmfg.training
package t13


import t10.ByteEncoder

import scala.util.Using


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

implicit object Rot13StringByteEncoder extends ByteEncoder[String] {
  def encode(objc: String): Array[Byte] = {
    val bytes = objc.getBytes
    bytes.map(b => (b + 13).toByte)
  }
}