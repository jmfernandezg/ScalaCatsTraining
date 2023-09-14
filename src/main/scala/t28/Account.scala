package com.jmfg.training
package t28

import cats.*
import cats.implicits.*

case class Account(id: Long, number: String, balance: Double, owner: String)

object Account {
  implicit val universalEq: Eq[Account] = Eq.fromUniversalEquals

  object Instances {
    implicit def byIdEq(implicit eqLong: Eq[Long]): Eq[Account] = Eq.instance[Account]((a1, a2) => eqLong.eqv(a1.id, a2.id))

    implicit def byIdEq2(implicit eqLong: Eq[Long]): Eq[Account] = Eq.by(_.id)

    // compare account by number
    implicit def byNumber(implicit eqString: Eq[String]): Eq[Account] = Eq.by(_.number)
  }
}


object Main extends App {
  private val acc1 = Account(1, "123", 1000, "John")
  private val acc2 = Account(2, "123", 1500, "Jane")

  println(Eq[Account].eqv(acc1, acc2))
  println(Account.instances.byIdEq.eqv(acc1, acc2))
  println(Account.instances.byNumber.eqv(acc1, acc2))
  println(acc1 === acc2)

  import Account.Instances._

  println(acc1 === acc2)
}