package com.jmfg.training
package t18

trait ByteDecoder[A] {
  def decode(bytes: Array[Byte]): Option[A]
}

object ByteDecoder {
  def apply[A](implicit ev: ByteDecoder[A]): ByteDecoder[A] = ev

  def instance[A](f: Array[Byte] => Option[A]): ByteDecoder[A] = (bytes: Array[Byte]) => f(bytes)
}

implicit object StringByteDecoder extends ByteDecoder[String] {
  def decode(bytes: Array[Byte]): Option[String] = Some(new String(bytes))
}

val a: Array[Byte] = Array(98, 105, 101, 110, 32, 58, 41)


object Main extends App {
  println(ByteDecoder[String].decode(a))

}