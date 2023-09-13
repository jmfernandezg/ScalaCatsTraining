package com.jmfg.training
package t16


trait ByteEncoder[A] {
  def encode(a: A): Array[Byte]
}

object ByteEncoder {
  implicit val stringByteEncoder: ByteEncoder[String] = (a: String) => a.getBytes

  def instance[A](f: A => Array[Byte]): ByteEncoder[A] = (a: A) => f(a)
}

implicit object Rot13StringByteEncoder extends ByteEncoder[String] {
  def encode(a: String): Array[Byte] = a.map(c => (c + 13).toByte).toArray
}
