package com.jmfg.training
package t19

import org.typelevel.discipline.Laws

trait ByteDecoder[A] {
  def decode(bytes: Array[Byte]): Option[A]
}

trait ByteEncoder[A] {
  def encode(a: A): Array[Byte]
}



trait ByteCodec[A] extends ByteDecoder[A] with ByteEncoder[A]

trait ByteCodecLaws[A] extends Laws {
  def codec: ByteCodec[A]

  def isomorphisms(a: A)(implicit codec: ByteCodec[A]): Boolean = {
    codec.decode(codec.encode(a)).contains(a)

  }
}

object Main extends App {
  println("Hello World")
}