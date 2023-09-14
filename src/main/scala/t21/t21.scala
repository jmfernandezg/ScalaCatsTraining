package com.jmfg.training
package t21


import java.nio.ByteBuffer

trait ByteEncoder[A] {
  def encode(a: A): Array[Byte]
}

object ByteEncoder {
  def apply[A](implicit enc: ByteEncoder[A]): ByteEncoder[A] = enc
}

implicit object StringByteEncoder extends ByteEncoder[String] {
  def encode(a: String): Array[Byte] = a.getBytes
}

implicit object IntByteEncoder extends ByteEncoder[Int] {
  def encode(a: Int): Array[Byte] = ByteBuffer.allocate(4).putInt(a).array()
}

implicit object OptionString extends ByteEncoder[Option[String]] {
  override def encode(a: Option[String]): Array[Byte] = a match {
    case Some(s) => StringByteEncoder.encode(s)
    case None => Array.empty[Byte]
  }
}

implicit def optionEncoder[A](implicit enc: ByteEncoder[A]): ByteEncoder[Option[A]] = new ByteEncoder[Option[A]] {
  override def encode(a: Option[A]): Array[Byte] = a match {
    case Some(s) => enc.encode(s)
    case None => Array.empty[Byte]
  }
}

object Main extends App {
  println(ByteEncoder[String].encode("Hello").mkString("Array(", ", ", ")"))
  println(ByteEncoder[Int].encode(123).mkString("Array(", ", ", ")"))
  println(ByteEncoder[Option[String]].encode(None).mkString("Array(", ", ", ")"))
  println(ByteEncoder[Option[String]].encode(Option("HEY")).mkString("Array(", ", ", ")"))
}
