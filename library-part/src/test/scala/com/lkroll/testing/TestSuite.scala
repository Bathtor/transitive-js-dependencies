package com.lkroll.testing

import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.matchers.should._
import org.scalatest.funsuite._

class TestSuite extends AnyFunSuite with Matchers with TypeCheckedTripleEquals {
	test("Should read version number") {
		TestJSCode.version should be("1.0.0");
	}
}
