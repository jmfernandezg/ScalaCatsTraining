package com.jmfg.training
package t20

import org.scalacheck.Arbitrary
import org.scalacheck.Prop.forAll
import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.prop.Configuration
import org.typelevel.discipline.Laws
import org.typelevel.discipline.scalatest.FunSuiteDiscipline

import java.nio.ByteBuffer


trait ByteDecoder[A] {
  def decode(bytes: Array[Byte]): Option[A]
}

trait ByteEncoder[A] {
  def encode(a: A): Array[Byte]
}

trait ByteCodec[A] extends ByteDecoder[A] with ByteEncoder[A]

trait ByteCodecLaws[A] {
  def codec: ByteCodec[A]

  def isomorphism(a: A): Boolean = {
    codec.decode(codec.encode(a)) == Some(a)
  }
}


trait ByteCodecTests[A] extends Laws {
  def laws: ByteCodecLaws[A]

  def codec(implicit arbA: Arbitrary[A]): RuleSet = new DefaultRuleSet(
    name = "byteCodec",
    parent = None,
    "isomorphism" -> forAll {
      laws.isomorphism _
    }
  )
}

object IntByteCodec extends ByteCodec[Int] {
  override def decode(bytes: Array[Byte]): Option[Int] = {
      Some(ByteBuffer.allocate(4).put(bytes).flip().getInt)

  }

  override def encode(a: Int): Array[Byte] = {
    ByteBuffer.allocate(4).putInt(a).array()
  }
}

object IntByteCodecLaws extends ByteCodecLaws[Int] {
  override def codec: ByteCodec[Int] = IntByteCodec
}

object IntByteCodecTests extends ByteCodecTests[Int] {
  override def laws: ByteCodecLaws[Int] = IntByteCodecLaws
}

object ByteCodecSpec extends AnyFunSuite with Configuration with FunSuiteDiscipline {
  checkAll("ByteCodec[Int]", IntByteCodecTests.codec)
}